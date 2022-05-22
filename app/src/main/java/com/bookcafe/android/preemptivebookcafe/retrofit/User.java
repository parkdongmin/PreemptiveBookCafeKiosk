package com.bookcafe.android.preemptivebookcafe.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("classNo") private String classNo;

    public String getClassNo()
    {
        return classNo;
    }

    public void setClassNo(String classNo)
    {
        this.classNo = classNo;
    }
}
