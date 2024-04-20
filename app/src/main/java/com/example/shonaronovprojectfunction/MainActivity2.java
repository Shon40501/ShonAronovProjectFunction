package com.example.shonaronovprojectfunction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView answer;
    private double numa , numb , numc ,rt1 , rt2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        answer = findViewById(R.id.Answer);
        Intent intent = getIntent();
        if(intent != null){
            numa = intent.getDoubleExtra("numA", 0);
            numb = intent.getDoubleExtra("numB", 0);
            numc = intent.getDoubleExtra("numC", 0);
            double discriminant = numb * numb - 4 * numa * numc;
            String formula = String.format("x = (-%.2f ± √(%.2f² - 4*%.2f*%.2f)) / (2*%.2f)", numb, numb, numa, numc, numa);
            answer.setText("Quadratic Formula:\n" + formula + "\n\n");
            if (discriminant > 0) {
                rt1 = (-numb + Math.sqrt(discriminant)) / (2 * numa);
                rt2 = (-numb - Math.sqrt(discriminant)) / (2 * numa);
                answer.append("Roots:\n" + "x1 = " + rt1 + "\nx2 = " + rt2);
            } else if (discriminant == 0) {
                double root = -numb / (2 * numa);
                answer.append("Root:\n" + "x = " + root);
            } else {
                double realPart = -numb / (2 * numa);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * numa);
                answer.append("Roots:\n"
                        + "x1 = " + realPart + " + " + imaginaryPart + "i\n"
                        + "x2 = " + realPart + " - " + imaginaryPart + "i");
            }

        }
    }

    public void Goback(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("root1", rt1); // Assuming root1 and root2 are accessible here
        intent.putExtra("root2", rt2);
        intent.putExtra("numA", numa);
        intent.putExtra("numB", numb);
        intent.putExtra("numC", numc);
        startActivity(intent);
    }
}