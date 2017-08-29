package com.myrecipe.remote

import com.myrecipe.remote.dto.CategoryDto

/**
 * 菜谱服务器交互 接口
 * Created by sun on 2017/8/28.
 */
interface IRecipeRO {

    /**
     * 获取分类
     */
    fun getCategoryList(): List<CategoryDto>?
}