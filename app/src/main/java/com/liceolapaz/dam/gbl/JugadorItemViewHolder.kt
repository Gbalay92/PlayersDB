package com.liceolapaz.dam.gbl


import android.view.View;
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JugadorItemViewHolder( view: View): RecyclerView.ViewHolder(view) {

    var nombre=view.findViewById<TextView>(R.id.nombre)
    var posicion=view.findViewById<TextView>(R.id.posicion)
    var precio=view.findViewById<TextView>(R.id.precio)
    var puntos=view.findViewById<TextView>(R.id.puntos)



    fun render(jugador: Jugador){
        nombre.text=jugador.nombre
        posicion.text=jugador.posicion
        precio.text= jugador.precio.toString()
        puntos.text=jugador.puntos.toString()
    }

}
