package com.bookcafe.android.preemptivebookcafe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.kiosk_desk_cancel.*

class KioskLoginFail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_login_fail)

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