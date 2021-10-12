package com.tomaspev.calculadoraplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun cerrarApp(view: View){
        Toast.makeText(this, "Cerrando la aplicacion", Toast.LENGTH_SHORT).show()
        finishAndRemoveTask()
    }
    fun mostrarCalculadora(view: View){
        Toast.makeText(this, "Mostrando la Calculadora", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Calculadora::class.java)
        startActivity(intent)
        finish()
    }
    fun mostrarDivisa(view: View){
        Toast.makeText(this, "Conversor de Monedas", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Divisa::class.java)
        startActivity(intent)
        finish()
    }
    fun mostrarNotas(view: View){
        Toast.makeText(this, "Mostrando sus Notas", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListadoNotas::class.java)
        startActivity(intent)
        finish()
    }
    fun ingresarNota(view: View){
        Toast.makeText(this, "Ingrese una nueva Nota", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, IngresarNotas::class.java)
        startActivity(intent)
        finish()
    }
}