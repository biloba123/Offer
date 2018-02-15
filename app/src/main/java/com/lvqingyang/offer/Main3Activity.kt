package com.lvqingyang.offer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val myFragment=MyFragment.newInstance()

        button_add.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, myFragment)
                    .addToBackStack(null)
                    .commit()
        }
        button_remove.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .remove(myFragment)
                    .addToBackStack(null)
                    .commit()
        }
        button_show.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .show(myFragment)
                    .commit()
        }
        button_hide.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .hide(myFragment)
                    .commit()
        }
        button_attach.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .attach(myFragment)
                    .commit()
        }
        button_detach.setOnClickListener {
            supportFragmentManager.beginTransaction()
                    .detach(myFragment)
                    .commit()
        }
    }
}
