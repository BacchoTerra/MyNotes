package com.simpleplus.memoria.dao

import androidx.room.Query
import com.simpleplus.memoria.model.Categoria
import kotlinx.coroutines.flow.Flow

interface CategoriaDao {

    suspend fun insert(categoria: Categoria)

    suspend fun update(categoria: Categoria)

    suspend fun delete(categoria: Categoria)

    @Query ("DELETE FROM categoria_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM categoria_table")
    fun selectAll():Flow<List<Categoria>>

}