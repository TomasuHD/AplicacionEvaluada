package com.tomaspev.calculadoraplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Divisa : AppCompatActivity() {
    fun convertir(view: View){
        val valorDolar: Double = 826.14
        val valorEuro: Double = 949.65
        val valorArs: Double = 8.30
        val valorYen: Double = 7.24
        val editText = findViewById<EditText>(R.id.valorOriginal)
        val valor = editText.text.toString()
        val validacion = Regex("[a-z]+", RegexOption.IGNORE_CASE)
        if (valor == ""){
            Toast.makeText(this, "Error no puede ser nulo", Toast.LENGTH_LONG).show()
        }else if(validacion.matches(valor)){
            Toast.makeText(this, "No puede ser texto", Toast.LENGTH_LONG).show()
        } else{
            val valor1 : Long = (valor.toLong() * valorDolar).toLong()
            val TextView = findViewById<TextView>(R.id.valor1)
            TextView.text = valor1.toString()

            val valor2 : Long = (valor.toLong() * valorEuro).toLong()
            val TextView2 = findViewById<TextView>(R.id.valor2)
            TextView2.text = valor2.toString()

            val valor3 : Long = (valor.toLong() * valorArs).toLong()
            val TextView3 = findViewById<TextView>(R.id.valor3)
            TextView3.text = valor3.toString()

            val valor4 : Long = (valor.toLong() * valorYen).toLong()
            val TextView4 = findViewById<TextView>(R.id.valor4)
            TextView4.text = valor4.toString()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divisa)
    }
    fun volverInicio(view: View) {
        Toast.makeText(this, "Volviendo al Inicio", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}