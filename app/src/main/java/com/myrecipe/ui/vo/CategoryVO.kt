package com.myrecipe.ui.vo

import java.io.Serializable

/**
 * 分类
 * Created by sun on 2017/8/29.
 */
class CategoryVO(var classId: Int, var categoryName: String, var parentId: Int) : Serializable {
    var childList: List<CategoryVO>? = null
}