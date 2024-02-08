package com.jainsoham.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button clickButton, planetButton;
    TextView textView, planetText;
    EditText editText;
    String[] messages;
    String[] planets;

    int count = 1;
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
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
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
                planetText.setText(planets[count % 8]);
                count++;
            }
        });
    }
}