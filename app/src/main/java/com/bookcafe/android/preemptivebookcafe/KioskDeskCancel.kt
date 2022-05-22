package com.bookcafe.android.preemptivebookcafe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import com.bookcafe.android.preemptivebookcafe.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.kiosk_desk_cancel.*
import kotlinx.android.synthetic.main.kiosk_desk_cancel.dialogBtn
import kotlinx.android.synthetic.main.kiosk_desk_cancel.topBack
import kotlinx.android.synthetic.main.kiosk_desk_cancel.topHome
import kotlinx.android.synthetic.main.kiosk_desk_choice.*

class KioskDeskCancel : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_cancel)

        topBack.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            startActivity(intent)
            finish()
        }
        topHome.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
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
        cancelYesBtn.setOnClickListener {
            var intent = Intent(this, KioskDeskCancelSuccess::class.java)
            startActivity(intent)
            finish()
        }
        cancelNoBtn.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            startActivity(intent)
            finish()
        }
    }
}