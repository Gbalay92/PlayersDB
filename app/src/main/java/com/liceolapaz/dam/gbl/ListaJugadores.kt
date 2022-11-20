package com.liceolapaz.dam.gbl

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.dam.gbl.databinding.JugadorItemBinding
import com.liceolapaz.dam.gbl.databinding.JugadorListBinding


class ListaJugadores : RecyclerView.Adapter<ListaJugadores.ViewHolder>() {


    lateinit var jugadoresDb : JugadoresSql
    lateinit var context : Context
    lateinit var cursor: Cursor
    fun ListaJugadores(context:Context,cursor: Cursor){
        this.context = context
        this.cursor = cursor
    }


    inner class ViewHolder : RecyclerView.ViewHolder {
        val nombre: TextView
        val posicion: TextView
        val puntos: TextView
        val precio: TextView

        constructor(view: View) : super(view){
            val binding = JugadorItemBinding.bind(view)
            nombre=binding.nombre
            posicion=binding.posicion
            puntos=binding.puntos
            precio=binding.precio

            view.setOnClickListener{
                Toast.makeText(context, nombre.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.jugador_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        cursor.moveToPosition(position)
        holder.nombre.text=cursor.getString(1)
        holder.posicion.text=cursor.getString(2)
        holder.precio.text=cursor.getString(3)
        holder.puntos.text=cursor.getString(4)


    }

    override fun getItemCount(): Int {
        if (cursor==null)
            return 0
        else
            return cursor.count
    }
}