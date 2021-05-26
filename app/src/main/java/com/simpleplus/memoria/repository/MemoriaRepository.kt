package com.simpleplus.memoria.repository

import com.simpleplus.memoria.dao.MemoriaDao
import com.simpleplus.memoria.model.Memoria

class MemoriaRepository(private val dao:MemoriaDao) {

    val allMemoria = dao.selectAll()

    suspend fun insert (memoria: Memoria) = dao.insert(memoria)

    suspend fun update (memoria: Memoria) = dao.update(memoria)

    suspend fun delete (memoria: Memoria) = dao.delete(memoria)

    suspend fun deleteAll() = dao.deleteAll()


}