package com.bookcafe.android.preemptivebookcafe

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.kiosk_desk_change.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.time.LocalDateTime

class KioskDeskChange : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kiosk_desk_change)

        var intentData = intent
        var stuNum = intentData.getStringExtra("classNo")
        var seatId = intentData.getStringExtra("seatId")
        var status = intentData.getStringExtra("status")

        topNum.setText(stuNum.toString())

        var id = 0
        var cnt = 0
        var choiceDeskArray = Array<Int>(66) { 1 }

        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer())
        val gson: Gson = gsonBuilder.setPrettyPrinting().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://3.36.156.88:8080")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val service = retrofit.create(ChangeState::class.java)

        service.desk()?.enqueue( object : Callback<Array<Seats>> {
            override fun onResponse(call: Call<Array<Seats>>, response: Response<Array<Seats>>) {
                if(response.code()==400){
                    Log.d("에러 ", "${response.errorBody()?.string()!!}")
                }
                else{
                    Log.d("좌석현황" , "${response.raw()}")
                    var data : Array<Seats>? = response?.body()

                    seat1.setOnClickListener {
                        if(choiceDeskArray[0] % 2 == 0){
                            when (data?.get(0)?.status) {
                                "EMPTY" -> seat1.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat1.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat1.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            Log.d("id : ", "$id")
                            cnt -= 1
                            choiceDeskArray[0] = choiceDeskArray[0] + 1
                            Log.d("cnt", "$cnt")
                        }else{
                            seat1.setImageResource(R.drawable.placec4)
                            Log.d("id : ", "$id")
                            cnt += 1
                            choiceDeskArray[0] = choiceDeskArray[0] + 1
                            Log.d("cnt", "$cnt")
                        }
                    }

                    seat2.setOnClickListener {
                        if(choiceDeskArray[1] % 2 == 0){
                            when (data?.get(1)?.status) {
                                "EMPTY" -> seat2.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat2.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat2.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            Log.d("id : ", "$id")
                            cnt -= 1
                            choiceDeskArray[1] += 1
                        }else{
                            seat2.setImageResource(R.drawable.placec4)
                            Log.d("id : ", "$id")
                            cnt += 1
                            choiceDeskArray[1] += 1
                        }
                    }

                    seat3.setOnClickListener {
                        if(choiceDeskArray[2] % 2 == 0){
                            when (data?.get(2)?.status) {
                                "EMPTY" -> seat3.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat3.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat3.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            Log.d("id : ", "$id")
                            cnt -= 1
                            choiceDeskArray[2] += 1
                        }else{
                            seat3.setImageResource(R.drawable.placec4)
                            Log.d("id : ", "$id")
                            cnt += 1
                            choiceDeskArray[2] += 1
                        }
                    }

                    seat4.setOnClickListener {
                        if(choiceDeskArray[3] % 2 == 0){
                            when (data?.get(3)?.status) {
                                "EMPTY" -> seat4.setImageResource(R.drawable.rectangle751)
                                "USED" -> seat4.setImageResource(R.drawable.placev2)
                                "AWAY" -> seat4.setImageResource(R.drawable.placev5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[3] += 1
                        }else{
                            seat4.setImageResource(R.drawable.placev4)
                            cnt += 1
                            choiceDeskArray[3] += 1
                        }
                    }

                    seat5.setOnClickListener {
                        if(choiceDeskArray[4] % 2 == 0){
                            when (data?.get(4)?.status) {
                                "EMPTY" -> seat5.setImageResource(R.drawable.rectangle751)
                                "USED" -> seat5.setImageResource(R.drawable.placev2)
                                "AWAY" -> seat5.setImageResource(R.drawable.placev5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[4] += 1
                        }else{
                            seat5.setImageResource(R.drawable.placev4)
                            cnt += 1
                            choiceDeskArray[4] += 1
                        }
                    }

                    seat6.setOnClickListener {
                        if(choiceDeskArray[5] % 2 == 0){
                            when (data?.get(5)?.status) {
                                "EMPTY" -> seat6.setImageResource(R.drawable.rectangle751)
                                "USED" -> seat6.setImageResource(R.drawable.placev2)
                                "AWAY" -> seat6.setImageResource(R.drawable.placev5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[5] += 1
                        }else{
                            seat6.setImageResource(R.drawable.placev4)
                            cnt += 1
                            choiceDeskArray[5] += 1
                        }
                    }

                    seat7.setOnClickListener {
                        if(choiceDeskArray[6] % 2 == 0){
                            when (data?.get(6)?.status) {
                                "EMPTY" -> seat7.setImageResource(R.drawable.rectangle751)
                                "USED" -> seat7.setImageResource(R.drawable.placev2)
                                "AWAY" -> seat7.setImageResource(R.drawable.placev5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[6] += 1
                        }else{
                            seat7.setImageResource(R.drawable.placev4)
                            cnt += 1
                            choiceDeskArray[6] += 1
                        }
                    }

                    seat8.setOnClickListener {
                        if(choiceDeskArray[7] % 2 == 0){
                            when (data?.get(7)?.status) {
                                "EMPTY" -> seat8.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat8.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat8.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[7] += 1
                        }else{
                            seat8.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[7] += 1
                        }
                    }

                    seat9.setOnClickListener {
                        if(choiceDeskArray[8] % 2 == 0){
                            when (data?.get(8)?.status) {
                                "EMPTY" -> seat9.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat9.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat9.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[8] += 1
                        }else{
                            seat9.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[8] += 1
                        }
                    }

                    seat10.setOnClickListener {
                        if(choiceDeskArray[9] % 2 == 0){
                            when (data?.get(9)?.status) {
                                "EMPTY" -> seat10.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat10.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat10.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[9] += 1
                        }else{
                            seat10.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[9] += 1
                        }
                    }

                    seat11.setOnClickListener {
                        if(choiceDeskArray[10] % 2 == 0){
                            when (data?.get(10)?.status) {
                                "EMPTY" -> seat11.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat11.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat11.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[10] += 1
                        }else{
                            seat11.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[10] += 1
                        }
                    }

                    seat12.setOnClickListener {
                        if(choiceDeskArray[11] % 2 == 0){
                            when (data?.get(11)?.status) {
                                "EMPTY" -> seat12.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat12.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat12.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[11] += 1
                        }else{
                            seat12.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[11] += 1
                        }
                    }

                    seat13.setOnClickListener {
                        if(choiceDeskArray[12] % 2 == 0){
                            when (data?.get(12)?.status) {
                                "EMPTY" -> seat13.setImageResource(R.drawable.place1)
                                "USED" -> seat13.setImageResource(R.drawable.place2)
                                "AWAY" -> seat13.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[12] += 1
                        }else{
                            seat13.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[12] += 1
                        }
                    }

                    seat14.setOnClickListener {
                        if(choiceDeskArray[13] % 2 == 0){
                            when (data?.get(13)?.status) {
                                "EMPTY" -> seat14.setImageResource(R.drawable.place1)
                                "USED" -> seat14.setImageResource(R.drawable.place2)
                                "AWAY" -> seat14.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[13] += 1
                        }else{
                            seat14.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[13] += 1
                        }
                    }

                    seat15.setOnClickListener {
                        if(choiceDeskArray[14] % 2 == 0){
                            when (data?.get(14)?.status) {
                                "EMPTY" -> seat15.setImageResource(R.drawable.place1)
                                "USED" -> seat15.setImageResource(R.drawable.place2)
                                "AWAY" -> seat15.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[14] += 1
                        }else{
                            seat15.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[14] += 1
                        }
                    }

                    seat16.setOnClickListener {
                        if(choiceDeskArray[15] % 2 == 0){
                            when (data?.get(15)?.status) {
                                "EMPTY" -> seat16.setImageResource(R.drawable.place1)
                                "USED" -> seat16.setImageResource(R.drawable.place2)
                                "AWAY" -> seat16.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[15] += 1
                        }else{
                            seat16.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[15] += 1
                        }
                    }

                    seat17.setOnClickListener {
                        if(choiceDeskArray[16] % 2 == 0){
                            when (data?.get(16)?.status) {
                                "EMPTY" -> seat17.setImageResource(R.drawable.place1)
                                "USED" -> seat17.setImageResource(R.drawable.place2)
                                "AWAY" -> seat17.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[16] += 1
                        }else{
                            seat17.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[16] += 1
                        }
                    }

                    seat18.setOnClickListener {
                        if(choiceDeskArray[17] % 2 == 0){
                            when (data?.get(17)?.status) {
                                "EMPTY" -> seat18.setImageResource(R.drawable.place1)
                                "USED" -> seat18.setImageResource(R.drawable.place2)
                                "AWAY" -> seat18.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[17] += 1
                        }else{
                            seat18.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[17] += 1
                        }
                    }

                    seat19.setOnClickListener {
                        if(choiceDeskArray[18] % 2 == 0){
                            when (data?.get(18)?.status) {
                                "EMPTY" -> seat19.setImageResource(R.drawable.place1)
                                "USED" -> seat19.setImageResource(R.drawable.place2)
                                "AWAY" -> seat19.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[18] += 1
                        }else{
                            seat19.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[18] += 1
                        }
                    }

                    seat20.setOnClickListener {
                        if(choiceDeskArray[19] % 2 == 0){
                            when (data?.get(19)?.status) {
                                "EMPTY" -> seat20.setImageResource(R.drawable.place1)
                                "USED" -> seat20.setImageResource(R.drawable.place2)
                                "AWAY" -> seat20.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[19] += 1
                        }else{
                            seat20.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[19] += 1
                        }
                    }

                    seat21.setOnClickListener {
                        if(choiceDeskArray[20] % 2 == 0){
                            when (data?.get(20)?.status) {
                                "EMPTY" -> seat21.setImageResource(R.drawable.place1)
                                "USED" -> seat21.setImageResource(R.drawable.place2)
                                "AWAY" -> seat21.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[20] += 1
                        }else{
                            seat21.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[20] += 1
                        }
                    }

                    seat22.setOnClickListener {
                        if(choiceDeskArray[21] % 2 == 0){
                            when (data?.get(21)?.status) {
                                "EMPTY" -> seat22.setImageResource(R.drawable.place1)
                                "USED" -> seat22.setImageResource(R.drawable.place2)
                                "AWAY" -> seat22.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[21] += 1
                        }else{
                            seat22.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[21] += 1
                        }
                    }

                    seat23.setOnClickListener {
                        if(choiceDeskArray[22] % 2 == 0){
                            when (data?.get(22)?.status) {
                                "EMPTY" -> seat23.setImageResource(R.drawable.place1)
                                "USED" -> seat23.setImageResource(R.drawable.place2)
                                "AWAY" -> seat23.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[22] += 1
                        }else{
                            seat23.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[22] += 1
                        }
                    }

                    seat24.setOnClickListener {
                        if(choiceDeskArray[23] % 2 == 0){
                            when (data?.get(23)?.status) {
                                "EMPTY" -> seat24.setImageResource(R.drawable.place1)
                                "USED" -> seat24.setImageResource(R.drawable.place2)
                                "AWAY" -> seat24.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[23] += 1
                        }else{
                            seat24.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[23] += 1
                        }
                    }

                    seat25.setOnClickListener {
                        if(choiceDeskArray[24] % 2 == 0){
                            when (data?.get(24)?.status) {
                                "EMPTY" -> seat25.setImageResource(R.drawable.place1)
                                "USED" -> seat25.setImageResource(R.drawable.place2)
                                "AWAY" -> seat25.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[24] += 1
                        }else{
                            seat25.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[24] += 1
                        }
                    }

                    seat26.setOnClickListener {
                        if(choiceDeskArray[25] % 2 == 0){
                            when (data?.get(25)?.status) {
                                "EMPTY" -> seat26.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat26.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat26.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[25] += 1
                        }else{
                            seat26.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[25] += 1
                        }
                    }

                    seat27.setOnClickListener {
                        if(choiceDeskArray[26] % 2 == 0){
                            when (data?.get(26)?.status) {
                                "EMPTY" -> seat27.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat27.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat27.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[26] += 1
                        }else{
                            seat27.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[26] += 1
                        }
                    }

                    seat28.setOnClickListener {
                        if(choiceDeskArray[27] % 2 == 0){
                            when (data?.get(27)?.status) {
                                "EMPTY" -> seat28.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat28.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat28.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[27] += 1
                        }else{
                            seat28.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[27] += 1
                        }
                    }

                    seat29.setOnClickListener {
                        if(choiceDeskArray[28] % 2 == 0){
                            when (data?.get(28)?.status) {
                                "EMPTY" -> seat29.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat29.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat29.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[28] += 1
                        }else{
                            seat29.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[28] += 1
                        }
                    }

                    seat30.setOnClickListener {
                        if(choiceDeskArray[29] % 2 == 0){
                            when (data?.get(29)?.status) {
                                "EMPTY" -> seat30.setImageResource(R.drawable.rectangle157)
                                "USED" -> seat30.setImageResource(R.drawable.placeh2)
                                "AWAY" -> seat30.setImageResource(R.drawable.placeh5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[29] += 1
                        }else{
                            seat30.setImageResource(R.drawable.placeh4)
                            cnt += 1
                            choiceDeskArray[29] += 1
                        }
                    }

                    seat31.setOnClickListener {
                        if(choiceDeskArray[30] % 2 == 0){
                            when (data?.get(30)?.status) {
                                "EMPTY" -> seat31.setImageResource(R.drawable.place1)
                                "USED" -> seat31.setImageResource(R.drawable.place2)
                                "AWAY" -> seat31.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[30] += 1
                        }else{
                            seat31.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[30] += 1
                        }
                    }

                    seat32.setOnClickListener {
                        if(choiceDeskArray[31] % 2 == 0){
                            when (data?.get(31)?.status) {
                                "EMPTY" -> seat32.setImageResource(R.drawable.place1)
                                "USED" -> seat32.setImageResource(R.drawable.place2)
                                "AWAY" -> seat32.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[31] += 1
                        }else{
                            seat32.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[31] += 1
                        }
                    }

                    seat33.setOnClickListener {
                        if(choiceDeskArray[32] % 2 == 0){
                            when (data?.get(32)?.status) {
                                "EMPTY" -> seat33.setImageResource(R.drawable.place1)
                                "USED" -> seat33.setImageResource(R.drawable.place2)
                                "AWAY" -> seat33.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[32] += 1
                        }else{
                            seat33.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[32] += 1
                        }
                    }

                    seat34.setOnClickListener {
                        if(choiceDeskArray[33] % 2 == 0){
                            when (data?.get(33)?.status) {
                                "EMPTY" -> seat34.setImageResource(R.drawable.place1)
                                "USED" -> seat34.setImageResource(R.drawable.place2)
                                "AWAY" -> seat34.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[33] += 1
                        }else{
                            seat34.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[33] += 1
                        }
                    }

                    seat35.setOnClickListener {
                        if(choiceDeskArray[34] % 2 == 0){
                            when (data?.get(34)?.status) {
                                "EMPTY" -> seat35.setImageResource(R.drawable.place1)
                                "USED" -> seat35.setImageResource(R.drawable.place2)
                                "AWAY" -> seat35.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[34] += 1
                        }else{
                            seat35.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[34] += 1
                        }
                    }

                    seat36.setOnClickListener {
                        if(choiceDeskArray[35] % 2 == 0){
                            when (data?.get(35)?.status) {
                                "EMPTY" -> seat36.setImageResource(R.drawable.place1)
                                "USED" -> seat36.setImageResource(R.drawable.place2)
                                "AWAY" -> seat36.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[35] += 1
                        }else{
                            seat36.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[35] += 1
                        }
                    }

                    seat37.setOnClickListener {
                        if(choiceDeskArray[36] % 2 == 0){
                            when (data?.get(36)?.status) {
                                "EMPTY" -> seat37.setImageResource(R.drawable.place1)
                                "USED" -> seat37.setImageResource(R.drawable.place2)
                                "AWAY" -> seat37.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[36] += 1
                        }else{
                            seat37.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[36] += 1
                        }
                    }

                    seat38.setOnClickListener {
                        if(choiceDeskArray[37] % 2 == 0){
                            when (data?.get(37)?.status) {
                                "EMPTY" -> seat38.setImageResource(R.drawable.place1)
                                "USED" -> seat38.setImageResource(R.drawable.place2)
                                "AWAY" -> seat38.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[37] += 1
                        }else{
                            seat38.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[37] += 1
                        }
                    }

                    seat39.setOnClickListener {
                        if(choiceDeskArray[38] % 2 == 0){
                            when (data?.get(38)?.status) {
                                "EMPTY" -> seat39.setImageResource(R.drawable.place1)
                                "USED" -> seat39.setImageResource(R.drawable.place2)
                                "AWAY" -> seat39.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[38] += 1
                        }else{
                            seat39.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[38] += 1
                        }
                    }

                    seat40.setOnClickListener {
                        if(choiceDeskArray[39] % 2 == 0){
                            when (data?.get(39)?.status) {
                                "EMPTY" -> seat40.setImageResource(R.drawable.place1)
                                "USED" -> seat40.setImageResource(R.drawable.place2)
                                "AWAY" -> seat40.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[39] += 1
                        }else{
                            seat40.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[39] += 1
                        }
                    }

                    seat41.setOnClickListener {
                        if(choiceDeskArray[40] % 2 == 0){
                            when (data?.get(40)?.status) {
                                "EMPTY" -> seat41.setImageResource(R.drawable.place1)
                                "USED" -> seat41.setImageResource(R.drawable.place2)
                                "AWAY" -> seat41.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[40] += 1
                        }else{
                            seat41.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[40] += 1
                        }
                    }

                    seat42.setOnClickListener {
                        if(choiceDeskArray[41] % 2 == 0){
                            when (data?.get(41)?.status) {
                                "EMPTY" -> seat42.setImageResource(R.drawable.place1)
                                "USED" -> seat42.setImageResource(R.drawable.place2)
                                "AWAY" -> seat42.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[41] += 1
                        }else{
                            seat42.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[41] += 1
                        }
                    }

                    seat43.setOnClickListener {
                        if(choiceDeskArray[42] % 2 == 0){
                            when (data?.get(42)?.status) {
                                "EMPTY" -> seat43.setImageResource(R.drawable.place1)
                                "USED" -> seat43.setImageResource(R.drawable.place2)
                                "AWAY" -> seat43.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[42] += 1
                        }else{
                            seat43.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[42] += 1
                        }
                    }

                    seat44.setOnClickListener {
                        if(choiceDeskArray[43] % 2 == 0){
                            when (data?.get(43)?.status) {
                                "EMPTY" -> seat44.setImageResource(R.drawable.place1)
                                "USED" -> seat44.setImageResource(R.drawable.place2)
                                "AWAY" -> seat44.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[43] += 1
                        }else{
                            seat44.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[43] += 1
                        }
                    }

                    seat45.setOnClickListener {
                        if(choiceDeskArray[44] % 2 == 0){
                            when (data?.get(44)?.status) {
                                "EMPTY" -> seat45.setImageResource(R.drawable.place1)
                                "USED" -> seat45.setImageResource(R.drawable.place2)
                                "AWAY" -> seat45.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[44] += 1
                        }else{
                            seat45.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[44] += 1
                        }
                    }

                    seat46.setOnClickListener {
                        if(choiceDeskArray[45] % 2 == 0){
                            when (data?.get(45)?.status) {
                                "EMPTY" -> seat46.setImageResource(R.drawable.place1)
                                "USED" -> seat46.setImageResource(R.drawable.place2)
                                "AWAY" -> seat46.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[45] += 1
                        }else{
                            seat46.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[45] += 1
                        }
                    }

                    seat47.setOnClickListener {
                        if(choiceDeskArray[46] % 2 == 0){
                            when (data?.get(46)?.status) {
                                "EMPTY" -> seat47.setImageResource(R.drawable.place1)
                                "USED" -> seat47.setImageResource(R.drawable.place2)
                                "AWAY" -> seat47.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[46] += 1
                        }else{
                            seat47.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[46] += 1
                        }
                    }

                    seat48.setOnClickListener {
                        if(choiceDeskArray[47] % 2 == 0){
                            when (data?.get(47)?.status) {
                                "EMPTY" -> seat48.setImageResource(R.drawable.place1)
                                "USED" -> seat48.setImageResource(R.drawable.place2)
                                "AWAY" -> seat48.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[47] += 1
                        }else{
                            seat48.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[47] += 1
                        }
                    }

                    seat49.setOnClickListener {
                        if(choiceDeskArray[48] % 2 == 0){
                            when (data?.get(48)?.status) {
                                "EMPTY" -> seat49.setImageResource(R.drawable.place1)
                                "USED" -> seat49.setImageResource(R.drawable.place2)
                                "AWAY" -> seat49.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[48] += 1
                        }else{
                            seat49.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[48] += 1
                        }
                    }

                    seat50.setOnClickListener {
                        if(choiceDeskArray[49] % 2 == 0){
                            when (data?.get(49)?.status) {
                                "EMPTY" -> seat50.setImageResource(R.drawable.place1)
                                "USED" -> seat50.setImageResource(R.drawable.place2)
                                "AWAY" -> seat50.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[49] += 1
                        }else{
                            seat50.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[49] += 1
                        }
                    }

                    seat51.setOnClickListener {
                        if(choiceDeskArray[50] % 2 == 0){
                            when (data?.get(50)?.status) {
                                "EMPTY" -> seat51.setImageResource(R.drawable.place1)
                                "USED" -> seat51.setImageResource(R.drawable.place2)
                                "AWAY" -> seat51.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[50] += 1
                        }else{
                            seat51.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[50] += 1
                        }
                    }

                    seat52.setOnClickListener {
                        if(choiceDeskArray[51] % 2 == 0){
                            when (data?.get(51)?.status) {
                                "EMPTY" -> seat52.setImageResource(R.drawable.place1)
                                "USED" -> seat52.setImageResource(R.drawable.place2)
                                "AWAY" -> seat52.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[51] += 1
                        }else{
                            seat52.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[51] += 1
                        }
                    }

                    seat53.setOnClickListener {
                        if(choiceDeskArray[52] % 2 == 0){
                            when (data?.get(52)?.status) {
                                "EMPTY" -> seat53.setImageResource(R.drawable.place1)
                                "USED" -> seat53.setImageResource(R.drawable.place2)
                                "AWAY" -> seat53.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[52] += 1
                        }else{
                            seat53.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[52] += 1
                        }
                    }

                    seat54.setOnClickListener {
                        if(choiceDeskArray[53] % 2 == 0){
                            when (data?.get(53)?.status) {
                                "EMPTY" -> seat54.setImageResource(R.drawable.place1)
                                "USED" -> seat54.setImageResource(R.drawable.place2)
                                "AWAY" -> seat54.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[53] += 1
                        }else{
                            seat54.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[53] += 1
                        }
                    }

                    seat55.setOnClickListener {
                        if(choiceDeskArray[54] % 2 == 0){
                            when (data?.get(54)?.status) {
                                "EMPTY" -> seat55.setImageResource(R.drawable.place1)
                                "USED" -> seat55.setImageResource(R.drawable.place2)
                                "AWAY" -> seat55.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[54] += 1
                        }else{
                            seat55.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[54] += 1
                        }
                    }

                    seat56.setOnClickListener {
                        if(choiceDeskArray[55] % 2 == 0){
                            when (data?.get(55)?.status) {
                                "EMPTY" -> seat56.setImageResource(R.drawable.place1)
                                "USED" -> seat56.setImageResource(R.drawable.place2)
                                "AWAY" -> seat56.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[55] += 1
                        }else{
                            seat56.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[55] += 1
                        }
                    }

                    seat57.setOnClickListener {
                        if(choiceDeskArray[56] % 2 == 0){
                            when (data?.get(56)?.status) {
                                "EMPTY" -> seat57.setImageResource(R.drawable.place1)
                                "USED" -> seat57.setImageResource(R.drawable.place2)
                                "AWAY" -> seat57.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[56] += 1
                        }else{
                            seat57.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[56] += 1
                        }
                    }

                    seat58.setOnClickListener {
                        if(choiceDeskArray[57] % 2 == 0){
                            when (data?.get(57)?.status) {
                                "EMPTY" -> seat58.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat58.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat58.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[57] += 1
                        }else{
                            seat58.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[57] += 1
                        }
                    }

                    seat59.setOnClickListener {
                        if(choiceDeskArray[58] % 2 == 0){
                            when (data?.get(58)?.status) {
                                "EMPTY" -> seat59.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat59.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat59.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[58] += 1
                        }else{
                            seat59.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[58] += 1
                        }
                    }

                    seat60.setOnClickListener {
                        if(choiceDeskArray[59] % 2 == 0){
                            when (data?.get(59)?.status) {
                                "EMPTY" -> seat60.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat60.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat60.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[59] += 1
                        }else{
                            seat60.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[59] += 1
                        }
                    }

                    seat61.setOnClickListener {
                        if(choiceDeskArray[60] % 2 == 0){
                            when (data?.get(60)?.status) {
                                "EMPTY" -> seat61.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat61.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat61.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[60] += 1
                        }else{
                            seat61.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[60] += 1
                        }
                    }

                    seat62.setOnClickListener {
                        if(choiceDeskArray[61] % 2 == 0){
                            when (data?.get(61)?.status) {
                                "EMPTY" -> seat62.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat62.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat62.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[61] += 1
                        }else{
                            seat62.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[61] += 1
                        }
                    }

                    seat63.setOnClickListener {
                        if(choiceDeskArray[62] % 2 == 0){
                            when (data?.get(62)?.status) {
                                "EMPTY" -> seat63.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat63.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat63.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[62] += 1
                        }else{
                            seat63.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[62] += 1
                        }
                    }

                    seat64.setOnClickListener {
                        if(choiceDeskArray[63] % 2 == 0){
                            when (data?.get(63)?.status) {
                                "EMPTY" -> seat64.setImageResource(R.drawable.place1)
                                "USED" -> seat64.setImageResource(R.drawable.place2)
                                "AWAY" -> seat64.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[63] += 1
                        }else{
                            seat64.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[63] += 1
                        }
                    }

                    seat65.setOnClickListener {
                        if(choiceDeskArray[64] % 2 == 0){
                            when (data?.get(64)?.status) {
                                "EMPTY" -> seat65.setImageResource(R.drawable.place1)
                                "USED" -> seat65.setImageResource(R.drawable.place2)
                                "AWAY" -> seat65.setImageResource(R.drawable.place5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[64] += 1
                        }else{
                            seat65.setImageResource(R.drawable.place4)
                            cnt += 1
                            choiceDeskArray[64] += 1
                        }
                    }

                    seat66.setOnClickListener {
                        if(choiceDeskArray[65] % 2 == 0){
                            when (data?.get(65)?.status) {
                                "EMPTY" -> seat66.setImageResource(R.drawable.ellipse22)
                                "USED" -> seat66.setImageResource(R.drawable.placec2)
                                "AWAY" -> seat66.setImageResource(R.drawable.placec5)
                                else -> Log.e("error","error")
                            }
                            cnt -= 1
                            choiceDeskArray[65] += 1
                        }else{
                            seat66.setImageResource(R.drawable.placec4)
                            cnt += 1
                            choiceDeskArray[65] += 1
                        }
                    }

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
                    when(intentData.getStringExtra("seatId").toString()){
                        "1" -> seat1.setImageResource(R.drawable.placec3)
                        "2" -> seat2.setImageResource(R.drawable.placec3)
                        "3" -> seat3.setImageResource(R.drawable.placec3)
                        "4" -> seat4.setImageResource(R.drawable.placev3)
                        "5" -> seat5.setImageResource(R.drawable.placev3)
                        "6" -> seat6.setImageResource(R.drawable.placev3)
                        "7" -> seat7.setImageResource(R.drawable.placev3)
                        "8" -> seat8.setImageResource(R.drawable.placeh3)
                        "9" -> seat9.setImageResource(R.drawable.placeh3)
                        "10" -> seat10.setImageResource(R.drawable.placeh3)
                        "11" -> seat11.setImageResource(R.drawable.placeh3)
                        "12" -> seat12.setImageResource(R.drawable.placec3)
                        "13" -> seat13.setImageResource(R.drawable.place3)
                        "14" -> seat14.setImageResource(R.drawable.place3)
                        "15" -> seat15.setImageResource(R.drawable.place3)
                        "16" -> seat16.setImageResource(R.drawable.place3)
                        "17" -> seat17.setImageResource(R.drawable.place3)
                        "18" -> seat18.setImageResource(R.drawable.place3)
                        "19" -> seat19.setImageResource(R.drawable.place3)
                        "20" -> seat20.setImageResource(R.drawable.place3)
                        "21" -> seat21.setImageResource(R.drawable.place3)
                        "22" -> seat22.setImageResource(R.drawable.place3)
                        "23" -> seat23.setImageResource(R.drawable.place3)
                        "24" -> seat24.setImageResource(R.drawable.place3)
                        "25" -> seat25.setImageResource(R.drawable.place3)
                        "26" -> seat26.setImageResource(R.drawable.placec3)
                        "27" -> seat27.setImageResource(R.drawable.placeh3)
                        "28" -> seat28.setImageResource(R.drawable.placeh3)
                        "29" -> seat29.setImageResource(R.drawable.placeh3)
                        "30" -> seat30.setImageResource(R.drawable.placeh3)
                        "31" -> seat31.setImageResource(R.drawable.place3)
                        "32" -> seat32.setImageResource(R.drawable.place3)
                        "33" -> seat33.setImageResource(R.drawable.place3)
                        "34" -> seat34.setImageResource(R.drawable.place3)
                        "35" -> seat35.setImageResource(R.drawable.place3)
                        "36" -> seat36.setImageResource(R.drawable.place3)
                        "37" -> seat37.setImageResource(R.drawable.place3)
                        "38" -> seat38.setImageResource(R.drawable.place3)
                        "39" -> seat39.setImageResource(R.drawable.place3)
                        "40" -> seat40.setImageResource(R.drawable.place3)
                        "41" -> seat41.setImageResource(R.drawable.place3)
                        "42" -> seat42.setImageResource(R.drawable.place3)
                        "43" -> seat43.setImageResource(R.drawable.place3)
                        "44" -> seat44.setImageResource(R.drawable.place3)
                        "45" -> seat45.setImageResource(R.drawable.place3)
                        "46" -> seat46.setImageResource(R.drawable.place3)
                        "47" -> seat47.setImageResource(R.drawable.place3)
                        "48" -> seat48.setImageResource(R.drawable.place3)
                        "49" -> seat49.setImageResource(R.drawable.place3)
                        "50" -> seat50.setImageResource(R.drawable.place3)
                        "51" -> seat51.setImageResource(R.drawable.place3)
                        "52" -> seat52.setImageResource(R.drawable.place3)
                        "53" -> seat53.setImageResource(R.drawable.place3)
                        "54" -> seat54.setImageResource(R.drawable.place3)
                        "55" -> seat55.setImageResource(R.drawable.place3)
                        "56" -> seat56.setImageResource(R.drawable.place3)
                        "57" -> seat57.setImageResource(R.drawable.place3)
                        "58" -> seat58.setImageResource(R.drawable.placec3)
                        "59" -> seat59.setImageResource(R.drawable.placec3)
                        "60" -> seat60.setImageResource(R.drawable.placec3)
                        "61" -> seat61.setImageResource(R.drawable.placec3)
                        "62" -> seat62.setImageResource(R.drawable.placec3)
                        "63" -> seat63.setImageResource(R.drawable.placec3)
                        "64" -> seat64.setImageResource(R.drawable.place3)
                        "65" -> seat65.setImageResource(R.drawable.place3)
                        "66" -> seat66.setImageResource(R.drawable.placec3)
                    }
                }
            }
            override fun onFailure(call: Call<Array<Seats>>, t: Throwable) {
                Log.e("좌석현황", "${t.localizedMessage}")
            }
        })



        deskChangeBtn.setOnClickListener {
            if(cnt == 0){
                Toast.makeText(applicationContext, "변경을 원하는 좌석을 선택해주세요.", Toast.LENGTH_SHORT).show()
            }else if(cnt > 1){
                Toast.makeText(applicationContext, "한 좌석만 선택해주세요.", Toast.LENGTH_SHORT).show()
            }else if(seatId.toString() == id.toString()){
                Toast.makeText(applicationContext, "변경할 좌석을 선택해주세요.", Toast.LENGTH_SHORT).show()
            }else{
                for(i in 0..65){
                    if(choiceDeskArray[i] % 2 == 0){
                        id = i + 1
                    }
                }
                val service = retrofit.create(ChangeChoice::class.java)
                val user = UserObject(stuNum!!.toLong())
                val changeValue = UserRequest(id.toLong(),user)
                service.deskChange(changeValue).enqueue(object : Callback<Object> {
                    override fun onResponse(call: Call<Object>, response: Response<Object>) {
                        if(response.code()==400){
                            Log.d("에러 ", "${response.errorBody()?.string()!!}")
                            changeFailLink(stuNum.toString(), status.toString(), seatId.toString())
                        }
                        else{
                            Log.d("좌석변경" , "${response.raw()}")
                            Log.d("좌석변경" , "${response.body()}")
                            changeSuccessLink(stuNum.toString(), id.toString(), seatId.toString())
                        }
                    }
                    override fun onFailure(call: Call<Object>, t: Throwable) {
                        Log.e("좌석변경에러", "${t.localizedMessage}")
                        changeFailLink(stuNum.toString(), status.toString(), seatId.toString())
                    }
                })
            }
        }



        topBack.setOnClickListener {
            var intent = Intent(this, KioskMenuSelect::class.java)
            intent.putExtra("classNo",stuNum)
            intent.putExtra("id", id)
            intent.putExtra("status", status)
            intent.putExtra("seatId", seatId)
            startActivity(intent)
            finish()
        }
        topHome.setOnClickListener {
            var intent = Intent(this, KioskMain::class.java)
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

    fun changeSuccessLink(stuNum : String, id : String, seatId: String){
        var intent = Intent(this, KioskDeskChangeSuccess::class.java) //다음 화면 이동을 위한 intent 객체 생성
        intent.putExtra("classNo",stuNum)
        intent.putExtra("id", id)
        intent.putExtra("seatId", seatId)
        startActivity(intent)
        finish()
    }

    fun changeFailLink(stuNum : String, status : String, seatId : String){
        var intent = Intent(this, KioskDeskChangeFail::class.java) //다음 화면 이동을 위한 intent 객체 생성
        intent.putExtra("classNo",stuNum)
        intent.putExtra("status",status)
        intent.putExtra("seatId",seatId)
        startActivity(intent)
        finish()
    }
}

interface ChangeChoice{
    @Headers("accept: application/json", "content-type: application/json")
    @PUT("/seats")
    fun deskChange(
        @Body seats : UserRequest
    ) : Call<Object>
}

interface ChangeState{
    @Headers("accept: application/json", "content-type: application/json")
    @GET("/seats")
    fun desk(
    ) : Call<Array<Seats>>
}