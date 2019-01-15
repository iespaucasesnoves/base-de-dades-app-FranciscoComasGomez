package com.example.xisco.gitprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AfegirVi extends AppCompatActivity implements View.OnClickListener{
    private Button afg;
    private DataSourceVi data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_vi);
        data = new DataSourceVi(AfegirVi.this);
        afg = findViewById(R.id.inserir);
        afg.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        if(v == afg){
            Toast.makeText(this, "boton", Toast.LENGTH_SHORT).show();
            Vi vi = new Vi();
            vi.setId(3);
            vi.setFoto("asd");
            vi.setNomVi(findViewById(R.id.afgNomVi).toString());
            vi.setAnada(findViewById(R.id.afgAnada).toString());
            vi.setComentari(findViewById(R.id.afgCom).toString());
            vi.setData(findViewById(R.id.afgData).toString());
            vi.setGraduacio(findViewById(R.id.afgGra).toString());
            vi.setIdDenominacio(2);
            vi.setLloc(findViewById(R.id.afgLloc).toString());
            vi.setNota(Integer.valueOf(R.id.afgNota));
            vi.setPreu(Integer.valueOf(R.id.afgPreu));
            vi.setTipus(findViewById(R.id.afgTipus).toString());
            vi.setValGustativa(findViewById(R.id.afgValGust).toString());
            vi.setValOlfativa(findViewById(R.id.afgValOlf).toString());
            vi.setValVisual(findViewById(R.id.afgValVisual).toString());
            data.createVi(vi);
        }
    }
}
