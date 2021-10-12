package com.tomaspev.calculadoraplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.notas.view.*

class notasAdapter (private val mContext: Context, private val listadoNotas: List<Notas>) : ArrayAdapter<Notas>(mContext , 0, listadoNotas)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.notas, parent, false)
        val notas = listadoNotas[position]
        layout.titulo_nota.text = notas.titulo
        return layout
    }
}