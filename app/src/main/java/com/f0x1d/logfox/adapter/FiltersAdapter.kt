package com.f0x1d.logfox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.f0x1d.logfox.adapter.base.BaseAdapter
import com.f0x1d.logfox.database.UserFilter
import com.f0x1d.logfox.databinding.ItemFilterBinding
import com.f0x1d.logfox.ui.viewholder.FilterViewHolder

class FiltersAdapter(
    private val click: (UserFilter) -> Unit,
    private val delete: (UserFilter) -> Unit,
    private val checked: (UserFilter, Boolean) -> Unit
): BaseAdapter<UserFilter, ItemFilterBinding>() {

    override fun createHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = FilterViewHolder(
        binding = ItemFilterBinding.inflate(layoutInflater, parent, false),
        click = click,
        delete = delete,
        checked = checked
    )

    override fun getItemId(position: Int) = elements[position].id
}