package com.example.ytube9;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    // https://run.mocky.io/    v3/df6e3385-c3be-4402-b451-97311848d953


    @GET("v3/df6e3385-c3be-4402-b451-97311848d953")
    Call<DataModel> getData();



}
