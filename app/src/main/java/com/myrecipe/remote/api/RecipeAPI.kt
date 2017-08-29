package com.myrecipe.remote.api

import com.myrecipe.remote.dto.APIResponse
import com.myrecipe.remote.dto.CategoryDto
import retrofit2.Call
import retrofit2.http.GET

/**
 * 菜谱 API（retrofit实现）
 * Created by sun on 2017/8/29.
 */
interface RecipeAPI {

    /**
     * 获取分类列表
     */
    @GET("recipe/class")
    fun getCategoryList(): Call<APIResponse<List<CategoryDto>>>
}