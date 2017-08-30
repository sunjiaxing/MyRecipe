package com.myrecipe.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.myrecipe.R
import com.myrecipe.ui.vo.CategoryVO
import kotlinx.android.synthetic.main.adapter_main_page_category.view.*

/**
 * 分类列表适配器
 * Created by sun on 2017/8/29.
 */
class CategoryAdapter(ctx: Context) : BaseRecyclerViewAdapter(ctx) {

    var list: List<CategoryVO> = emptyList()
    var listener: View.OnClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView!!) {
            val vo = list[position]
            tv_name.text = vo.categoryName
            tv_name.tag = position
            tv_name.setOnClickListener(listener)
        }
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(layoutInflater.inflate(R.layout.adapter_main_page_category, parent, false))
}