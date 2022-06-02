package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.kiosk_menu_select.*

class KioskMenuSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_menu_select)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        var status = intentData.getStringExtra("status")
        var seatId = intentData.getStringExtra("seatId")

        topNum.setText(stuNum.toString())
        Log.d("status", status.toString())
        Log.d("seatId", seatId.toString())

        if(status == "null"){
            deskChoiceBtn.setOnClickListener {
                var intent = Intent(this, KioskDeskChoice::class.java)
                intent.putExtra("classNo",stuNum)
                intent.putExtra("status",status)
                intent.putExtra("seatId",seatId)
                startActivity(intent)
                finish()
            }

            deskChangeBtn.setOnClickListener {
                Toast.makeText(applicationContext, "좌석 선점 후 사용해주세요.", Toast.LENGTH_SHORT).show()
            }

            deskCancelBtn.setOnClickListener {
                Toast.makeText(applicationContext, "좌석 선점 후 사용해주세요.", Toast.LENGTH_SHORT).show()
            }

        }else if(status == "USED"){
            deskChangeBtn.setOnClickListener {
                var intent = Intent(this, KioskDeskChange::class.java)
                intent.putExtra("classNo",stuNum)
                intent.putExtra("status",status)
                intent.putExtra("seatId",seatId)
                startActivity(intent)
                finish()
            }
            deskCancelBtn.setOnClickListener {
                var intent = Intent(this, KioskDeskCancel::class.java)
                intent.putExtra("classNo",stuNum)
                intent.putExtra("status",status)
                intent.putExtra("seatId",seatId)
                startActivity(intent)
                finish()
            }
            deskChoiceBtn.setOnClickListener {
                Toast.makeText(applicationContext, "좌석 선점 취소 후 사용해주세요.", Toast.LENGTH_SHORT).show()
            }
        }else{
            var intent = Intent(this, KioskMain::class.java)
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