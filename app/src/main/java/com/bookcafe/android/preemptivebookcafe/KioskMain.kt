package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.kiosk_main.*
import kotlinx.android.synthetic.main.kiosk_main.topBack
import kotlinx.android.synthetic.main.kiosk_menu_select.*
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.time.LocalDateTime

class KioskMain : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBackPressed() {
        super.onBackPressed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_main)

        var stuNum = ""

        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer())
        val gson: Gson = gsonBuilder.setPrettyPrinting().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.36.156.88:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val service = retrofit.create(UserCheck::class.java)

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
            val classNo = mainNumTextBox.text.toString()
            if(classNo == ""){
                Toast.makeText(applicationContext,"학번을 입력해주세요.", Toast.LENGTH_SHORT).show()
                kioskLogFailLink()
            }else{
                val userClassNo = UserCheckRequestDto(classNo.toLong())
                service.userCheckRequestFun(userClassNo).enqueue( object : Callback<Seats> {
                    override fun onResponse(call: Call<Seats>, response: Response<Seats>) {
                        if(response.code()==400){
                            //val jsonObject = JSONObject(response.errorBody().toString());
                            Log.d("에러 ", "${response.errorBody()?.string()!!}")
                            kioskLogFailLink()
                        }
                        else{
                            Log.d("로그인" , "${response.body()}")
                            var status = response.body()?.status
                            var seatId = response.body()?.id
                            kioskMenuSelectLink(stuNum, status.toString(), seatId.toString())
                        }
                    }
                    override fun onFailure(call: Call<Seats>, t: Throwable) {
                        Log.e("로그인", "${t.localizedMessage}")
                        kioskLogFailLink()
                    }
                })
            }
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
    fun kioskMenuSelectLink(stuNum : String, status : String, seatId : String){
        var intent = Intent(this, KioskMenuSelect::class.java) //다음 화면 이동을 위한 intent 객체 생성
        intent.putExtra("classNo",stuNum)
        intent.putExtra("status",status)
        intent.putExtra("seatId",seatId)
        startActivity(intent)
        finish()
    }

    fun kioskLogFailLink(){
        var intent = Intent(this, KioskLoginFail::class.java) //다음 화면 이동을 위한 intent 객체 생성
        startActivity(intent)
        finish()
    }
}

interface UserCheck{
    @Headers("accept: application/json", "content-type: application/json")
    @POST("/kiosk/login")
    fun userCheckRequestFun(
        @Body classNo : UserCheckRequestDto
    ) : Call<Seats>
}