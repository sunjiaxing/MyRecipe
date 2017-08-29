package com.myrecipe.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myrecipe.R

/**
 * 首页fragment
 * Created by sun on 2017/8/29.
 */
class MainPageFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fra_main_page, container, false)
    }

    fun refreshView() {

    }

}