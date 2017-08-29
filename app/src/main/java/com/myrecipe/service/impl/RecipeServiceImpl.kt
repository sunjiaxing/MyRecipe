package com.myrecipe.service.impl

import com.myrecipe.remote.IRecipeRO
import com.myrecipe.remote.impl.RecipeROImpl
import com.myrecipe.service.IRecipeService
import com.myrecipe.ui.vo.CategoryVO

/**
 * 业务类 实现类
 * Created by sun on 2017/8/29.
 */
class RecipeServiceImpl : IRecipeService {

    private val recipeRO: IRecipeRO by lazy { RecipeROImpl() }

    /**
     * 从本地库中获取数据
     */
    override fun getCategoryFromDB(): List<CategoryVO> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshCategory(): List<CategoryVO> = (1..10).map { CategoryVO(it, "name$it", it) }

    /**
     * 刷新分类数据
     */
    //    override fun refreshCategory(): List<CategoryVO> {
//        // 获取数据
//        val webData = recipeRO.getCategoryList()
//        val showData = ArrayList<CategoryVO>()
//        webData?.map {
//            // 数据存储
//
//            // 数据转换
//            val vo = CategoryVO(it.classid.toInt(), it.name, it.parentid.toInt())
//            vo.childList = it.list?.map {
//                CategoryVO(it.classid.toInt(), it.name, it.parentid.toInt())
//            }
//            showData.add(vo)
//        }
//        return showData
//    }

}