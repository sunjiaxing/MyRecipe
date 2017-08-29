package com.myrecipe.remote.impl

import com.myrecipe.exception.AppException
import com.myrecipe.remote.IRecipeRO
import com.myrecipe.remote.api.RecipeAPI
import com.myrecipe.remote.dto.CategoryDto

/**
 * 实现类
 * Created by sun on 2017/8/29.
 */
class RecipeROImpl : BaseRO<RecipeAPI>(RecipeAPI::class.java), IRecipeRO {

    /**
     * 获取分类列表
     */
    override fun getCategoryList(): List<CategoryDto>? {
        val response = api.getCategoryList().execute().body()
        if (response.status == "0") return response.result
        throw AppException(response.msg)
    }
}