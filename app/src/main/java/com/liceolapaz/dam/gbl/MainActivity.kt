package com.liceolapaz.dam.gbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var user: EditText
    private lateinit var password: EditText
    private lateinit var txtError: TextView
    private lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user=findViewById(R.id.inputUser)
        password=findViewById(R.id.inputPassword)
        txtError=findViewById(R.id.txtError)
        login=findViewById(R.id.login)


        login.setOnClickListener {

            val intent = Intent(this@MainActivity,JugadoresRecycler::class.java)
            startActivity(intent)
            /*if(user.text.toString()=="admin" && password.text.toString()=="liceo"){


            }
            else{
                txtError.text="Usuario y/o contraseña incorrectos"
            }*/

        }




    }
}