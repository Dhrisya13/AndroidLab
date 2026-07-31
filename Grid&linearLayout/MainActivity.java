package com.example.gridlinearlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView t1, t2;
    Button sum, sub, mul,div;
    EditText e1 ,e2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        t1=(TextView) findViewById(R.id.textView3);
        t2=(TextView) findViewById(R.id.textView7);

        sum=findViewById(R.id.button7);
        sub=findViewById(R.id.button8);
        mul=findViewById(R.id.button9);
        div=findViewById(R.id.button10);

        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double f1=Double.parseDouble(e1.getText().toString());
                double f2=Double.parseDouble(e2.getText().toString());
                t2.setText("Addition = "+ (f1+f2));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double f1=Double.parseDouble(e1.getText().toString());
                double f2=Double.parseDouble(e2.getText().toString());
                t2.setText("Subtraction = "+ (f1-f2));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double f1 = Double.parseDouble(e1.getText().toString());
                double f2 = Double.parseDouble(e2.getText().toString());
                t2.setText("Multiplication = " + (f1 * f2));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double f1 = Double.parseDouble(e1.getText().toString());
                double f2 = Double.parseDouble(e2.getText().toString());
                t2.setText("Division = " + (f1 / f2));
            }
        });
    }
}
