package com.tomaspev.calculadoraplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora.*

class Calculadora : AppCompatActivity() {
    var num1 = 0.0
    var num2 = 0.0
    var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        resultadoText.text = "0"
        operacion = SIN_OPERACION
        unoBtn.setOnClickListener { numberPressed("1") }
        dosBtn.setOnClickListener { numberPressed("2") }
        tresBtn.setOnClickListener { numberPressed("3") }
        cuatroBtn.setOnClickListener { numberPressed("4") }
        cincoBtn.setOnClickListener { numberPressed("5") }
        seisBtn.setOnClickListener { numberPressed("6") }
        sieteBtn.setOnClickListener { numberPressed("7") }
        ochoBtn.setOnClickListener { numberPressed("8") }
        nueveBtn.setOnClickListener { numberPressed("9") }
        ceroBtn.setOnClickListener { numberPressed("0") }
        clearBtn.setOnClickListener { resetAll() }
        sumaBtn.setOnClickListener { operationPressed(SUMA) }
        restaBtn.setOnClickListener { operationPressed(RESTA) }
        multiplicarBtn.setOnClickListener { operationPressed(MULTIPLICACION) }
        divisionBtn.setOnClickListener { operationPressed(DIVISION) }
        igualBtn.setOnClickListener { resolvePressed() }
    }

    fun volverInicio(view: View){
        Toast.makeText(this, "Volviendo a Inicio", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun numberPressed(num: String){
        if(resultadoText.text == "0" && num != ".") {
            resultadoText.text = "$num"
        } else {
            resultadoText.text = "${resultadoText.text}$num"
        }
        if(operacion == SIN_OPERACION){
            num1 = resultadoText.text.toString().toDouble()
        } else {
            num2 = resultadoText.text.toString().toDouble()
        }
    }

    fun operationPressed(operacion: Int){
        this.operacion = operacion
        num1 = resultadoText.text.toString().toDouble()
        resultadoText.text = "0"
    }

    fun resolvePressed(){
        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }
        num1 = result as Double
        resultadoText.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    fun resetAll(){
        resultadoText.text = "0"
        num1 = 0.0
        num2 = 0.0
    }

    companion object {
        const val SIN_OPERACION = 0
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
    }
}