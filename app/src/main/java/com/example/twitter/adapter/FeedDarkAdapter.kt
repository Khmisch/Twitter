package com.example.twitter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.twitter.R
import com.example.twitter.model.Feed
import com.example.twitter.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedDarkAdapter(var context: Context, var items:ArrayList<Feed>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ADDED_YES = 0
    private val TYPE_ADDED_NO = 1


    override fun getItemViewType(position: Int): Int {

        val chat: Feed = items[position]
        return if (!chat.isDoubleImage) {
            TYPE_ADDED_NO
        }
        else TYPE_ADDED_YES
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ADDED_YES){
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_2_dark, parent, false)
        return FeedDoubleViewHolder(view) }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post_dark, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is FeedViewHolder){
            var iv_profile =holder.iv_profile
            var iv_post =holder.iv_post
            var tv_fullname =holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            tv_fullname.text = feed.fullname

            Glide.with(context).load(feed.post)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(iv_post);
        }
        if (holder is FeedDoubleViewHolder){
            var iv_profile =holder.iv_profile
            var iv_post =holder.iv_post
            var iv_post_2 =holder.iv_post_2
            var tv_fullname =holder.tv_fullname

            iv_profile.setImageResource(feed.profile)
            tv_fullname.text = feed.fullname

            Glide.with(context).load(feed.post)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.im_stories_holiday)
                .into(iv_post);
            Glide.with(context).load(feed.post_2)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.im_stories_holiday)
                .into(iv_post_2);

        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var iv_post : ShapeableImageView = view.findViewById(R.id.iv_post)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
    class FeedDoubleViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var iv_post : ShapeableImageView = view.findViewById(R.id.iv_post)
        var iv_post_2 : ShapeableImageView = view.findViewById(R.id.iv_post_2)
        var tv_fullname : TextView = view.findViewById(R.id.tv_fullname)

    }
}