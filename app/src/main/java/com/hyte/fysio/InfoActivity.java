package com.hyte.fysio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InfoActivity extends AppCompatActivity {

    private Switch disclaimerSwitch;
    private TextView instructions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        instructions = findViewById(R.id.instructionsText);

        instructions.setText(GlobalModel.getInstance().getInstructions());

        // Antaa nappulalle tapahtumankäsittelijän
        Button feedBackButton = findViewById(R.id.leaveFeedback);
        feedBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("myapp", "TEE JOTAIN");
                Intent myIntent = new Intent(InfoActivity.this, FeedBackActivity.class);
                startActivity(myIntent);
            }
        });

        disclaimerSwitch = findViewById(R.id.switch1);
        SharedPreferences disclaimerActiveState = getSharedPreferences("disclaimerPreference", Activity.MODE_PRIVATE);
        disclaimerSwitch.setChecked(disclaimerActiveState.getBoolean("disclaimerKey", false));

        if (disclaimerSwitch != null) {
            disclaimerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    SharedPreferences prefPut = getSharedPreferences("disclaimerPreference", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor prefEditor = prefPut.edit();
                    if(isChecked) {
                        prefEditor.putBoolean("disclaimerKey", true);
                        prefEditor.commit();
                        //do stuff when Switch is ON
                    } else {
                        prefEditor.putBoolean("disclaimerKey", false);
                        prefEditor.commit();
                        //do stuff when Switch if OFF
                    }
                }
            });
        }
        SharedPreferences prefGet = getSharedPreferences("disclaimerPreference", Activity.MODE_PRIVATE);
        Boolean ifDisclaimerAccepted = prefGet.getBoolean("disclaimerKey", false);

        disclaimerSwitch.setChecked(ifDisclaimerAccepted);
    }

    public void goBack(View v) {
        onBackPressed();
    }
}
