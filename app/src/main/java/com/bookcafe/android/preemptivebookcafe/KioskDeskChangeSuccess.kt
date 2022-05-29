package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.kiosk_desk_change_success.topBack
import kotlinx.android.synthetic.main.kiosk_desk_change_success.topHome
import kotlinx.android.synthetic.main.kiosk_desk_change_success.topNum
import kotlinx.android.synthetic.main.kiosk_desk_choice_success.*

class KioskDeskChangeSuccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_change_success)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        topNum.setText(stuNum.toString())
        var id = intentData.getStringExtra("id")
        deskNum.setText(id.toString())

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