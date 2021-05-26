package com.simpleplus.memoria.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.simpleplus.memoria.dao.CategoriaDao
import com.simpleplus.memoria.dao.MemoriaDao
import com.simpleplus.memoria.model.Categoria
import com.simpleplus.memoria.model.Memoria

@Database(entities = [Memoria::class, Categoria::class],version = 1)

abstract class MemoriaDatabase:RoomDatabase() {

    abstract fun memoriaDao():MemoriaDao
    abstract fun categoriaDao(): CategoriaDao

    companion object {
        private var INSTANCE:MemoriaDatabase? = null

        fun getInstance(application: Application) : MemoriaDatabase {

            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    MemoriaDatabase::class.java,
                    "memoria_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance

                instance

            }

        }

    }



}