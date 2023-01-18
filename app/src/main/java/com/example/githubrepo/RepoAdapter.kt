package com.example.githubrepo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class RepoAdapter(private val list: List<Article>, private val context: Context): RecyclerView.Adapter<RepoAdapter.RepoViewHolder>()
{
    class RepoViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        val titleText: TextView = itemView.findViewById(R.id.item_text)
        val descText: TextView = itemView.findViewById(R.id.item_desc)
        val repoStar: TextView = itemView.findViewById(R.id.item_star)
        val repoFork: TextView = itemView.findViewById(R.id.item_fork)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.repo_item,parent,false)
        return RepoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int)
    {
        holder.titleText.text = list[position].full_name
        holder.descText.text = list[position].description
        holder.repoStar.text = list[position].stargazers_count
        holder.repoFork.text = list[position].forks_count

        //Glide.with(context).load(list[position].avatar_url).into(holder.itemImage)
        /*Picasso.get()
            .load(list[position].avatar_url)
            .resize(50, 50)
            .centerCrop()
            .into(holder.itemImage)*/

        val currentItem =list[position]
        Glide.with(context).load(list[position].avatar_url).into(holder.itemImage)

        holder.itemView.setOnClickListener{
            val intent =Intent(context,RepoArticleActivity::class.java)
            val bundle = bundleOf("image" to currentItem.avatar_url,
                "title" to currentItem.full_name,
                "desc" to currentItem.description,
                "url" to currentItem.html_url,
                "stars" to currentItem.stargazers_count,
                "forks" to currentItem.forks_count
            )
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}