package com.f0x1d.logfox.model

import androidx.annotation.Keep
import com.f0x1d.logfox.extensions.logsFormatted

data class LogLine(
    val id: Long,
    val dateAndTime: Long,
    val pid: String,
    val tid: String,
    val level: LogLevel,
    val tag: String,
    val content: String
) {
    val original get() = "${dateAndTime.logsFormatted} $pid $tid ${level.letter}/$tag: $content"
}

@Keep
enum class LogLevel(val letter: String) {
    VERBOSE("V"),
    DEBUG("D"),
    INFO("I"),
    WARNING("W"),
    ERROR("E"),
    FATAL("F"),
    SILENT("S")
}