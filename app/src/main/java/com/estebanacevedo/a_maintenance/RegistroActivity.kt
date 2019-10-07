package com.estebanacevedo.a_maintenance

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_registro)
//        var datosRecibidos = intent.extras
////        Toast.makeText(this,datosRecibidos!!.getString("nombre"), Toast.LENGTH_SHORT).show()

        btAceptar.setOnClickListener {
            //Listener del Boton, al presionarlo se ejecuta esta función
            var nombre = etNombre.text.toString()       //variable que almacena el nombre digitado en el EditText
            var correo = etCorreo.text.toString()       //se debe convertir a string por eso .toString()
            var password = etPassword.text.toString()
            var repassword = etRepeatPassword.text.toString()
            if (nombre == "" || correo == "" || password == "" || repassword == "") {
                txRegResult.text = "Complete todos los campos"
            } else if (password != repassword) {
                txRegResult.text = "Las contraseñas no coinciden"
            } else {
                var intent = Intent()
                intent.putExtra("nombre", nombre)
                intent.putExtra("correo", correo)
                intent.putExtra("password", password)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }


        }

    }
}

