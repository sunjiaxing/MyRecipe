package com.myrecipe.ui.activity

import android.os.Bundle
import android.os.Handler
import com.myrecipe.R
import com.myrecipe.remote.IParams
import com.myrecipe.ui.fragment.CookingFragment
import com.myrecipe.ui.fragment.MainPageFragment
import com.myrecipe.ui.fragment.RoundFragment
import kotlinx.android.synthetic.main.act_main.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.textColor

/**
 * 主页
 * Created by sun on 2017/8/28.
 */
class MainActivity : BaseActivity() {

    enum class MenuType {MAIN, ROUND, COOKING }

    val handler by lazy { Handler() }
    var currentSelect = MenuType.MAIN
    var mainFragment: MainPageFragment? = null
    var roundFragment: RoundFragment? = null
    var cookingFragment: CookingFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        layout_main_page.onClick {
            // 重复点击 执行刷新
            currentSelect = MenuType.MAIN
            refreshSelectState()
        }
        layout_round.onClick {
            // 重复点击，无变化
            if (currentSelect == MenuType.ROUND) return@onClick
            currentSelect = MenuType.ROUND
            refreshSelectState()
        }
        layout_cooking.onClick {
            // 重复点击，无变化
            if (currentSelect == MenuType.COOKING) return@onClick
            currentSelect = MenuType.COOKING
            refreshSelectState()
        }

    }

    override fun onResume() {
        super.onResume()
        refreshSelectState()
    }

    /**
     * 刷新选中状态
     */
    private fun refreshSelectState() {
        hideAllFragment()
        resetImageAndText()
        when (currentSelect) {
            MenuType.MAIN -> {
                iv_main_page.imageResource = R.mipmap.icon_main_page_selected
                tv_main_page.textColor = resources.getColor(R.color.c_ff6600)
                showMainFragment()
            }
            MenuType.ROUND -> {
                iv_round.imageResource = R.mipmap.icon_round_selected
                tv_round.textColor = resources.getColor(R.color.c_ff6600)
                showRoundFragment()
            }
            MenuType.COOKING -> {
                iv_cooking.imageResource = R.mipmap.icon_message_selected
                tv_cooking.textColor = resources.getColor(R.color.c_ff6600)
                showCookingFragment()
            }
        }
    }

    /**
     * 显示 制作中 fragment
     */
    private fun showCookingFragment() {
        val ft = supportFragmentManager.beginTransaction()
        if (cookingFragment == null) {
            cookingFragment = CookingFragment()
            ft.add(R.id.layout_contain, cookingFragment, IParams.COOKING)
        } else ft.show(cookingFragment)
        ft.commit()
        // 刷新数据
        handler.postDelayed({
            cookingFragment?.refreshView()
        }, 50)
    }

    /**
     * 显示 随心配 fragment
     */
    private fun showRoundFragment() {
        val ft = supportFragmentManager.beginTransaction()
        if (roundFragment == null) {
            roundFragment = RoundFragment()
            ft.add(R.id.layout_contain, roundFragment, IParams.ROUND)
        } else ft.show(roundFragment)
        ft.commit()
        // 刷新数据
        handler.postDelayed({
            roundFragment?.refreshView()
        }, 50)
    }

    /**
     * 显示首页fragment
     */
    private fun showMainFragment() {
        val ft = supportFragmentManager.beginTransaction()
        if (mainFragment == null) {
            mainFragment = MainPageFragment()
            ft.add(R.id.layout_contain, mainFragment, IParams.MAIN)
        } else ft.show(mainFragment)
        ft.commit()
        // 刷新数据
        handler.postDelayed({
            mainFragment?.refreshView()
        }, 50)
    }

    /**
     * 隐藏所有fragment
     */
    private fun hideAllFragment() {
        mainFragment = supportFragmentManager.findFragmentByTag(IParams.MAIN)?.let { it as MainPageFragment }
        roundFragment = supportFragmentManager.findFragmentByTag(IParams.ROUND)?.let { it as RoundFragment }
        cookingFragment = supportFragmentManager.findFragmentByTag(IParams.COOKING)?.let { it as CookingFragment }
        val ft = supportFragmentManager.beginTransaction()
        mainFragment?.let { ft.hide(it) }
        roundFragment?.let { ft.hide(it) }
        cookingFragment?.let { ft.hide(it) }
        ft.commit()
    }

    /**
     * 重置菜单中图片和文字
     */
    private fun resetImageAndText() {
        iv_main_page.imageResource = R.mipmap.icon_main_page_normal
        iv_round.imageResource = R.mipmap.icon_round_normal
        iv_cooking.imageResource = R.mipmap.icon_message_normal
        tv_main_page.textColor = resources.getColor(R.color.c_58585a)
        tv_round.textColor = resources.getColor(R.color.c_58585a)
        tv_cooking.textColor = resources.getColor(R.color.c_58585a)
    }

}