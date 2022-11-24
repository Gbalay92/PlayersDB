package com.liceolapaz.dam.gbl

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.liceolapaz.dam.gbl.databinding.JugadorListBinding

class JugadoresRecycler : AppCompatActivity() {

    lateinit var binding : JugadorListBinding
    lateinit var jugadoresDb : JugadoresSql
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JugadorListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jugadoresDb= JugadoresSql(this)

        db=jugadoresDb.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM  Jugadores", null)
        var adapt = ListaJugadores()
        adapt.ListaJugadores(this, cursor)

        binding.list.setHasFixedSize(true)
        binding.list.adapter = adapt


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_nuevo -> {
            val intent = Intent(this@JugadoresRecycler,Jugador::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}