package com.liceolapaz.dam.gbl

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.liceolapaz.dam.gbl.databinding.JugadorBinding


class JugadorVista : AppCompatActivity() {
    lateinit var binding: JugadorBinding
    lateinit var jugadoresDb : JugadoresSql
    lateinit var db :  SQLiteDatabase
    lateinit var nombre :String
    lateinit var position :String
    lateinit var price : String
    lateinit var puntos : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = JugadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jugadoresDb=JugadoresSql(this, "jugadores.db")
        db=jugadoresDb.writableDatabase



        binding.add.setOnClickListener {
            nombre= binding.nombre.text.toString()
            position= binding.posicion.selectedItem.toString()
            price=binding.precio.text.toString()
            puntos=binding.puntos.text.toString()
            jugadoresDb.onUpdate(db, nombre, price, position ,puntos)
            println("$nombre, $price, $puntos")
        }
    }
}