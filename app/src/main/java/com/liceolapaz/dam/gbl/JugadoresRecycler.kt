package com.liceolapaz.dam.gbl

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.dam.gbl.databinding.JugadorListBinding

class JugadoresRecycler : AppCompatActivity() {

    lateinit var binding : JugadorListBinding
    lateinit var jugadoresDb : JugadoresSql
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jugador_list)

        var list : List<Jugador> = mutableListOf()
        jugadoresDb= JugadoresSql(this, "jugadores.db")
        db=jugadoresDb.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM  Jugadores", null)
        while(cursor.moveToNext()){
            var codigo=cursor.getInt(0)
            var nombre=cursor.getString(1)
            var precio=cursor.getInt(2)
            var posicion=cursor.getString(3)
            var puntos=cursor.getInt(4)
            var j = Jugador(codigo,nombre,posicion,precio,puntos)
            list+=j

        }
        initRecyclerView(list)

    }

    private fun initRecyclerView(cursor:List<Jugador>){
        val recyclerview=findViewById<RecyclerView>(R.id.list)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter=ListaJugadores(cursor)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_nuevo -> {
            val intent = Intent(this@JugadoresRecycler,JugadorVista::class.java)
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