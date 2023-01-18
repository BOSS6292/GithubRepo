package com.example.githubrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        getRepo()
    }

    private fun getRepo() {
        val repo = ServiceApi.repositoryInstance.getRepositories(1, 1.toString())
        repo.enqueue(object : Callback<Repo>{
            override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                val repoResponse = response.body()
                repoResponse?.let {
                    recyclerView.adapter = RepoAdapter(repoResponse.items,this@MainActivity)
                }
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<Repo>, t: Throwable) {
                Log.e("MainActivity",t.message.toString())
            }
        })
    }
}