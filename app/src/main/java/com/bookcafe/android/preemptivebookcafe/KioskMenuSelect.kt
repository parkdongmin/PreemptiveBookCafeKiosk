package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.kiosk_menu_select.*

class KioskMenuSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_menu_select)

        val stuNum = intent.getStringExtra("stuNum")
        Log.e("KioskMain", "받아온 학번 : $stuNum");

        deskChoiceBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChoice::class.java)
            startActivity(intent)
            finish()
        }

        deskChangeBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChange::class.java)
            startActivity(intent)
            finish()
        }

        deskCancelBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskCancel::class.java)
            startActivity(intent)
            finish()
        }

        topBack.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        }

    }
}