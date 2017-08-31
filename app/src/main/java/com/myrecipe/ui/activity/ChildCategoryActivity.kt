package com.myrecipe.ui.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.myrecipe.R
import com.myrecipe.remote.IParams
import com.myrecipe.ui.adapter.ChildCategoryAdapter
import com.myrecipe.ui.vo.CategoryVO
import kotlinx.android.synthetic.main.act_child_category.*
import kotlinx.android.synthetic.main.common_tool_bar.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

/**
 * 子分类列表
 * Created by sun on 2017/8/30.
 */
class ChildCategoryActivity : BaseActivity() {

    var vo: CategoryVO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_child_category)
        line.visibility = View.VISIBLE
        iv_back.visibility = View.VISIBLE
        iv_back.onClick { onBackPressed() }
        vo = intent.getSerializableExtra(IParams.CATEGORY_VO)?.let { it as CategoryVO }
        tv_title.text = vo?.categoryName

        showChildList()
    }

    /**
     * 显示子分类
     */
    private fun showChildList() {
        vo?.let {
            recycler_view.layoutManager = GridLayoutManager(this, 2)
            val adapter = ChildCategoryAdapter(this)
            adapter.list = it.childList.orEmpty()
            adapter.listener = View.OnClickListener { v ->
                clickChildCategory(v.tag as Int)
            }
            recycler_view.adapter = adapter
        }
    }

    /**
     * 子分类点击事件
     */
    private fun clickChildCategory(pos: Int) {
        vo?.let {
            val vo = it.childList?.get(pos)
            toast("click:${vo?.categoryName}")
        }
    }
}