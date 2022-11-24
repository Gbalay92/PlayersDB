package com.liceolapaz.dam.gbl

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liceolapaz.dam.gbl.databinding.JugadorBinding


class Jugador : AppCompatActivity() {
    lateinit var binding: JugadorBinding
    lateinit var jugadoresDb : JugadoresSql
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JugadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=jugadoresDb.writableDatabase
        var nombre=binding.nombre.toString()
        var position=binding.posicion.toString()
        var precio=binding.precio.toString()
        var puntos=binding.puntos.toString()



        binding.add.setOnClickListener {
            db?.execSQL("INSERT INTO Jugadores (nombre,precio, posicion,puntos) VALUES($nombre,$precio,$position,$puntos)")
        }
    }
}