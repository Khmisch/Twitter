package com.example.twitter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.R
import com.example.twitter.model.Feed
import com.example.twitter.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(context: Context, var items:ArrayList<Feed>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is FeedViewHolder){
            var iv_profile =holder.iv_profile
            var iv_post =holder.iv_post
            var tv_fullname =holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            iv_post.setImageResource(feed.post)
            tv_fullname.text = feed.fullname
        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var iv_post : ShapeableImageView = view.findViewById(R.id.iv_post)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
}