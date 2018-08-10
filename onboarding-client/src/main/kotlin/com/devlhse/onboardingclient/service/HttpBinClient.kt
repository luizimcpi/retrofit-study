package com.devlhse.onboardingclient.service

import com.devlhse.onboardingclient.model.HttpBinUuid
import retrofit2.Call
import retrofit2.http.GET

interface HttpBinClient {

    @GET("uuid")
    fun getRandomUUID(): Call<HttpBinUuid>

}