package com.bookcafe.android.preemptivebookcafe

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DestState {
    @Headers("accept: application/json", "content-type: application/json")
    @GET("/seats")
    fun desk(
    ) : Call<Array<Seats>>
}