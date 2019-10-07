package com.estebanacevedo.a_maintenance

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private  var SavedName :String? = "0"
    private  var SavedPasword :String? = "12345"
    private  var SavedMail :String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)
        var datosRecibidos = intent.extras
//        Toast.makeText(this,datosRecibidos!!.getString("password"), Toast.LENGTH_SHORT).show()
        SavedName = datosRecibidos!!.getString("nombre")
        SavedPasword = datosRecibidos!!.getString("password")
        SavedMail = datosRecibidos!!.getString("correo")

        btRegistrarse.setOnClickListener {
//            Toast.makeText(this,"ir a actividad 2", Toast.LENGTH_SHORT).show()
            var intent = Intent(this,RegistroActivity::class.java)
            intent.putExtra("nombre","")
            intent.putExtra("correo", "")
            intent.putExtra("password", "")
            startActivityForResult(intent,1234)

        }


        btInicio.setOnClickListener {
            var nombre = etNombre.text.toString()       //variable que almacena el nombre digitado en el EditText
            var password = etPassword.text.toString()
            var intent = Intent(this,Main2Activity::class.java)
            if (nombre == SavedName && password == SavedPasword){
                intent.putExtra("nombre",nombre)
                intent.putExtra("correo", SavedMail)
                intent.putExtra("password", password)
                startActivityForResult(intent,1234)
                finish()
            }else{
                txLogresult.text = "Usuario no registrado"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234 && resultCode == Activity.RESULT_OK){
//            Toast.makeText(this,data!!.extras!!.getString("nombre"), Toast.LENGTH_SHORT).show()
            SavedName = data!!.extras!!.getString("nombre")
            SavedPasword = data!!.extras!!.getString("password")
            SavedMail = data!!.extras!!.getString("correo")
        }
    }
}
