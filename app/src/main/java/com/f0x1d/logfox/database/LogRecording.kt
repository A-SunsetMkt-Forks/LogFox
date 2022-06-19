package com.f0x1d.logfox.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity
data class LogRecording(@ColumnInfo(name = "date_and_time") val dateAndTime: Long,
                        @ColumnInfo(name = "log") val log: String,
                        @PrimaryKey(autoGenerate = true) val id: Long = 0)

@Dao
interface LogRecordingDao {

    @Query("SELECT * FROM LogRecording ORDER BY date_and_time DESC")
    fun getAll(): List<LogRecording>

    @Query("SELECT * FROM LogRecording WHERE id = :id")
    fun get(id: Long): Flow<LogRecording?>

    @Insert
    fun insert(logRecording: LogRecording): Long

    @Query("DELETE FROM LogRecording WHERE id = :id")
    fun delete(id: Long)

    @Query("DELETE FROM LogRecording")
    fun deleteAll()
}