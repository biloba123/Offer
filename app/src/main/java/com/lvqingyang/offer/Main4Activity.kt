package com.lvqingyang.offer

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main4.*
import java.util.*

class Main4Activity : AppCompatActivity() {
    private val UPDATE_STOCK=0
    private var mIsUpdate=false
    private val mHandThread: HandlerThread = HandlerThread("stock")
    private var mThreadHandler: Handler?=null
    private val mMainHandler =  object: Handler(){
        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                UPDATE_STOCK -> {
                    tv.text="当前股价：${msg.arg1}"
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        initHandlerThread()

        btn_start.setOnClickListener {
            mIsUpdate=true
            mThreadHandler?.sendEmptyMessage(0)
        }

        btn_stop.setOnClickListener {
            mThreadHandler?.removeMessages(0)
            mIsUpdate=false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandThread.quit()
        mMainHandler.removeMessages(UPDATE_STOCK)
    }

    private fun initHandlerThread() {
        mHandThread.start()
        mThreadHandler=object: Handler(mHandThread.looper){
            override fun handleMessage(msg: Message?) {
                getStock()
                if(mIsUpdate){
                    sendEmptyMessage(0)
                }
            }
        }
    }

    private fun getStock() {
        Thread.sleep(1000)
        val stock=Random().nextInt(1000)+1000
        val msg=Message.obtain()
        msg.what=UPDATE_STOCK
        msg.arg1=stock
        mMainHandler.sendMessage(msg)
    }
}
