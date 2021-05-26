package com.simpleplus.memoria.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "categoria_table")
@Parcelize
data class Categoria(val title: String, @PrimaryKey val id: Int) : Parcelable {
}