package com.estebanacevedo.a_maintenance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        val timer = Timer()
        timer.schedule(timerTask {
            goToMainActivity()
        },2000
        )
    }

    private  fun goToMainActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("nombre","0")
        intent.putExtra("correo", "")
        intent.putExtra("password", "12345")
        startActivity(intent)
        finish()
    }
}
