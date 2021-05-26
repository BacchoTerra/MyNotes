package com.simpleplus.memoria.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity (tableName = "memoria_table")
@Parcelize
data class Memoria(
    val title: String,
    val desc: String,
    @PrimaryKey val id: Int,
    val importance: Int = 0
) : Parcelable