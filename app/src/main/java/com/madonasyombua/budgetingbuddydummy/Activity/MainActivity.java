package com.madonasyombua.budgetingbuddydummy.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.madonasyombua.budgetingbuddydummy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CountDownTimer timer = new CountDownTimer(4*1000,1000) {
            @Override
            public void onTick(long timing) {
            //do something display anything here. hence this is where my logo goes.
            }
            //on finish i will display my login activity.
            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }.start();



    }

}
