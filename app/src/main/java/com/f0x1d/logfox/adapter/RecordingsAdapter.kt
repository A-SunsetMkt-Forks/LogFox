package com.f0x1d.logfox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.f0x1d.logfox.adapter.base.BaseAdapter
import com.f0x1d.logfox.database.LogRecording
import com.f0x1d.logfox.databinding.ItemRecordingBinding
import com.f0x1d.logfox.ui.viewholder.RecordingViewHolder

class RecordingsAdapter(private val block: (LogRecording) -> Unit): BaseAdapter<LogRecording, ItemRecordingBinding>() {

    override fun createHolder(layoutInflater: LayoutInflater, parent: ViewGroup) = RecordingViewHolder(
        ItemRecordingBinding.inflate(layoutInflater, parent, false),
        block
    )
}