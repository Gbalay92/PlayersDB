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

    fun onDelete(db: SQLiteDatabase, id: String){
        var sentencia = "DELETE FROM Jugadores WHERE codigo = '$id'"
        db.execSQL(sentencia)
    }


    fun onAlter(db: SQLiteDatabase, id: String, name: String, precio: String, posicion: String, puntos: String){
        println("nombre = '$name'" +
            "precio='$precio'" +
                    "posicion='$posicion'" +
                    "puntos='$puntos'" +
                    "WHERE codigo = '$id'")
        var sentencia = "UPDATE Jugadores " +
                "SET nombre = '$name', " +
                "precio=$precio, " +
                "posicion='$posicion', " +
                "puntos=$puntos " +
                "WHERE codigo =$id"
        db.execSQL(sentencia)
    }

}