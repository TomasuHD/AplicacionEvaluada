package com.tomaspev.calculadoraplus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import kotlinx.android.synthetic.main.activity_nota_interior.*
import kotlinx.android.synthetic.main.notas.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotaTexto : AppCompatActivity() {
    private lateinit var database : AppDatabase
    private lateinit var notas : Notas
    private lateinit var notaLiveData :LiveData<Notas>
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_notas, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_interior)
        database = AppDatabase.getDatabase(this)
        val idnota = intent.getIntExtra("id", 0)
        notaLiveData = database.notas().get(idnota)
        notaLiveData.observe(this, {notas = it
            titulo.text = notas.titulo
        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.editar -> {
                val intent = Intent(this, IngresarNotas::class.java)
                intent.putExtra("Nota", notas)
                startActivity(intent)
            }
            R.id.eliminar -> {
                notaLiveData.removeObservers(this)
                CoroutineScope(Dispatchers.IO).launch {
                    database.notas().delete(notas)
                    this@NotaTexto.finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
    fun volverListado(view: View){
        Toast.makeText(this, "Volviendo a Main", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, ListadoNotas::class.java)
        startActivity(intent)
        finish()
    }
}