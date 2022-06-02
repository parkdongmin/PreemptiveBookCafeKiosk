package com.bookcafe.android.preemptivebookcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.kiosk_desk_cancel.*

class KioskLoginFail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_login_fail)

        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        },5000)

        topBack.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        }

        topHome.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        }

    }
}