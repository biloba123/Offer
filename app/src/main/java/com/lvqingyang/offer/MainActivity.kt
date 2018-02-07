package com.lvqingyang.offer

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var tv: android.widget.TextView? = null
    private var mThread: Thread?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate: ")
        setContentView(R.layout.activity_main)

        val con=object:ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                if (BuildConfig.DEBUG) Log.d("MainActivity", "onServiceConnected: ")
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                if (BuildConfig.DEBUG) Log.d("MainActivity", "onServiceDisconnected: ")
            }

        }
        btn_start_activity.setOnClickListener { startActivity<MainActivity>() }
        btn_start_service.setOnClickListener { startService(Intent(this, MyService::class.java)) }
        btn_stop_service.setOnClickListener { stopService(Intent(this, MyService::class.java)) }
        btn_bind_service.setOnClickListener { bindService(Intent(this, MyService::class.java), con, Context.BIND_AUTO_CREATE) }
        btn_unbind_service.setOnClickListener { unbindService(con) }
    }

    override fun onRestart() {
        super.onRestart()
        if (BuildConfig.DEBUG) Log.d(TAG, "onRestart: ")
    }

    override fun onStart() {
        super.onStart()
        if (BuildConfig.DEBUG) Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        if (BuildConfig.DEBUG) Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        if (BuildConfig.DEBUG) Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        if (BuildConfig.DEBUG) Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) Log.d(TAG, "onDestroy: ")
    }

    private fun createThread(){
        if (mThread == null) {
            mThread=Thread{
                val url= URL("http://news.baidu.com/")
                while (true){
                    if(mThread!!.isInterrupted){
                        break
                    }
                    if (BuildConfig.DEBUG) Log.d("MainActivity", "createThread: "+url.readText())
                    if(mThread!!.isInterrupted) {
                        Thread.sleep(2000)
                    }
                }
            }
            mThread!!.start()
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
