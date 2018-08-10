package com.devlhse.onboardingclient.service

import com.devlhse.onboardingclient.model.Proposal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProposalClient {

    @GET("proposal/{id}")
    fun findById(@Path("id") id: String): Call<Proposal>

}