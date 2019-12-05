package com.hyte.fysio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Luokka sisältää ylävartalon etupuolen, lista- ja info-näppäimen, jotka
 * ohjaavat asianmukaisiin aktiviteetteihin
 * @author Michael
 * pvm. 29.11.2019
 */

public class HomeBackActivity extends AppCompatActivity {
    /**
     * Staattinen oliomuuttuja MUSCLENAME_MESSAGE lihaksen näppäimen ID:n välittämiselle.
     */
// Messages
    public static final String MUSCLENAME_MESSAGE = "com.hyte.fysio.MUSCLENAME_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_back);
    }

    /**
     * Käynnistää lihasten listaukseen tarkoitetun aktiviteetin
     *
     * @param view klikattu ui-elementti, joka on Button
     */

    public void startMusclesList(View view) {
        Intent intent = new Intent(HomeBackActivity.this, MusclesList.class);
        startActivity(intent);
    }

    /**
     * Käynnistää käyttäjätietojen aktiviteetin
     *
     * @param view klikattu ui-elementti, joka on Button
     */

    public void startInfoActivity(View view) {
        Intent intent = new Intent(HomeBackActivity.this, InfoActivity.class);
        startActivity(intent);
    }

    /**
     * Näkymän puolenkääntö
     *
     * @param view klikattu ui-elementti, joka on Button
     */

    public void switchSide(View view) {
        Intent intent = new Intent(HomeBackActivity.this, HomeFrontActivity.class);
        startActivity(intent);
    }

    /**
     * Aloittaa klikatun lihaksen liikeharjoitusaktiviteetin
     * hakemalla näppäimen ID ja välittämällä muuttuja intentissä
     * seuraavaan aktiviteettiin.
     *
     * @param view klikattu ui-elementti, joka on Button
     */

    public void clickMuscle(View view) {
        String buttonID = view.getResources().getResourceName(view.getId()).replace("com.hyte.fysio:id/", "");
        Log.i("myapp", "BUTTON ID: " + buttonID);
        for (Muscle muscle : GlobalModel.getInstance().getMuscles()) {
            if (muscle.getMuscleName().equals(buttonID)) {
                Intent intent = new Intent(this, ShowExerciseActivity.class);
                intent.putExtra(MUSCLENAME_MESSAGE, buttonID);
                startActivity(intent);
            }
        }
    }
}



