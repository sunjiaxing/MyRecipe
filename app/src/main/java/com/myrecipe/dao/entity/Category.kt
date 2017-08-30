package com.myrecipe.dao.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by sun on 2017/8/30.
 */
open class Category : RealmObject() {

    @PrimaryKey
    var classId = 0
    var categoryName = ""
    var parentId = 0
}