package com.lvqingyang.offer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main5.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        btn_load.setOnClickListener {
            val bitmap=decodeBitmapFromResource(R.drawable.dog, 200, 100)
            iv.setImageBitmap(bitmap)
        }
    }
}
