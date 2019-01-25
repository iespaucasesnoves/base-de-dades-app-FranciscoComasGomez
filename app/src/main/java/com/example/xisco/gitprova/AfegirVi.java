package com.example.xisco.gitprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AfegirVi extends AppCompatActivity implements View.OnClickListener{
    private EditText nomVi, anada, com, data, gra, den, bodega, lloc, nota, preu, tipus, gust, olf, vis;
    private Button afg;
    private DataSourceVi bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_vi);
        bd = new DataSourceVi(AfegirVi.this);
        afg = findViewById(R.id.inserir);
        afg.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        nomVi = findViewById(R.id.nomVi);
        anada = findViewById(R.id.anada);
        com = findViewById(R.id.comentari);
        data = findViewById(R.id.data);
        gra = findViewById(R.id.graduacio);
        den = findViewById(R.id.denominacio);
        bodega = findViewById(R.id.bodega);
        lloc = findViewById(R.id.lloc);
        nota = findViewById(R.id.afgNota);
        preu = findViewById(R.id.preu);
        tipus = findViewById(R.id.tipus);
        gust = findViewById(R.id.valoracioGust);
        olf = findViewById(R.id.valoracioOlfativo);
        vis = findViewById(R.id.valoracioVIsual);
        String deno = den.getText().toString();
        if(v == afg){

            Vi vi = new Vi();
            vi.setFoto("asd");
            vi.setNomVi(nomVi.getText().toString());
            vi.setAnada(anada.getText().toString());
            vi.setComentari(com.getText().toString());
            vi.setData(data.getText().toString());
            vi.setGraduacio(gra.getText().toString());
            vi.setIdDenominacio(Long.parseLong(deno));
            vi.setIdBodega(Long.parseLong(bodega.getText().toString()));
            vi.setLloc(lloc.getText().toString());
            vi.setNota(Integer.valueOf(nota.getText().toString()));
            vi.setPreu(Double.valueOf(preu.getText().toString()));
            vi.setTipus(tipus.getText().toString());
            vi.setValGustativa(gust.getText().toString());
            vi.setValOlfativa(olf.getText().toString());
            vi.setValVisual(vis.getText().toString());
            bd.open();
            bd.createVi(vi);
            bd.close();
            Toast.makeText(this, "Vi: " + nomVi.getText().toString() + " inserit correctament", Toast.LENGTH_SHORT).show();
        }
    }
}
