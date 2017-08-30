package com.myrecipe.ui

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * application
 * Created by sun on 2017/8/28.
 */
class RecipeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initRealm()
    }

    /**
     * 初始化 realm 数据库
     */
    private fun initRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("recipe.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }
}