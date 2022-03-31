package com.example.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private var mediPlayer:MediaPlayer?=null
    private var position:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("LifeCycle","OnCreate")
        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener {
            startActivity(Intent(this,DialogActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        mediPlayer=MediaPlayer.create(this,R.raw.ai_2)
        Log.i("LifeCycle","OnSTART")
    }

    override fun onResume(){
        super.onResume()
        mediPlayer?.seekTo(position)
        mediPlayer?.start()
        Log.i("LifeCycle","OnResume")
    }
    override fun onPause(){
        super.onPause()
        Log.i("LifeCycle","OnPause")
        mediPlayer?.pause()
        if(mediPlayer!=null)
        position=mediPlayer!!.currentPosition
    }

    override fun onStop() {
        super.onStop()
        mediPlayer?.stop()
        mediPlayer?.release()
        mediPlayer=null
        Log.i("LifeCycle","OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LifeCycle","OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle","Destroy")
    }
}