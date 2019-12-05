package com.hyte.fysio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

/**
 * The type Disclaimer activity.
 */
public class DisclaimerActivity extends AppCompatActivity {

    private CheckBox dontShowAgainBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        dontShowAgainBox = findViewById(R.id.checkBox);
    }

    /**
     * Hyväksyy vastuuvapauslausekkeen asettamalla myös disclaimerPreference-avaimelle arvon "true"
     * ja siirtyy aloitusnäkymään. Sovelluksen uudelleenkäynnistyksessä ei avaa DisclaimerAktiviteettia.
     *
     * @param v klikattu ui-elementti eli tässä tapauksessa Switch
     * @v View-elementti, joka antaa switchin ui-elementille tapahtuman,
     */

    public void clickUIElement(View v) {

        switch (v.getId()) {
            case R.id.jatkaButton:
                Log.i("myapp", "backButton");
                if (dontShowAgainBox.isChecked()) {
                    SharedPreferences prefPut = getSharedPreferences("disclaimerPreference", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = prefPut.edit();
                    prefEditor.putBoolean("disclaimerKey", true);
                    prefEditor.commit();
                }
                 startHomeActivity();
            break;
        }
    }

    private void startHomeActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(DisclaimerActivity.this, HomeFrontActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, 500);
    }
}
