package com.hyte.fysio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Luokka sisältää UI-elementtejä liikeharjoituksen näyttämiseen. Intent hakee
 * ID-arvon ja DisplayUI:lla käy Muscles-listan läpi, kunnes Muscle-olion arvo
 * vastaa haettua ID:tä. Lopuksi asettaa asianmukaiset arvot UI-elementeille.
 *
 * @author Michael. pvm. 30.11.2019, Risto. pvm 4.12.2019
 */
public class ShowExerciseActivity extends AppCompatActivity {

    private TextView instructionsText;
    private ImageView exerciseImage;
    private TextView exerciseTitle;
    private TextView infoText;

    // Sent message
    private String muscleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_exercise);

        exerciseTitle = findViewById(R.id.exerciseNameText);
        instructionsText = findViewById(R.id.instructionsText);
        exerciseImage = findViewById(R.id.exerciseImage);
        infoText = findViewById(R.id.infoText);
        Intent intent = getIntent();

        muscleName = intent.getStringExtra(HomeBackActivity.MUSCLENAME_MESSAGE); // Receive MESSAGE from previous Activity
        setDisplayUI();
    }

    private void setDisplayUI() {
        // Assign text UI elements
        // Iterates through the same list again...
        // and sets UI elements accordingly
        for (Muscle muscle :  GlobalModel.getInstance().getMuscles()) {
            if (muscle.getMuscleName().toLowerCase().equals(muscleName)) {
                exerciseTitle.setText(muscle.getExerciseName());
                instructionsText.setText(muscle.getInstructions());
                infoText.setText(muscle.getMuscleInfo());
                openImage(muscle.getImageName()); // Opens image from assets folder
            }
        }
    }

    /**
     * Avaa kuvan assets-kansiossa ja asettaa exerciseImagen uudeksi kuvaksi.
     *
     */

    private void openImage(String imageName) {
        try {
            InputStream ims = getAssets().open(imageName);
            Drawable d = Drawable.createFromStream(ims, null);
            exerciseImage.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }

    /**
     * Palaa edelliseen aktiviteettiin
     *
     * @param view klikattu nappi
     */

    // Back button functionality
    public void goBack(View view) {
        onBackPressed();
    }
}