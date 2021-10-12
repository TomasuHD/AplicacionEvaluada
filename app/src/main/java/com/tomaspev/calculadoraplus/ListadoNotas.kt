package com.tomaspev.calculadoraplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listado_notas.*

class ListadoNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_notas)

        var listadonotas = emptyList<Notas>()
        val database = AppDatabase.getDatabase(this)
        database.notas().getAll().observe(this, {listadonotas= it
            val adapter = notasAdapter(this, listadonotas)
            listado.adapter = adapter
        })
        listado.setOnItemClickListener{ parent, view, position, id->
            val intent = Intent(this, NotaTexto::class.java)
            intent.putExtra("id", listadonotas[position].idNota)
            startActivity(intent)
        }
    }
    fun volverInicio(view: View){
        Toast.makeText(this, "Volviendo al Inicio", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}