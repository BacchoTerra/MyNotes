package com.simpleplus.memoria.application

import android.app.Application
import com.simpleplus.memoria.database.MemoriaDatabase
import com.simpleplus.memoria.repository.CategoriaRepository
import com.simpleplus.memoria.repository.MemoriaRepository

class MemoriaApplication : Application() {

    private val database by lazy { MemoriaDatabase.getInstance(this) }

    val memoriaRepo by lazy { MemoriaRepository(database.memoriaDao()) }

    val categoriaRepo by lazy { CategoriaRepository(database.categoriaDao()) }

}