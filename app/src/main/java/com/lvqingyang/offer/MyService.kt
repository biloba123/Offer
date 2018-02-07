package com.lvqingyang.offer

import android.app.*
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import org.jetbrains.anko.notificationManager
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

/**
 * 一句话功能描述
 * 功能详细描述
 * @author Lv Qingyang
 * @see 相关类/方法
 * @since
 * @date 2018/2/5
 * @email biloba12345@gamil.com
 * @github https://github.com/biloba123
 * @blog https://biloba123.github.io/
 */
class MyService: Service() {
    private lateinit var mThreadPool: ThreadPoolExecutor
    private var mCount=0

    override fun onBind(intent: Intent?): IBinder? {
        if (BuildConfig.DEBUG) Log.d("MyService", "onBind: ")
        return Binder()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Log.d("MyService", "onCreate: ")
        mThreadPool= Executors.newCachedThreadPool() as ThreadPoolExecutor

        val notify=Notification.Builder(this)
                .setContentTitle("通知")
                .setContentText("qwertyuiop")
//                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
        val intent=Intent(this, Main2Activity::class.java)
        val taskStack=TaskStackBuilder.create(this)
        taskStack.addParentStack(Main2Activity::class.java)
        taskStack.addNextIntent(intent)
        notify.setContentIntent(
                taskStack.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        )

        val notificationManager=notificationManager

        val CHANNEL_ID = "my_channel_01"// The id of the channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(CHANNEL_ID, getString(R.string.app_name), NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(mChannel)
            notify.setChannelId(CHANNEL_ID)
        }

        notificationManager.notify(0, notify.build())
        startForeground(0, notify.build())
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (BuildConfig.DEBUG) Log.d("MyService", "onStartCommand: ")
        mThreadPool.submit {
            val num=++mCount
            while (true){
                if (BuildConfig.DEBUG) Log.d("MyService", "onStartCommand: $num")
                Thread.sleep(1000)
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        if (BuildConfig.DEBUG) Log.d("MyService", "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        if (BuildConfig.DEBUG) Log.d("MyService", "onRebind: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) Log.d("MyService", "onDestroy: ")
        mThreadPool.shutdownNow()
    }


}