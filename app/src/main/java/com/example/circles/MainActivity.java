package com.example.circles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    CircleView circleView;
    EditText inputNum;
    Button submitButton;
    int circles = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ievads
        inputNum = findViewById(R.id.inputNum);
        submitButton = findViewById(R.id.submitButton);

        // Kad tiek nospiesta poga, tiek ģenerēts circleView
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iegūst ievadīto riņķu daudzumu
                circles = Integer.parseInt(inputNum.getText().toString());

                circleView = new CircleView(MainActivity.this, circles);
                linearLayout = findViewById(R.id.linearLayout);
                // Lai nepārklātos skati, pirms tiek izveidots jauns, tiek nodzēsti visi vecie
                linearLayout.removeAllViews();
                linearLayout.addView(circleView);
            }
        });
    }
}
