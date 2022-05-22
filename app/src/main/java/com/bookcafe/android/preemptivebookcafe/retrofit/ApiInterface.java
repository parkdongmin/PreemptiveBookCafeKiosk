package com.bookcafe.android.preemptivebookcafe.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("example_select.php")
    Call<User> getNameHobby(
            @Query("class_no") String classNo
    );
}
