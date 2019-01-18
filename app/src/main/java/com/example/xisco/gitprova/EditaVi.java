package com.example.xisco.gitprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditaVi extends AppCompatActivity {
    private EditText nomVi, anada, com, data, gra, den, bodega, lloc, nota, preu, tipus, gust, olf, vis;
    private Button act, borr;
    private DataSourceVi bd;
    private Vi vi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_vi);
        bd = new DataSourceVi(EditaVi.this);
        Bundle extras = getIntent().getExtras();
        Long id = Long.parseLong(extras.getString("ID"));
        iniciar();
        agafar(id);
        omplir();
    }
    private void iniciar(){
        nomVi = findViewById(R.id.nomVi);
        tipus = findViewById(R.id.tipus);
        anada = findViewById(R.id.Anada);
    }
    private void agafar(long id){
        bd.open();
        vi = bd.getVi(id);
        bd.close();
    }
    private void omplir(){
        bd.open();
        nomVi.setText(vi.getNomVi());
        tipus.setText(vi.getTipus());
        anada.setText(vi.getAnada());
        bd.close();
    }
}
