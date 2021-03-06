package com.example.capturevideo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    lateinit var mVideoView: VideoView
    companion object
    {
        val CAPTURE_VIDEO_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun captureVideo(v: View)
    {
        mVideoView = findViewById(R.id.videoview)
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(intent, CAPTURE_VIDEO_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CAPTURE_VIDEO_CODE && resultCode == Activity.RESULT_OK)
        {
            val videoUri = data!!.data
            mVideoView.setVideoURI(videoUri)
            mVideoView.setMediaController(MediaController(this))
            mVideoView.requestFocus()
            mVideoView.start()
        }
    }
}