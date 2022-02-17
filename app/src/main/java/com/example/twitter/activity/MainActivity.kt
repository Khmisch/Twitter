package com.example.twitter.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
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
    lateinit var iv_twitter: ImageView
    var videoUrl = "https://ak.picdn.net/shutterstock/videos/1055020922/preview/stock-footage-man-puts-fingers-down-in-lake-kayaking-against-backdrop-of-golden-sunset-unity-harmony-nature.webm"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        iv_twitter = findViewById(R.id.iv_twitter)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerStory = findViewById(R.id.recyclerStory)
        recyclerStory.setLayoutManager(LinearLayoutManager(this,(LinearLayoutManager.HORIZONTAL), false))
        recyclerFeed.setLayoutManager(GridLayoutManager(this, 1))

        refreshFeedAdapter(getAllFeeds())
        refreshStoryAdapter(getAllStories())

        // finding videoview by its id
        val videoView = findViewById<VideoView>(R.id.videoView)
        val uri: Uri = Uri.parse(videoUrl)
        videoView.setVideoURI(uri)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.clipToOutline = true
        videoView.start()

        iv_twitter.setOnClickListener( View.OnClickListener{
            callDarkModeActivity()
        })

    }

    private fun callDarkModeActivity() {
        var intent = Intent(this, DarkModeActivity::class.java)
        startActivity(intent)
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
        var url1 = "https://images.unsplash.com/photo-1468779065891-103dac4a7c48?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80"
        var url2 = "https://images.unsplash.com/photo-1526481280693-3bfa7568e0f3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"
        var url3 = "https://images.unsplash.com/photo-1644937666511-c74752ca7314?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        var url4 = "https://images.unsplash.com/photo-1491884662610-dfcd28f30cfb?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
        var url5 = "https://images.unsplash.com/photo-1524413840807-0c3cb6fa808d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"

        chats.add(Feed(R.drawable.im_sample_007,"Khurshidbek Kurbanov", url1))
        chats.add(Feed(R.drawable.my_profile,"Li Mei", url3, url4, true))
        chats.add(Feed(R.drawable.im_person_00,"Richard Feynman", url5))
        chats.add(Feed(R.drawable.im_sample_007,"Khurshidbek Kurbanov", "https://images.unsplash.com/photo-1644910595529-1075df35cff5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"))
        chats.add(Feed(R.drawable.my_profile,"Li Mei", url2))
        chats.add(Feed(R.drawable.im_person_00,"Richard Feynman", url4))
        chats.add(Feed(R.drawable.im_sample_007,"Khurshidbek Kurbanov", url1))
        chats.add(Feed(R.drawable.my_profile,"Li Mei", url5))
        chats.add(Feed(R.drawable.im_person_00,"Richard Feynman", url3))


        return chats
    }
}