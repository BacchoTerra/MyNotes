package com.simpleplus.memoria.dao

import androidx.room.Dao
import androidx.room.Query
import com.simpleplus.memoria.model.Memoria
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoriaDao {

    suspend fun insert(memoria: Memoria)

    suspend fun update(memoria: Memoria)

    suspend fun delete(memoria: Memoria)

    @Query ("DELETE FROM categoria_table")
    suspend fun deleteAll()

    @Query ("SELECT * FROM memoria_table")
    fun selectAll():Flow<List<Memoria>>


}