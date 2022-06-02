package com.bookcafe.android.preemptivebookcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.kiosk_desk_cancel_fail.*
import kotlinx.android.synthetic.main.kiosk_desk_cancel_fail.topBack
import kotlinx.android.synthetic.main.kiosk_desk_cancel_fail.topHome
import kotlinx.android.synthetic.main.kiosk_desk_cancel_fail.topNum

class KioskDeskCancelFail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_cancel_fail)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        var seatId = intentData.getStringExtra("seatId")
        var status = intentData.getStringExtra("status")
        topNum.setText(stuNum.toString())

        topBack.setOnClickListener {
            var intent = Intent(this, KioskDeskCancel::class.java)
            intent.putExtra("classNo",stuNum)
            intent.putExtra("status",status)
            intent.putExtra("seatId",seatId)
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
        failGoHomeBtn.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            intent.putExtra("classNo",stuNum)
            intent.putExtra("status",status)
            intent.putExtra("seatId",seatId)
            startActivity(intent)
            finish()
        }
    }
}