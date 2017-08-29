package com.myrecipe.ui.vo

/**
 * 分类
 * Created by sun on 2017/8/29.
 */
class CategoryVO(var classId: Int, var categoryName: String, var parentId: Int) {
    var childList: List<CategoryVO>? = null
}