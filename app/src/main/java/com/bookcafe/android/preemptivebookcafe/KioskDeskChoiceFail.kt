package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.kiosk_desk_choice.*
import kotlinx.android.synthetic.main.kiosk_desk_choice_fail.*
import kotlinx.android.synthetic.main.kiosk_desk_choice_fail.topBack
import kotlinx.android.synthetic.main.kiosk_desk_choice_fail.topHome
import kotlinx.android.synthetic.main.kiosk_desk_choice_fail.topNum

class KioskDeskChoiceFail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_choice_fail)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        topNum.setText(stuNum.toString())

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
            var intent = Intent(this, KioskDeskChoice::class.java) //다음 화면 이동을 위한 intent 객체 생성
            intent.putExtra("classNo",stuNum)
            startActivity(intent)
            finish()
        }
    }
}