package com.myrecipe.dao

import com.myrecipe.dao.entity.Category

/**
 * 数据库操作 接口
 * Created by sun on 2017/8/28.
 */
interface IRecipeDao {

    /**
     * 插入分类数据
     */
    fun insertCategory(category: Category)

    fun getCategoryListByParentId(parentId: Int): List<Category>
}