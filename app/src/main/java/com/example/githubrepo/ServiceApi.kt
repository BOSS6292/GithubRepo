package com.example.githubrepo

import com.example.githubrepo.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceApi
{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val repositoryInstance =retrofit.create(RepoInterface::class.java)
}