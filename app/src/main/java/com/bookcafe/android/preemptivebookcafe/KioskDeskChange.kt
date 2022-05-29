package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bookcafe.android.preemptivebookcafe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.kiosk_desk_change.*

class KioskDeskChange : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_change)

        topBack.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            startActivity(intent)
            finish()
        }
        topHome.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        }
        deskChangeBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskChangeSuccess::class.java)
            startActivity(intent)
            finish()
        }
        dialogBtn.setOnClickListener {
            // Dialog만들기
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.desk_state_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("좌석상태 확인표")
            mBuilder.show()
        }
    }
}