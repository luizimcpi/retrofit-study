package com.devlhse.onboardingclient.service

import com.devlhse.onboardingclient.model.Proposal
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//@Service
class ProposalService {

    fun getProposalById(id: String): Proposal {
//        lateinit var proposalResponse: Proposal
//        val proposalCall = getProposalClient("http://localhost:8002/").findById(id)
//
//        proposalCall.enqueue(object: Callback<Proposal> {
//            override fun onResponse(call: Call<Proposal>, response: Response<Proposal>) {
//                response?.body()?.let {
//                    proposalResponse = it
//                }
//            }
//
//            override fun onFailure(call: Call<Proposal>, t: Throwable) {
//                throw Exception("Erro ao efetuar chamada ao servidor.")
//            }
//        })
//
//        return proposalResponse

        val call = retrofitService().findById(id)
        val response = call.execute()
        if (response.isSuccessful)
            return response.body() as Proposal
        throw Exception(response.errorBody().toString())

    }

    fun retrofitService(): ProposalClient {
        return Retrofit.Builder().baseUrl("http://localhost:8002/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProposalClient::class.java)
    }

}