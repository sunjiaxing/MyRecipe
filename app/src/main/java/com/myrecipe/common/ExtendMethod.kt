package com.myrecipe.common

import io.realm.Realm
import io.realm.RealmObject

/**
 * 扩展函数
 * Created by sun on 2017/8/30.
 */


fun RealmObject.insert() {
    val realm = Realm.getDefaultInstance()
    realm.executeTransaction { it.copyToRealmOrUpdate(this) }
    realm.close()
}

fun RealmObject.update() {
    val realm = Realm.getDefaultInstance()
    realm.executeTransaction { it.insertOrUpdate(this) }
    realm.close()
}