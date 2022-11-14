package com.liceolapaz.dam.gbl


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class JugadoresSql(context: Context?,name: String?,factory: SQLiteDatabase.CursorFactory?,version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    //Sentencia SQL para crear la tabla de Usuarios
    val sqlCreate = "CREATE TABLE Jugadores (codigo INTEGER, nombre TEXT, precio REAl, posicion TEXT, puntos INTEGER)"

    override fun onCreate(db: SQLiteDatabase?) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {

        //Se elimina la versión anterior de la tabla
        db?.execSQL("DROP TABLE IF EXISTS Usuarios")

        //Se crea la nueva versión de la tabla
        db?.execSQL(sqlCreate)
    }

    fun onUpdate(db: SQLiteDatabase?,name: String, precio: Double, posicion: String, puntos: Integer){
        db?.execSQL("INSERT INTO Jugadores (nombre,precio, posicion,puntos) VALUES($name,$precio,$posicion,$puntos)")
    }
}