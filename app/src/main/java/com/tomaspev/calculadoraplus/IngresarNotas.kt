package com.tomaspev.calculadoraplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IngresarNotas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)
        var idnota: Int? = null
        if (intent.hasExtra("notas")) {
            val notas = intent.extras?.getSerializable("notas") as Notas
            //Toast.makeText(this, "idnotas = ${notas.idNota.toString()}", Toast.LENGTH_SHORT).show()
            idnota = notas.idNota
            nombre_insertarNota.setText(notas.titulo)
        }
        btnInsertar.setOnClickListener {
            val database = AppDatabase.getDatabase(this)
            var titulo = nombre_insertarNota.text.toString()

            val notas = Notas(titulo)
            if (idnota != null) {
                //Toast.makeText(this, "idnota = ${idnota.toString()}", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    notas.idNota = idnota
                    database.notas().update(notas)
                    this@IngresarNotas.finish()
                }
            } else {
                //Toast.makeText(this, "idnota = ${idnota.toString()}", Toast.LENGTH_SHORT).show()
                CoroutineScope(Dispatchers.IO).launch {
                    database.notas().insertAll(notas)
                    this@IngresarNotas.finish()
                }
                Toast.makeText(this, "Nota correctamente ingresada", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun volverInicio(view: View) {
        Toast.makeText(this, "Volviendo al Inicio", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}