package com.myrecipe.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myrecipe.R
import com.myrecipe.service.IRecipeService
import com.myrecipe.service.impl.RecipeServiceImpl
import com.myrecipe.ui.adapter.CategoryAdapter
import com.myrecipe.ui.vo.CategoryVO
import kotlinx.android.synthetic.main.common_tool_bar.*
import kotlinx.android.synthetic.main.fra_main_page.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.uiThread

/**
 * 首页fragment
 * Created by sun on 2017/8/29.
 */
class MainPageFragment : BaseFragment() {

    private val recipeService: IRecipeService by lazy { RecipeServiceImpl() }
    var list: List<CategoryVO> = emptyList()
    var adapter: CategoryAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fra_main_page, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = "选菜品"
        line.visibility = View.VISIBLE
        tv_search.onClick { clickSearch() }
        layout_refresh.setColorSchemeColors(resources.getColor(R.color.c_ff6600), Color.GREEN, Color.BLUE)
        layout_refresh.onRefresh { refreshData() }
        recycler_view.layoutManager = GridLayoutManager(context, 2)
    }


    private fun clickSearch() {

    }

    /**
     * 刷新view(由外部调用)
     */
    fun refreshView() {
        if (list.isEmpty()) {
            layout_refresh.measure(0, 0)
            layout_refresh.isRefreshing = true
            getDataFromDB()
        }
    }

    /**
     * 从本地库中获取数据
     */
    private fun getDataFromDB() {
        doAsync {
            try {
                list = recipeService.getCategoryFromDB()
                uiThread {
                    if (list.isEmpty()) refreshData()
                    else refreshUI()
                }
            } catch (e: Exception) {
                uiThread {
                    layout_refresh.isRefreshing = false
                    toast(e.message.orEmpty())
                }
            }
        }
    }

    /**
     * 刷新数据
     */
    private fun refreshData() {
        doAsync {
            try {
                list = recipeService.refreshCategory()
                uiThread {
                    refreshUI()
                }
            } catch (e: Exception) {
                uiThread {
                    layout_refresh.isRefreshing = false
                    toast(e.message.orEmpty())
                }
            }
        }
    }


    /**
     * 刷新UI
     */
    private fun refreshUI() {
        layout_refresh.isRefreshing = false
        if (adapter == null) {
            adapter = CategoryAdapter(context)
            adapter?.listener = View.OnClickListener { v ->
                clickCategory(v.tag as Int)
            }
            adapter?.list = list
            recycler_view.adapter = adapter
        } else {
            adapter?.list = list
            adapter?.notifyDataSetChanged()
        }
    }

    private fun clickCategory(position: Int) {

    }

}