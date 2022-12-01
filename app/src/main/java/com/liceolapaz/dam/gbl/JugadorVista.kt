package com.liceolapaz.dam.gbl

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liceolapaz.dam.gbl.databinding.JugadorBinding


class JugadorVista : AppCompatActivity() {
    lateinit var binding: JugadorBinding
    lateinit var jugadoresDb : JugadoresSql
    lateinit var db :  SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JugadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jugadoresDb=JugadoresSql(this, "jugadores.db")
        db=jugadoresDb.writableDatabase

        var nombre=binding.nombre.toString()
        var position=binding.posicion.selectedItem.toString()
        var price=binding.precio.toString()
        var puntos=binding.puntos.toString()



        binding.add.setOnClickListener {
            jugadoresDb.onUpdate(db, nombre, price, position ,puntos)
        }
    }
}