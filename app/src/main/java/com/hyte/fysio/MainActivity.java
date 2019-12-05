package com.hyte.fysio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/** Luokka sisältää alussa näytettävän SplashScreenin, joka käynnistää ensimmäisellä
 *  kerralla aktiviteetin DISCLAIMERIIN eli vastuuvapauslausekenäkymään.
 *  Kun käyttäjä hyväksyy disclaimerin, sitä ei enään näytetä. Toisella käynnistyskerralla
 *  avaa aloitusnäkymän.
 *  @author Michael
 *  pvm. 30.11.2019
 */

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;          // Simple timer before jumping into next screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefGet = getSharedPreferences("disclaimerPreference", Activity.MODE_PRIVATE);
        Boolean ifDisclaimerAccepted = prefGet.getBoolean("disclaimerKey", false);

        if (ifDisclaimerAccepted) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent = new Intent(MainActivity.this, HomeFrontActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, DisclaimerActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }
}
