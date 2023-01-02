package com.f0x1d.logfox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.f0x1d.logfox.adapter.base.BaseAdapter
import com.f0x1d.logfox.database.AppCrash
import com.f0x1d.logfox.databinding.ItemCrashBinding
import com.f0x1d.logfox.ui.viewholder.CrashViewHolder

class CrashesAdapter(
    private val click: (AppCrash) -> Unit,
    private val delete: (AppCrash) -> Unit
): BaseAdapter<AppCrash, ItemCrashBinding>() {

    override fun createHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = CrashViewHolder(
        ItemCrashBinding.inflate(layoutInflater, parent, false),
        click,
        delete
    )

    override fun getItemId(position: Int) = elements[position].id
}