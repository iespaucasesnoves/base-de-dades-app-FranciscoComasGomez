package com.example.xisco.gitprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditaVi extends AppCompatActivity {
    private EditText nomvi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_vi);
        nomvi = findViewById(R.id.nomVi);
        nomvi.setText("asd");
    }
}
