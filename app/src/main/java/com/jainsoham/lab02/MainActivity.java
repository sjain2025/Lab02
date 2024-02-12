package com.jainsoham.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button clickButton, planetButton;
    TextView textView, planetText;
    ImageView img;
    EditText editText;
    String[] messages;
    String[] planets;

    int count = 1;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickButton = findViewById(R.id.click_button);
        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        messages = getResources().getStringArray(R.array.messages);
        planets = getResources().getStringArray(R.array.planets);
        planetButton = findViewById(R.id.planet_button);
        planetText = findViewById(R.id.planet_text);
        img = findViewById(R.id.planet_image);
        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                t1.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                textView.setText(text);
                editText.setText("");
                String[] temp = new String[messages.length + 1];
                for (int i = 0; i < messages.length; i++)
                    temp[i] = messages[i];
                temp[messages.length] = text;
                messages = temp;
                Log.i("Messages", Arrays.toString(messages));
            }
        });
        planetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String planet = planets[count % 8];
                t1.speak(planet, TextToSpeech.QUEUE_FLUSH, null);
                planetText.setText(planet);
                if (planet.equals("Mercury")) {
                    img.setImageResource(R.drawable.mercury);
                } else if (planet.equals("Venus")) {
                    img.setImageResource(R.drawable.venus);
                } else if (planet.equals("Earth")) {
                    img.setImageResource(R.drawable.earth);
                } else if (planet.equals("Mars")) {
                    img.setImageResource(R.drawable.mars);
                } else if (planet.equals("Jupiter")) {
                    img.setImageResource(R.drawable.jupiter);
                } else if (planet.equals("Saturn")) {
                    img.setImageResource(R.drawable.saturn);
                } else if (planet.equals("Uranus")) {
                    img.setImageResource(R.drawable.uranus);
                } else {
                    img.setImageResource(R.drawable.neptune);
                }
                count++;
            }
        });
    }
}