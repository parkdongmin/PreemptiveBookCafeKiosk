package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.kiosk_desk_change_success.*

class KioskDeskChangeSuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_change_success)

        topBack.setOnClickListener {
            var intent = Intent(this, KioskDeskChange::class.java)
            startActivity(intent)
            finish()
        }
        topHome.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            startActivity(intent)
            finish()
        }
    }
}