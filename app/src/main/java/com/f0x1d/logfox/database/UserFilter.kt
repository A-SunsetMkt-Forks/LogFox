package com.f0x1d.logfox.database

import androidx.annotation.Keep
import androidx.room.*
import com.f0x1d.logfox.model.LogLevel
import com.f0x1d.logfox.utils.GsonSkip
import kotlinx.coroutines.flow.Flow

@Keep
@Entity
data class UserFilter(
    @ColumnInfo(name = "allowed_levels") val allowedLevels: List<LogLevel> = emptyList(),
    @ColumnInfo(name = "pid") val pid: String? = null,
    @ColumnInfo(name = "tid") val tid: String? = null,
    @ColumnInfo(name = "tag") val tag: String? = null,
    @ColumnInfo(name = "content") val content: String? = null,
    @ColumnInfo(name = "enabled") @GsonSkip val enabled: Boolean = true,
    @PrimaryKey(autoGenerate = true) @GsonSkip val id: Long = 0
)

@Dao
interface UserFilterDao {

    @Query("SELECT * FROM UserFilter")
    fun getAll(): List<UserFilter>

    @Query("SELECT * FROM UserFilter WHERE id = :id")
    fun get(id: Long): Flow<UserFilter?>

    @Insert
    fun insert(userFilter: UserFilter): Long

    @Update
    fun update(userFilter: UserFilter)

    @Delete
    fun delete(userFilter: UserFilter)

    @Query("DELETE FROM UserFilter")
    fun deleteAll()
}

class AllowedLevelsConverter {

    @TypeConverter
    fun toAllowedLevels(data: String) = data.split(",").map { enumValues<LogLevel>()[it.toInt()] }

    @TypeConverter
    fun fromAllowedLevels(allowedLevels: List<LogLevel>) = allowedLevels.joinToString(",") { it.ordinal.toString() }
}