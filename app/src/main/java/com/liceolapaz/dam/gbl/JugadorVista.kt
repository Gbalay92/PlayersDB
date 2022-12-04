package com.liceolapaz.dam.gbl

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.liceolapaz.dam.gbl.databinding.JugadorBinding


class JugadorVista : AppCompatActivity() {
    lateinit var binding: JugadorBinding
    lateinit var jugadoresDb : JugadoresSql
    lateinit var db :  SQLiteDatabase
    lateinit var nombre :String
    lateinit var position :String
    lateinit var price : String
    lateinit var puntos : String
    lateinit var id:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JugadorBinding.inflate(layoutInflater)
        var extra=intent.extras
        if (extra==null){
            binding.delete.visibility= View.INVISIBLE

        }/*else{
            binding.delete.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )}*/
        val volver=Intent(this@JugadorVista, JugadoresRecycler::class.java)
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
            val builder = AlertDialog.Builder(this)
            builder.setTitle("ACEPTAR")
            builder.setMessage("Los datos se guardarán en la base de datos.¿Está seguro?")
            builder.setPositiveButton("SI") { dialog, which ->
                id=binding.codigo.text.toString()
                nombre = binding.nombre.text.toString()
                position = binding.posicion.selectedItem.toString()
                price = binding.precio.text.toString()
                puntos = binding.puntos.text.toString()
                if(binding.codigo.text.toString().isEmpty()) {
                    jugadoresDb.onUpdate(db, nombre, price, position, puntos)
                    //println("$nombre, $price, $puntos")
                    startActivity(volver)
                }else{
                    jugadoresDb.onAlter(db, id, nombre, price, position, puntos)
                    startActivity(volver)
                }
            }
            builder.setNegativeButton("NO") { dialog, which ->
                startActivity(volver)
            }

            builder.setNeutralButton("CANCELAR") { dialog, which ->
            }
            builder.show()

        }

        binding.delete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("ACEPTAR")
            builder.setMessage("Los datos se borrarán de la base de datos.¿Está seguro?")
            builder.setPositiveButton("SI") { dialog, which ->
                id=binding.codigo.text.toString()
                jugadoresDb.onDelete(db,id)
                startActivity(volver)
            }
            builder.setNegativeButton("NO") { dialog, which ->
                startActivity(volver)
            }

            builder.setNeutralButton("CANCELAR") { dialog, which ->
            }
            builder.show()


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