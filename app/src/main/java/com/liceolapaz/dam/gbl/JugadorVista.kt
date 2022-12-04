package com.liceolapaz.dam.gbl

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Spinner
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
        binding = JugadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jugadoresDb=JugadoresSql(this, "jugadores.db")
        db=jugadoresDb.writableDatabase

        binding.codigo.setText(intent?.getStringExtra("CODIGO"))
        binding.nombre.setText(intent?.getStringExtra("NAME"))
        binding.puntos.setText(intent?.getStringExtra("PUNTOS"))
        binding.precio.setText(intent?.getStringExtra("PRECIO"))
        intent.getStringExtra("POSICION")
            ?.let { getIndex(binding.posicion, it) }?.let { binding.posicion.setSelection(it) }


        binding.add.setOnClickListener {
            nombre= binding.nombre.text.toString()
            position= binding.posicion.selectedItem.toString()
            price=binding.precio.text.toString()
            puntos=binding.puntos.text.toString()
            jugadoresDb.onUpdate(db, nombre, price, position ,puntos)
            println("$nombre, $price, $puntos")
        }
    }

    private fun getIndex(spinner: Spinner, myString: String): Int {
        var index = 0
        for (i in 0 until spinner.count) {
            if (spinner.getItemAtPosition(i) == myString) {
                index = i
            }
        }
        return index
    }
}