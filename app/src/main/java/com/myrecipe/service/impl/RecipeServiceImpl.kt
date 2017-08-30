package com.myrecipe.service.impl

import com.myrecipe.dao.IRecipeDao
import com.myrecipe.dao.entity.Category
import com.myrecipe.dao.impl.RecipeDaoImpl
import com.myrecipe.remote.IRecipeRO
import com.myrecipe.remote.dto.CategoryDto
import com.myrecipe.remote.impl.RecipeROImpl
import com.myrecipe.service.IRecipeService
import com.myrecipe.ui.vo.CategoryVO

/**
 * 业务类 实现类
 * Created by sun on 2017/8/29.
 */
class RecipeServiceImpl : IRecipeService {

    private val recipeRO: IRecipeRO by lazy { RecipeROImpl() }
    private val recipeDao: IRecipeDao by lazy { RecipeDaoImpl() }

    /**
     * 从本地库中获取数据
     */
    override fun getCategoryFromDB(): List<CategoryVO> {
        val showData = ArrayList<CategoryVO>()
        val parentList = recipeDao.getCategoryListByParentId(0)
        if (parentList.isNotEmpty()) {
            parentList.map {
                val vo = CategoryVO(it.classId, it.categoryName, it.parentId)
                // 获取子课程
                val childList = recipeDao.getCategoryListByParentId(it.classId)
                vo.childList = childList.map { CategoryVO(it.classId, it.categoryName, it.parentId) }
                showData.add(vo)
            }
        }
        return showData
    }

    /**
     * 刷新分类数据
     */
    override fun refreshCategory(): List<CategoryVO> {
        // 获取数据
        val webData = recipeRO.getCategoryList()
        val showData = ArrayList<CategoryVO>()
        webData?.map {
            // 数据存储
            insertCategoryIntoDB(it)
            // ui层展示的 数据转换
            val vo = CategoryVO(it.classid.toInt(), it.name, it.parentid.toInt())
            vo.childList = it.list?.map {
                CategoryVO(it.classid.toInt(), it.name, it.parentid.toInt())
            }
            showData.add(vo)
        }
        return showData
    }

    /**
     * 添加分类信息到 数据库中
     */
    private fun insertCategoryIntoDB(dto: CategoryDto) {
        val cate = Category()
        cate.classId = dto.classid.toInt()
        cate.categoryName = dto.name
        cate.parentId = dto.parentid.toInt()
        recipeDao.insertCategory(cate)
        // 保存子分类
        dto.list?.map { insertCategoryIntoDB(it) }
    }

}