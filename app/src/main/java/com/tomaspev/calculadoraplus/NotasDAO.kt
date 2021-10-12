package com.tomaspev.calculadoraplus

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotasDAO {
    @Query("SELECT * FROM notas")
    fun getAll(): LiveData<List<Notas>>
    @Query("SELECT * FROM notas WHERE idNota = :id")
    fun get(id:Int) : LiveData<Notas>
    @Insert
    fun insertAll(vararg notas: Notas)
    @Update
    fun update(notas:Notas)
    @Delete
    fun delete(notas:Notas)
}