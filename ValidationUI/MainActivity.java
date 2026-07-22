package com.example.validationui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword;
    RadioGroup rgGender;
    Spinner spCountry;
    CheckBox chTerms;
    Button btnSubmit;
    String[] country = {"Select Country", "India", "USA", "UK", "Canada"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextText);
        etEmail = findViewById(R.id.editTextText2);
        etPassword = findViewById(R.id.editTextText3);
        rgGender = findViewById(R.id.radioGroup2);
        spCountry = findViewById(R.id.spinner);
        chTerms = findViewById(R.id.checkBox);
        btnSubmit = findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item, country
        );
        spCountry.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (name.isEmpty()) {
                    etName.setError("Enter name");
                    return;
                }
                if (email.isEmpty()) {
                    etEmail.setError("Enter email");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    etEmail.setError("Invalid Email");
                    return;
                }
                if (password.length() < 8) {
                    etPassword.setError("Password must be atleast 8 characters");
                    return;
                }
                if (rgGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "Select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (spCountry.getSelectedItemPosition() == 0) {
                    Toast.makeText(MainActivity.this, "Select Country", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!chTerms.isChecked()) {
                    Toast.makeText(MainActivity.this, "Accept terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Validation Successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}
