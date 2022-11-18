package com.liceolapaz.dam.gbl

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.liceolapaz.dam.gbl.placeholder.PlaceholderContent.PlaceholderItem
import com.liceolapaz.dam.gbl.databinding.JugadorItemBinding

// class MyJugadorRecyclerViewAdapter(
// private val values: List<PlaceholderItem>
// ) : RecyclerView.Adapter<MyJugadorRecyclerViewAdapter.ViewHolder>() {
//
// override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
// return ViewHolder(
// JugadorItemBinding.inflate(
// LayoutInflater.from(parent.context),
// parent,
// false
// )
// )
//
// }
//
// override fun onBindViewHolder(holder: ViewHolder, position: Int) {
// val item = values[position]
// holder.idView.text = item.id
// holder.contentView.text = item.content
// }
//
// override fun getItemCount(): Int = values.size
//
// inner class ViewHolder(binding: JugadorItemBinding) : RecyclerView.ViewHolder(binding.root) {
// val idView: TextView = //binding.itemNumber
// val contentView: TextView = binding.content
//
// override fun toString(): String {
// return super.toString() + " '" + contentView.text + "'"
// }
// }
//
// }