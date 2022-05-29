package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.kiosk_desk_choice_fail.*

class KioskDeskChoiceFail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_choice_fail)

        topBack.setOnClickListener {
            var intent = Intent(this, KioskDeskChoice::class.java)
            startActivity(intent)
            finish()
        }
        topHome.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            startActivity(intent)
            finish()
        }
        choiceViewBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChoice::class.java)
            startActivity(intent)
            finish()
        }
    }
}