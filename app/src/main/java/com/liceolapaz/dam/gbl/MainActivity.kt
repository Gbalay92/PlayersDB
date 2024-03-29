package com.liceolapaz.dam.gbl


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

            if(user.text.toString()=="admin" && password.text.toString()=="liceo"){

                val intent = Intent(this@MainActivity,JugadoresRecycler::class.java)
                startActivity(intent)

            }
            else{
                txtError.text="Usuario y/o contraseña incorrectos"
            }

        }




    }
}