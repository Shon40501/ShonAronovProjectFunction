package com.example.shonaronovprojectfunction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private double numa , numb , numc ;
    private EditText NumberA , NumberB , NumberC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        NumberA = findViewById(R.id.NumberA);
        NumberB = findViewById(R.id.NumberB);
        NumberC = findViewById(R.id.NumberC);
    }
    public static int get_number() {
        Random rand = new Random();
        return (int) Math.floor(Math.random() * 100);
    }

    public void Random(View view) {
        numa = get_number();
        numb = get_number();
        numc = get_number();
        NumberA.setText(String.valueOf(numa));
        NumberB.setText(String.valueOf(numb));
        NumberC.setText(String.valueOf(numc));
    }

    public void Solve(View view) {
        Intent si = new Intent(getApplicationContext(), MainActivity2.class);
        numa = Double.parseDouble(NumberA.getText().toString());
        numb = Double.parseDouble(NumberB.getText().toString());
        numc = Double.parseDouble(NumberC.getText().toString());
        si.putExtra("numA", numa);
        si.putExtra("numB", numb);
        si.putExtra("numC", numc);

        startActivity(si);
    }
}