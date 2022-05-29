package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.kiosk_menu_select.*

class KioskMenuSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_menu_select)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        topNum.setText(stuNum.toString())

        deskChoiceBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChoice::class.java)
            intent.putExtra("classNo",stuNum)
            startActivity(intent)
            finish()
        }

        deskChangeBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChange::class.java)
            intent.putExtra("classNo",stuNum)
            startActivity(intent)
            finish()
        }

        deskCancelBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskCancel::class.java)
            intent.putExtra("classNo",stuNum)
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