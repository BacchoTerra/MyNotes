package com.simpleplus.memoria.repository

import com.simpleplus.memoria.dao.CategoriaDao
import com.simpleplus.memoria.model.Categoria

class CategoriaRepository(private val dao: CategoriaDao) {

    val allCategory = dao.selectAll()

    suspend fun insert(categoria: Categoria) = dao.insert(categoria)

    suspend fun update(categoria: Categoria) = dao.update(categoria)

    suspend fun delete(categoria: Categoria) = dao.delete(categoria)

    suspend fun deleteAll() = dao.deleteAll()

}