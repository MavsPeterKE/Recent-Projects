package com.example.zindukamtaani;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
      //sets Action Bar color
        getActionBar().hide();
        //getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.background2));

        //Threat that displays the splash screen within specified period
        Thread splashstarter = new Thread() {
            //Threat method that first executes
            public void run() {
                try {
                    sleep(3000);
                }
                //Handles exception incase of error
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Blocks that is executed when the code runs successfully
                finally {
                    Intent a = new Intent(Splash.this, Userfunctions.class);
                    startActivity(a);
                }
            }
        };
        splashstarter.start();
    }
        protected void onPause() {
        super.onPause();
        finish();
    }
    }

