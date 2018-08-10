package com.devlhse.onboardingclient.controller

import com.devlhse.onboardingclient.service.ProposalClient
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RestController
@RequestMapping("/client/proposal")
open class ProposalController() {

    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    open fun getProposal(@PathVariable id: String): ResponseEntity<Any> {
        val call = retrofitService().findById(id)
        val response = call.execute()

        if (response.isSuccessful)
            return ResponseEntity.status(HttpStatus.OK).body(response.body())
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response.errorBody().toString())
    }

    fun retrofitService(): ProposalClient {
        return Retrofit.Builder()
                .baseUrl("http://localhost:8002/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProposalClient::class.java)
    }
}