package com.myrecipe.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myrecipe.R

/**
 * 制作中 fragment
 * Created by sun on 2017/8/29.
 */
class CookingFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fra_cooking, container, false)

    fun refreshView() {

    }
}