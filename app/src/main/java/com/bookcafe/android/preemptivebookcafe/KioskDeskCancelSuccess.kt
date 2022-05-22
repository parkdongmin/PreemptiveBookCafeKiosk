package com.bookcafe.android.preemptivebookcafe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.*

class KioskDeskCancelSuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_cancel_success)

        topBack.setOnClickListener {
            var intent = Intent(this, KioskDeskCancel::class.java)
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