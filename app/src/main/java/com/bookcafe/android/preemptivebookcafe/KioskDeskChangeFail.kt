package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.kiosk_desk_change_fail.*
import kotlinx.android.synthetic.main.kiosk_desk_change_fail.topBack
import kotlinx.android.synthetic.main.kiosk_desk_change_fail.topHome
import kotlinx.android.synthetic.main.kiosk_desk_change_fail.topNum

class KioskDeskChangeFail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_choice_fail)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        var seatId = intentData.getStringExtra("seatId")
        var status = intentData.getStringExtra("status")


        topNum.setText(stuNum.toString())

        topBack.setOnClickListener {
            var intent = Intent(this, KioskDeskChange::class.java)
            intent.putExtra("classNo",stuNum)
            intent.putExtra("seatId", seatId)
            intent.putExtra("status", status)
            startActivity(intent)
            finish()
        }
        topHome.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            intent.putExtra("classNo",stuNum)
            intent.putExtra("status",status)
            intent.putExtra("seatId",seatId)
            startActivity(intent)
            finish()
        }
        deskChangeGoBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChange::class.java)
            intent.putExtra("classNo",stuNum)
            intent.putExtra("seatId", seatId)
            intent.putExtra("status", status)
            startActivity(intent)
            finish()
        }
    }
}