package com.madonasyombua.budgetingbuddydummy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.madonasyombua.budgetingbuddydummy.R;

public class LoginActivity extends AppCompatActivity {
 TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       signup =findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onBackPressed(){

        // Disable going back to the MainActivity
        moveTaskToBack(true);

    }
}


