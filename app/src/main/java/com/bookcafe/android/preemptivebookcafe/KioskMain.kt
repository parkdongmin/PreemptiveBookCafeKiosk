package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.kiosk_main.*
import kotlinx.android.synthetic.main.kiosk_main.topBack
import kotlinx.android.synthetic.main.kiosk_menu_select.*

class KioskMain : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_main)

        var stuNum = ""

        num1.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num1.setImageResource(R.drawable.push1)
                    stuNum += "1"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num1.setImageResource(R.drawable.group126)
                }
            }
            true
        }

        num2.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num2.setImageResource(R.drawable.push2)
                    stuNum += "2"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num2.setImageResource(R.drawable.group127)
                }
            }
            true
        }

        num3.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num3.setImageResource(R.drawable.push3)
                    stuNum += "3"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num3.setImageResource(R.drawable.group128)
                }
            }
            true
        }

        num4.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num4.setImageResource(R.drawable.push4)
                    stuNum += "4"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num4.setImageResource(R.drawable.group129)
                }
            }
            true
        }

        num5.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num5.setImageResource(R.drawable.push5)
                    stuNum += "5"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num5.setImageResource(R.drawable.group130)
                }
            }
            true
        }

        num6.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num6.setImageResource(R.drawable.push6)
                    stuNum += "6"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num6.setImageResource(R.drawable.group131)
                }
            }
            true
        }

        num7.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num7.setImageResource(R.drawable.push7)
                    stuNum += "7"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num7.setImageResource(R.drawable.group133)
                }
            }
            true
        }

        num8.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num8.setImageResource(R.drawable.push8)
                    stuNum += "8"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num8.setImageResource(R.drawable.group134)
                }
            }
            true
        }

        num9.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num9.setImageResource(R.drawable.push9)
                    stuNum += "9"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num9.setImageResource(R.drawable.group132)
                }
            }
            true
        }

        mainCheckBtn.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mainCheckBtn.setImageResource(R.drawable.pushchk)
                }
                MotionEvent.ACTION_UP -> {
                    mainCheckBtn.setImageResource(R.drawable.group137)
                }
            }
            true
        }

        num0.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    num0.setImageResource(R.drawable.push0)
                    stuNum += "0"
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    num0.setImageResource(R.drawable.group138)
                }
            }
            true
        }

        mainDelBtn.setOnTouchListener { _: View, event: MotionEvent ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mainDelBtn.setImageResource(R.drawable.pushdel)
                    stuNum = ""
                    mainNumTextBox.setText(stuNum)
                }
                MotionEvent.ACTION_UP -> {
                    mainDelBtn.setImageResource(R.drawable.group135)
                }
            }
            true
        }

        mainEntBtn.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java) //다음 화면 이동을 위한 intent 객체 생성
            intent.putExtra("classNo",stuNum)
            startActivity(intent)
            finish()
        }

        topBack.setOnClickListener {
            onBackPressed()
        }

        joinLink.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://login.kongju.ac.kr/View/SSO/sso.jsp?v=20220519125408&param=&sg_pkid=S05VMDA4Mg==&sg_return=aHR0cHM6Ly9wb3J0YWwua29uZ2p1LmFjLmtyL1ZpZXcvTURJX3BvcnRhbC9sb2dpblAuanNw&gourl=Lw=="))
            startActivity(intent)
            finish()
        }
    }
}