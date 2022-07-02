package com.f0x1d.logfox.viewmodel.recordings

import android.app.Application
import com.f0x1d.logfox.database.AppDatabase
import com.f0x1d.logfox.database.LogRecording
import com.f0x1d.logfox.viewmodel.base.BaseSameFlowProxyViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class RecordingViewModel @AssistedInject constructor(application: Application,
                                                     database: AppDatabase,
                                                     @Assisted private val recordingId: Long): BaseSameFlowProxyViewModel<LogRecording>(
    application,
    database.logRecordingDao().get(recordingId)
)

@AssistedFactory
interface RecordingViewModelAssistedFactory {
    fun create(recordingId: Long): RecordingViewModel
}