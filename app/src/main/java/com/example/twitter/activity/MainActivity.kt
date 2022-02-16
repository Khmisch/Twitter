package com.example.twitter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitter.R
import com.example.twitter.adapter.FeedAdapter
import com.example.twitter.adapter.StoryAdapter
import com.example.twitter.model.Feed
import com.example.twitter.model.Story

class MainActivity : AppCompatActivity() {

    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerStory: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerStory.setLayoutManager(LinearLayoutManager(this,(LinearLayoutManager.HORIZONTAL), false))
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshFeedAdapter(getAllFeeds())
        refreshStoryAdapter(getAllStories())
    }

    private fun refreshStoryAdapter(stories: ArrayList<Story>) {
        val adapter = StoryAdapter(this, stories)
        recyclerStory!!.adapter = adapter
    }

    private fun refreshFeedAdapter(allFeeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, allFeeds)
        recyclerFeed!!.adapter = adapter
    }

    private fun getAllStories(): ArrayList<Story> {

        val chats: ArrayList<Story> = java.util.ArrayList<Story>()
        chats.add(Story(R.drawable.im_sample_007, "Khurshidbek"))
        chats.add(Story(R.drawable.my_profile, "Rachel"))
        chats.add(Story(R.drawable.im_person_00, "Feynman"))
        chats.add(Story(R.drawable.im_sample_007, "Khurshidbek"))
        chats.add(Story(R.drawable.my_profile, "Rachel"))
        chats.add(Story(R.drawable.im_person_00, "Feynman"))
        chats.add(Story(R.drawable.im_sample_007, "Khurshidbek"))
        chats.add(Story(R.drawable.my_profile, "Rachel"))
        chats.add(Story(R.drawable.im_person_00, "Feynman"))

        return chats
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        val chats: ArrayList<Feed> = java.util.ArrayList<Feed>()
        chats.add(Feed(R.drawable.im_sample_007,"Khurshidbek Kurbanov", R.drawable.im_stories_holiday))
        chats.add(Feed(R.drawable.im_person_00,"Khurshidbek Kurbanov", R.drawable.im_meal))
        chats.add(Feed(R.drawable.my_profile,"Khurshidbek Kurbanov", R.drawable.im_fireworks))
        chats.add(Feed(R.drawable.im_sample_007,"Khurshidbek Kurbanov", R.drawable.im_stories_holiday))
        chats.add(Feed(R.drawable.im_person_00,"Khurshidbek Kurbanov", R.drawable.im_meal))
        chats.add(Feed(R.drawable.my_profile,"Khurshidbek Kurbanov", R.drawable.im_fireworks))

        return chats
    }
}