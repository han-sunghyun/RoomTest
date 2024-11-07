package com.developsunghyun.roomdb_test.Model.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DBItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: DBItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert2(item: DBItem2)

    @Update
    suspend fun update(item: DBItem)

    @Delete
    suspend fun delete(item: DBItem)

    @Query("SELECT * from test_db WHERE id = :id")
    fun getItem(id: Int): Flow<DBItem>

    @Query("SELECT * from test_db ORDER BY id ASC")
    fun getAllItems(): Flow<List<DBItem>>

    @Query("SELECT * from test_db2 ORDER BY id ASC")
    fun getAllItems2(): Flow<List<DBItem2>>
}