package com.liceolapaz.dam.gbl


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ListaJugadores(var list: List<Jugador>) : RecyclerView.Adapter<JugadorItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JugadorItemViewHolder(inflater.inflate(R.layout.jugador_item, parent, false))
    }


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: JugadorItemViewHolder, position: Int) {
        val item = list[position]
        holder.render(item)
    }
}