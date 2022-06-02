package com.bookcafe.android.preemptivebookcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.*
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.deskNum
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat1
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat10
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat11
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat12
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat13
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat14
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat15
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat16
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat18
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat19
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat2
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat20
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat21
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat22
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat23
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat24
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat25
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat26
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat27
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat28
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat29
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat3
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat30
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat31
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat32
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat33
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat34
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat35
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat36
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat37
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat38
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat39
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat4
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat40
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat41
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat42
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat43
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat44
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat45
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat46
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat47
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat48
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat49
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat5
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat50
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat51
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat52
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat53
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat54
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat55
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat56
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat57
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat58
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat59
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat6
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat60
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat61
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat62
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat63
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat64
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat65
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat66
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat7
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat8
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.seat9
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.topBack
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.topHome
import kotlinx.android.synthetic.main.kiosk_desk_cancel_success.topNum
import kotlinx.android.synthetic.main.kiosk_desk_change_success.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.time.LocalDateTime

class KioskDeskCancelSuccess : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_cancel_success)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        topNum.setText(stuNum.toString())
        var id = intentData.getStringExtra("id")
        deskNum.setText("좌석번호 : " + id.toString())

        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer())
        val gson: Gson = gsonBuilder.setPrettyPrinting().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.36.156.88:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val service = retrofit.create(CancelStateSuccess::class.java)

        service.desk()?.enqueue( object : Callback<Array<Seats>> {
            override fun onResponse(call: Call<Array<Seats>>, response: Response<Array<Seats>>) {
                if(response.code()==400){
                    Log.d("에러 ", "${response.errorBody()?.string()!!}")
                }
                else{
                    Log.d("좌석현황" , "${response.raw()}")
                    var data : Array<Seats>? = response?.body()

                    when (data?.get(0)?.status) {
                        "EMPTY" -> seat1.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat1.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat1.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(1)?.status) {
                        "EMPTY" -> seat2.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat2.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat2.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(2)?.status) {
                        "EMPTY" -> seat3.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat3.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat3.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(3)?.status) {
                        "EMPTY" -> seat4.setImageResource(R.drawable.rectangle751)
                        "USED" -> seat4.setImageResource(R.drawable.placev2)
                        "AWAY" -> seat4.setImageResource(R.drawable.placev5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(4)?.status) {
                        "EMPTY" -> seat5.setImageResource(R.drawable.rectangle751)
                        "USED" -> seat5.setImageResource(R.drawable.placev2)
                        "AWAY" -> seat5.setImageResource(R.drawable.placev5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(5)?.status) {
                        "EMPTY" -> seat6.setImageResource(R.drawable.rectangle751)
                        "USED" -> seat6.setImageResource(R.drawable.placev2)
                        "AWAY" -> seat6.setImageResource(R.drawable.placev5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(6)?.status) {
                        "EMPTY" -> seat7.setImageResource(R.drawable.rectangle751)
                        "USED" -> seat7.setImageResource(R.drawable.placev2)
                        "AWAY" -> seat7.setImageResource(R.drawable.placev5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(7)?.status) {
                        "EMPTY" -> seat8.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat8.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat8.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(8)?.status) {
                        "EMPTY" -> seat9.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat9.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat9.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(9)?.status) {
                        "EMPTY" -> seat10.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat10.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat10.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(10)?.status) {
                        "EMPTY" -> seat11.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat11.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat11.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(11)?.status) {
                        "EMPTY" -> seat12.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat12.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat12.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(12)?.status) {
                        "EMPTY" -> seat13.setImageResource(R.drawable.place1)
                        "USED" -> seat13.setImageResource(R.drawable.place2)
                        "AWAY" -> seat13.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(13)?.status) {
                        "EMPTY" -> seat14.setImageResource(R.drawable.place1)
                        "USED" -> seat14.setImageResource(R.drawable.place2)
                        "AWAY" -> seat14.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(14)?.status) {
                        "EMPTY" -> seat15.setImageResource(R.drawable.place1)
                        "USED" -> seat15.setImageResource(R.drawable.place2)
                        "AWAY" -> seat15.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(15)?.status) {
                        "EMPTY" -> seat16.setImageResource(R.drawable.place1)
                        "USED" -> seat16.setImageResource(R.drawable.place2)
                        "AWAY" -> seat16.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(17)?.status) {
                        "EMPTY" -> seat18.setImageResource(R.drawable.place1)
                        "USED" -> seat18.setImageResource(R.drawable.place2)
                        "AWAY" -> seat18.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(18)?.status) {
                        "EMPTY" -> seat19.setImageResource(R.drawable.place1)
                        "USED" -> seat19.setImageResource(R.drawable.place2)
                        "AWAY" -> seat19.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(19)?.status) {
                        "EMPTY" -> seat20.setImageResource(R.drawable.place1)
                        "USED" -> seat20.setImageResource(R.drawable.place2)
                        "AWAY" -> seat20.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(20)?.status) {
                        "EMPTY" -> seat21.setImageResource(R.drawable.place1)
                        "USED" -> seat21.setImageResource(R.drawable.place2)
                        "AWAY" -> seat21.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(21)?.status) {
                        "EMPTY" -> seat22.setImageResource(R.drawable.place1)
                        "USED" -> seat22.setImageResource(R.drawable.place2)
                        "AWAY" -> seat22.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(22)?.status) {
                        "EMPTY" -> seat23.setImageResource(R.drawable.place1)
                        "USED" -> seat23.setImageResource(R.drawable.place2)
                        "AWAY" -> seat23.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(23)?.status) {
                        "EMPTY" -> seat24.setImageResource(R.drawable.place1)
                        "USED" -> seat24.setImageResource(R.drawable.place2)
                        "AWAY" -> seat24.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(24)?.status) {
                        "EMPTY" -> seat25.setImageResource(R.drawable.place1)
                        "USED" -> seat25.setImageResource(R.drawable.place2)
                        "AWAY" -> seat25.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(25)?.status) {
                        "EMPTY" -> seat26.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat26.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat26.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(26)?.status) {
                        "EMPTY" -> seat27.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat27.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat27.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(27)?.status) {
                        "EMPTY" -> seat28.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat28.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat28.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(28)?.status) {
                        "EMPTY" -> seat29.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat29.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat29.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(29)?.status) {
                        "EMPTY" -> seat30.setImageResource(R.drawable.rectangle157)
                        "USED" -> seat30.setImageResource(R.drawable.placeh2)
                        "AWAY" -> seat30.setImageResource(R.drawable.placeh5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(30)?.status) {
                        "EMPTY" -> seat31.setImageResource(R.drawable.place1)
                        "USED" -> seat31.setImageResource(R.drawable.place2)
                        "AWAY" -> seat31.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(31)?.status) {
                        "EMPTY" -> seat32.setImageResource(R.drawable.place1)
                        "USED" -> seat32.setImageResource(R.drawable.place2)
                        "AWAY" -> seat32.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(32)?.status) {
                        "EMPTY" -> seat33.setImageResource(R.drawable.place1)
                        "USED" -> seat33.setImageResource(R.drawable.place2)
                        "AWAY" -> seat33.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(33)?.status) {
                        "EMPTY" -> seat34.setImageResource(R.drawable.place1)
                        "USED" -> seat34.setImageResource(R.drawable.place2)
                        "AWAY" -> seat34.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(34)?.status) {
                        "EMPTY" -> seat35.setImageResource(R.drawable.place1)
                        "USED" -> seat35.setImageResource(R.drawable.place2)
                        "AWAY" -> seat35.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(35)?.status) {
                        "EMPTY" -> seat36.setImageResource(R.drawable.place1)
                        "USED" -> seat36.setImageResource(R.drawable.place2)
                        "AWAY" -> seat36.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(36)?.status) {
                        "EMPTY" -> seat37.setImageResource(R.drawable.place1)
                        "USED" -> seat37.setImageResource(R.drawable.place2)
                        "AWAY" -> seat37.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(37)?.status) {
                        "EMPTY" -> seat38.setImageResource(R.drawable.place1)
                        "USED" -> seat38.setImageResource(R.drawable.place2)
                        "AWAY" -> seat38.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(38)?.status) {
                        "EMPTY" -> seat39.setImageResource(R.drawable.place1)
                        "USED" -> seat39.setImageResource(R.drawable.place2)
                        "AWAY" -> seat39.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(39)?.status) {
                        "EMPTY" -> seat40.setImageResource(R.drawable.place1)
                        "USED" -> seat40.setImageResource(R.drawable.place2)
                        "AWAY" -> seat40.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(40)?.status) {
                        "EMPTY" -> seat41.setImageResource(R.drawable.place1)
                        "USED" -> seat41.setImageResource(R.drawable.place2)
                        "AWAY" -> seat41.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(41)?.status) {
                        "EMPTY" -> seat42.setImageResource(R.drawable.place1)
                        "USED" -> seat42.setImageResource(R.drawable.place2)
                        "AWAY" -> seat42.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(42)?.status) {
                        "EMPTY" -> seat43.setImageResource(R.drawable.place1)
                        "USED" -> seat43.setImageResource(R.drawable.place2)
                        "AWAY" -> seat43.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(43)?.status) {
                        "EMPTY" -> seat44.setImageResource(R.drawable.place1)
                        "USED" -> seat44.setImageResource(R.drawable.place2)
                        "AWAY" -> seat44.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(44)?.status) {
                        "EMPTY" -> seat45.setImageResource(R.drawable.place1)
                        "USED" -> seat45.setImageResource(R.drawable.place2)
                        "AWAY" -> seat45.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(45)?.status) {
                        "EMPTY" -> seat46.setImageResource(R.drawable.place1)
                        "USED" -> seat46.setImageResource(R.drawable.place2)
                        "AWAY" -> seat46.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(46)?.status) {
                        "EMPTY" -> seat47.setImageResource(R.drawable.place1)
                        "USED" -> seat47.setImageResource(R.drawable.place2)
                        "AWAY" -> seat47.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(47)?.status) {
                        "EMPTY" -> seat48.setImageResource(R.drawable.place1)
                        "USED" -> seat48.setImageResource(R.drawable.place2)
                        "AWAY" -> seat48.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(48)?.status) {
                        "EMPTY" -> seat49.setImageResource(R.drawable.place1)
                        "USED" -> seat49.setImageResource(R.drawable.place2)
                        "AWAY" -> seat49.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(49)?.status) {
                        "EMPTY" -> seat50.setImageResource(R.drawable.place1)
                        "USED" -> seat50.setImageResource(R.drawable.place2)
                        "AWAY" -> seat50.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(50)?.status) {
                        "EMPTY" -> seat51.setImageResource(R.drawable.place1)
                        "USED" -> seat51.setImageResource(R.drawable.place2)
                        "AWAY" -> seat51.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(51)?.status) {
                        "EMPTY" -> seat52.setImageResource(R.drawable.place1)
                        "USED" -> seat52.setImageResource(R.drawable.place2)
                        "AWAY" -> seat52.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(52)?.status) {
                        "EMPTY" -> seat53.setImageResource(R.drawable.place1)
                        "USED" -> seat53.setImageResource(R.drawable.place2)
                        "AWAY" -> seat53.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(53)?.status) {
                        "EMPTY" -> seat54.setImageResource(R.drawable.place1)
                        "USED" -> seat54.setImageResource(R.drawable.place2)
                        "AWAY" -> seat54.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(54)?.status) {
                        "EMPTY" -> seat55.setImageResource(R.drawable.place1)
                        "USED" -> seat55.setImageResource(R.drawable.place2)
                        "AWAY" -> seat55.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(55)?.status) {
                        "EMPTY" -> seat56.setImageResource(R.drawable.place1)
                        "USED" -> seat56.setImageResource(R.drawable.place2)
                        "AWAY" -> seat56.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(56)?.status) {
                        "EMPTY" -> seat57.setImageResource(R.drawable.place1)
                        "USED" -> seat57.setImageResource(R.drawable.place2)
                        "AWAY" -> seat57.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(57)?.status) {
                        "EMPTY" -> seat58.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat58.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat58.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(58)?.status) {
                        "EMPTY" -> seat59.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat59.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat59.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(59)?.status) {
                        "EMPTY" -> seat60.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat60.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat60.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(60)?.status) {
                        "EMPTY" -> seat61.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat61.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat61.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(61)?.status) {
                        "EMPTY" -> seat62.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat62.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat62.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(62)?.status) {
                        "EMPTY" -> seat63.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat63.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat63.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(63)?.status) {
                        "EMPTY" -> seat64.setImageResource(R.drawable.place1)
                        "USED" -> seat64.setImageResource(R.drawable.place2)
                        "AWAY" -> seat64.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(64)?.status) {
                        "EMPTY" -> seat65.setImageResource(R.drawable.place1)
                        "USED" -> seat65.setImageResource(R.drawable.place2)
                        "AWAY" -> seat65.setImageResource(R.drawable.place5)
                        else -> Log.e("error","error")
                    }
                    when (data?.get(65)?.status) {
                        "EMPTY" -> seat66.setImageResource(R.drawable.ellipse22)
                        "USED" -> seat66.setImageResource(R.drawable.placec2)
                        "AWAY" -> seat66.setImageResource(R.drawable.placec5)
                        else -> Log.e("error","error")
                    }
                    HandlerMain()
                }
            }
            override fun onFailure(call: Call<Array<Seats>>, t: Throwable) {
                Log.e("좌석현황", "${t.localizedMessage}")
            }
        })

        topBack.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        }

        topHome.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        }

    }
    fun HandlerMain(){
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, KioskMain::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}

interface CancelStateSuccess{
    @Headers("accept: application/json", "content-type: application/json")
    @GET("/seats")
    fun desk(
    ) : Call<Array<Seats>>
}