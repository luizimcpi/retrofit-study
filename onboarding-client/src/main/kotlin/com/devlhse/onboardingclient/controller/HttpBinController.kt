package com.devlhse.onboardingclient.controller

import com.devlhse.onboardingclient.service.HttpBinClient
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RestController
@RequestMapping("/client")
open class HttpBinController() {

    @GetMapping(path = ["/httpbin/uuid"], produces = [MediaType.APPLICATION_JSON_VALUE])
    open fun getRandomUUID(): ResponseEntity<Any> {
        val call = retrofitService().getRandomUUID()
        val response = call.execute()

        if (response.isSuccessful)
            return ResponseEntity.status(HttpStatus.OK).body(response.body())
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response.errorBody().toString())
    }

    fun retrofitService(): HttpBinClient {
        return Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HttpBinClient::class.java)
    }
}