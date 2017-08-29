package com.myrecipe.remote.dto

/**
 * 分类 dto
 * Created by sun on 2017/8/29.
 */
class CategoryDto {
    var classid = "0"
    var name = ""
    var parentid = "0"
    var list: List<CategoryDto>? = null
}