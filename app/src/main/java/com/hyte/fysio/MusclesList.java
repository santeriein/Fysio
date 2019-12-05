package com.hyte.fysio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Luokka sisältää lihasten listaamiseen ja filtteröimiseen tarvittavia metodeja.
 *
 * @author Michael
 * pvm. 29.11.2019
 */
public class MusclesList extends AppCompatActivity {

    /**
     * The constant EXTRA_MESSAGE.
     */
    public static final String MUSCLENAME_MESSAGE = "com.hyte.fysio.MUSCLENAME_MESSAGE";
    /**
     * The Adapter.
     */
    public ArrayAdapter<?> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscles_list);

        ListView lv = findViewById(R.id.musclesList);

        EditText inputSearch = findViewById(R.id.filterList);
         adapter = new ArrayAdapter<>(
                this,
                R.layout.muscles_item_layout,
                GlobalModel.getInstance().getMuscles());

        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text

                MusclesList.this.adapter.getFilter().filter(cs);

                Log.i("VALUES", "Text changing...");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {}
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(MusclesList.this, ShowExerciseActivity.class);
                Muscle muscle = (Muscle)adapterView.getItemAtPosition(i);
                String muscleN = muscle.getMuscleName();
                nextActivity.putExtra(MUSCLENAME_MESSAGE, muscleN);
                startActivity(nextActivity);
            }
        });

    }

    /**
     * Go back.
     *
     * @param v the v
     */
    public void goBack(View v) {
        onBackPressed();
    }
}
