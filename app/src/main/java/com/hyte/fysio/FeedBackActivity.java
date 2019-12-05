package com.hyte.fysio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

/**
 * Luokka sisältää otsikon ja viestin validointiin tarkoitettuja apurutiineja.
 * Luokassa on myös s-postin lähettämiseen merkitty rutiini.
 */
public class FeedBackActivity extends AppCompatActivity {

    private TextInputLayout textTitle;
    private TextInputLayout textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        textTitle = findViewById(R.id.text_input_title);
        textMessage = findViewById(R.id.text_input_message);
    }

    private boolean validateTitle() {
        String titleInput = textTitle.getEditText().getText().toString().trim();
        if (titleInput.isEmpty()) {
            textTitle.setError("Otsikko ei saa olla tyhjä.");
            return false;
        } else if (titleInput.length() > 20) {
            textTitle.setError("Otsikko on liian pitkä.");
            return false;
        } else {
            textTitle.setError(null);
            return true;
        }
    }

    private boolean validateMessage() {
        String messageInput = textMessage.getEditText().getText().toString().trim();

        if (messageInput.isEmpty()) {
            textMessage.setError("Kenttä ei saa olla tyhjä.");
            return false;
        } else if (messageInput.length() < 15) {
            textMessage.setError("Viesti on liian lyhyt.");
            return false;
        } else {
            textMessage.setError(null);
            return true;
        }
    }

    /**
     * Validoi ja lähetä lomake
     *
     * @param view klikattu Lähetä-nappula
     */
    public void confirmInput(View view) {
        if (!validateMessage() | !validateTitle()) {
            return;
        }
        sendMail();
    }

    private void sendMail() {
        String recipientList = "michalo@metropolia.fi";
        String[] recipients = recipientList.split(",");

        String subject = textTitle.getEditText().getText().toString();
        String message = textMessage.getEditText().getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}