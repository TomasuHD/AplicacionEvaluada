package com.tomaspev.calculadoraplus

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Notas")
class Notas (
    val titulo:String,
    @PrimaryKey(autoGenerate = true)
    var idNota: Int = 0
) :Serializable