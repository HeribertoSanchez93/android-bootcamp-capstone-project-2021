package com.example.bootcampproject.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bootcampproject.data.mock.AvailableBook

@Dao
interface AvailableBooksDao {
    @Query("Select * From AvailableBook")
    suspend fun getAll(): List<AvailableBook>

    @Query("Select * From AvailableBook Where book Like :book || '%'")
    suspend fun getSelectedBooks(book: String?): List<AvailableBook>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(availableBooks: List<AvailableBook>)

    @Update
    suspend fun updateAll(availableBooks: List<AvailableBook>)
}
