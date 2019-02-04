package com.example.xisco.gitprova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EditaVi extends AppCompatActivity implements View.OnClickListener {
    private EditText nomVi, anada, com, data, gra, den, bodega, lloc, nota, preu, gust, olf, vis;
    private Button act, borr;
    private DataSourceVi bd;
    private Vi vi, viE;
    private Long id;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_vi);
        bd = new DataSourceVi(EditaVi.this);
        Bundle extras = getIntent().getExtras();
        id = Long.parseLong(extras.getString("ID"));
        act = findViewById(R.id.update);
        borr = findViewById(R.id.delete);
        act.setOnClickListener(this);
        borr.setOnClickListener(this);
        iniciar();
        agafar(id);
        omplir();
        montaSpinners(vi.getTipus());
    }
    private void iniciar(){
        spinner = findViewById(R.id.spTipus);
        nomVi = findViewById(R.id.nomVi);
        anada = findViewById(R.id.anada);
        com = findViewById(R.id.comentari);
        data = findViewById(R.id.data);
        gra = findViewById(R.id.graduacio);
        den = findViewById(R.id.denominacio);
        bodega = findViewById(R.id.bodega);
        lloc = findViewById(R.id.lloc);
        nota = findViewById(R.id.nota);
        gust = findViewById(R.id.valoracioGust);
        olf = findViewById(R.id.valoracioOlfativo);
        vis = findViewById(R.id.valoracioVIsual);
        preu = findViewById(R.id.preu);
    }
    private void agafar(long id){
        bd.open();
        vi = bd.getVi(id);
        bd.close();
    }
    private void omplir(){
        bd.open();
        nomVi.setText(vi.getNomVi());
        anada.setText(vi.getAnada());
        com.setText(vi.getComentari());
        data.setText(vi.getData());
        gra.setText(vi.getGraduacio());
        den.setText(String.valueOf(vi.getIdDenominacio()));
        bodega.setText(String.valueOf(vi.getIdBodega()));
        lloc.setText(vi.getLloc());
        nota.setText(String.valueOf(vi.getNota()));
        gust.setText(vi.getValGustativa());
        olf.setText(vi.getValOlfativa());
        vis.setText(vi.getValVisual());
        preu.setText(String.valueOf(vi.getPreu()));
        bd.close();
    }
    @Override
    public void onClick(View v) {
        bd.open();
        if(v == borr) {
            bd.deleteVi(vi);
            Toast.makeText(this, "Vi borrat succesivament", Toast.LENGTH_SHORT).show();
        }
        else if(v == act) update();
        bd.close();
    }
    private void update(){
        viE = new Vi();
        viE.setId(vi.getId());
        viE.setFoto("asd");
        viE.setNomVi(nomVi.getText().toString());
        viE.setAnada(anada.getText().toString());
        viE.setComentari(com.getText().toString());
        viE.setData(data.getText().toString());
        viE.setGraduacio(gra.getText().toString());
        viE.setIdDenominacio(Long.parseLong(den.getText().toString()));
        viE.setIdBodega(Long.parseLong(bodega.getText().toString()));
        viE.setLloc(lloc.getText().toString());
        viE.setNota(Integer.parseInt(nota.getText().toString()));
        viE.setPreu(Double.parseDouble(preu.getText().toString()));
        viE.setTipus(spinner.getSelectedItem().toString());
        viE.setTipus(spinner.getSelectedItem().toString());
        viE.setValGustativa(gust.getText().toString());
        viE.setValOlfativa(olf.getText().toString());
        viE.setValVisual(vis.getText().toString());
        bd.open();
        bd.updateVi(viE);
        bd.close();
        Toast.makeText(this, "Vi actualitzat succesivament", Toast.LENGTH_SHORT).show();
    }
    private void montaSpinners(String t) {
        List<String> llista;
        bd.open();
        llista=bd.getAllTipus();
        bd.close();
        // Crear adapter
        ArrayAdapter<String> dataAdapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, llista);
        // Drop down estil – llista amb radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // assignar adapter
        spinner.setAdapter(dataAdapter);
        if (t!=null && !t.equals("")) {
            selectValue(spinner,t); // Si hi ha un valor assignat posicionar-se
        }
    }
    private void selectValue(Spinner spinner, Object value) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(value)) {
                spinner.setSelection(i);
                break;
            }
        }
    }
}
