package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight , heightFT , heightIN;
        Button button;
        TextView result;
        LinearLayout mainLayout;

        weight = findViewById(R.id.weight);
        heightFT = findViewById(R.id.heightFT);
        heightIN = findViewById(R.id.heightIN);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        mainLayout = findViewById(R.id.mainLayout);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
          int wt = Integer.parseInt( weight.getText().toString());
          int hgFt = Integer.parseInt(heightFT.getText().toString());
          int hgIn = Integer.parseInt(heightIN.getText().toString());

          int totalIn = hgFt * 12 + hgIn;
          double totalCm = totalIn*2.53;
          double totalM = totalCm/100;
          double bmi = wt/Math.pow(totalM,2);

          if(bmi > 25){
              result.setText("You are overweight");
              mainLayout.setBackgroundColor(getResources().getColor(R.color.danger));
          }
          else if (bmi < 18){
              mainLayout.setBackgroundColor(getResources().getColor(R.color.danger));
              result.setText("You are underweight");
          }
          else {
              mainLayout.setBackgroundColor(getResources().getColor(R.color.positive));
              result.setText("You are healthy");
          }
            }
        });

    }
}