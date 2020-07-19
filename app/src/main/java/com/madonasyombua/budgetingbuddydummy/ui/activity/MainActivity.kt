package com.madonasyombua.budgetingbuddydummy.ui.activity

import android.content.Intent
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.madonasyombua.budgetingbuddydummy.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        object : CountDownTimer((4 * 1000).toLong(), 1000) {
            override fun onTick(timing: Long) {
                //do something display anything here. hence this is where my logo goes.
            }

            //on finish i will display my login activity.
            override fun onFinish() {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }.start()


    }

}
