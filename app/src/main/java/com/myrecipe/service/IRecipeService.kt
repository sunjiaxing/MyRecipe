package com.myrecipe.service

import com.myrecipe.ui.vo.CategoryVO

/**
 * 业务类接口
 * Created by sun on 2017/8/28.
 */
interface IRecipeService {

    /**
     * 从数据库中获取分类
     */
    fun getCategoryFromDB(): List<CategoryVO>

    /**
     * 刷新分类数据
     */
    fun refreshCategory(): List<CategoryVO>
}