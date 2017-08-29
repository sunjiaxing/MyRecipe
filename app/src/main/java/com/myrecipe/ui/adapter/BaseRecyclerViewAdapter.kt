package com.myrecipe.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View

/**
 * recycler view 适配器父类
 * Created by sun on 2017/8/29.
 */
abstract class BaseRecyclerViewAdapter(ctx: Context) : RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder>() {

    protected val layoutInflater by lazy { LayoutInflater.from(ctx) }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}