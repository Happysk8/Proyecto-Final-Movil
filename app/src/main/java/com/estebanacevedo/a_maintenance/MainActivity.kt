package com.estebanacevedo.a_maintenance

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  var SavedName :String? = ""
    private  var SavedPasword :String? = ""
    private  var SavedMail :String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var datosRecibidos = intent.extras
//        Toast.makeText(this,datosRecibidos!!.getString("nombre"), Toast.LENGTH_SHORT).show()
        SavedName = datosRecibidos!!.getString("nombre")
        SavedPasword = datosRecibidos!!.getString("password")
        SavedMail = datosRecibidos!!.getString("correo")
//        txNombre.text = SavedName
//        txCorreo.text = SavedMail
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.mCerrar -> {
//                Toast.makeText(this, "ir login", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("nombre", SavedName)
                intent.putExtra("correo", SavedMail)
                intent.putExtra("password", SavedPasword)
                setResult(Activity.RESULT_OK, intent)
                finish()
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "App Cerrada", Toast.LENGTH_SHORT).show()
        finish()
    }
}
