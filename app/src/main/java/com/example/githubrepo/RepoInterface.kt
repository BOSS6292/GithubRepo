package com.example.githubrepo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoInterface
{
    @GET("search/repositories?q=language:kotlin&sort=stars&order=desc")
    fun getRepositories(@Query("page") page: Int, @Query("avatar_url")image_url:String ): retrofit2.Call<Repo>
            //Response<Repo>
}