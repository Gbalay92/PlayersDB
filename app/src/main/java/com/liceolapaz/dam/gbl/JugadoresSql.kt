package com.liceolapaz.dam.gbl


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JugadoresSql(context: Context?, database : String)
    : SQLiteOpenHelper(context, database, null, 2) {


    override fun onCreate(db: SQLiteDatabase?) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        //Sentencia SQL para crear la tabla de Usuarios
        val sqlCreate = "CREATE TABLE Jugadores (codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT, precio INTEGER, posicion TEXT, puntos INTEGER)"
        db?.execSQL(sqlCreate)

    }

    override fun onUpgrade(db: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {

        //Se elimina la versión anterior de la tabla
        db?.execSQL("DROP TABLE IF EXISTS Jugadores")
        onCreate(db)
    }

    fun onUpdate(db: SQLiteDatabase, name: String, precio: String, posicion: String, puntos: String){
        var sentencia="INSERT INTO Jugadores(nombre, precio, posicion, puntos) VALUES('$name', '$precio', '$posicion', '$puntos')"
        db.execSQL(sentencia)

    }


}