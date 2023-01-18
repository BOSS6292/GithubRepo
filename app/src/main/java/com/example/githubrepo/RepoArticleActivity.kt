package com.example.githubrepo

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class RepoArticleActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repoarticleactivity)

        val repoArticleImage: ImageView = findViewById(R.id.repo_image)
        val repoArticleTitle: TextView = findViewById(R.id.repo_title)
        val repoArticleStar: TextView = findViewById(R.id.repo_star)
        val repoArticleFork: TextView = findViewById(R.id.repo_fork)
        val repoArticleReadme: WebView = findViewById(R.id.repo_web)
        val repoArticleDesc: TextView = findViewById(R.id.repo_desc)
        //val goToGithubButton: Button = findViewById(R.id.go_to_github)

        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val url = intent.getStringExtra("url")
        val stars = intent.getStringExtra("stars")
        val forks = intent.getStringExtra("forks")

        val url_image: String = "https://avatars.githubusercontent.com/u/82592?v=4"

        Picasso.get()
            .load(url_image)
            .resize(100, 100)
            .centerCrop()
            .into(repoArticleImage)

        repoArticleTitle.text = title
        repoArticleStar.text = stars
        repoArticleFork.text = forks
        repoArticleDesc.text = desc

        repoArticleReadme.webViewClient = WebViewClient()
        if (url != null) {
            repoArticleReadme.loadUrl(url)
        }
        /*goToGithubButton.setOnClickListener {
            val customTabsIntent = CustomTabsIntent.Builder().build()
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }*/
    }
}