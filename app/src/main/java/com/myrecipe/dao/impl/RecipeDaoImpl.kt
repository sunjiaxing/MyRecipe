package com.myrecipe.dao.impl

import com.myrecipe.common.insert
import com.myrecipe.dao.IRecipeDao
import com.myrecipe.dao.entity.Category
import io.realm.Realm

/**
 * 数据库 接口实现类
 * Created by sun on 2017/8/30.
 */
class RecipeDaoImpl : IRecipeDao {

    /**
     * 通过parentId获取 分类列表
     */
    override fun getCategoryListByParentId(parentId: Int): List<Category> {
        val realm = Realm.getDefaultInstance()
        val all = realm.where(Category::class.java).equalTo(Category::parentId.name, parentId).findAll()
        var result = emptyList<Category>()
        all?.let { result = realm.copyFromRealm(it) }
        realm.close()
        return result
    }

    /**
     * 插入分类数据
     */
    override fun insertCategory(category: Category) = category.insert()
}