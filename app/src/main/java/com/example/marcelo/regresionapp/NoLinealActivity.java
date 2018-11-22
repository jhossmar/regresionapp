package com.example.marcelo.regresionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcelo.regresionapp.model.Lineal;
import com.example.marcelo.regresionapp.model.Nolineal;
import com.example.marcelo.regresionapp.model.Regresion;
import com.example.marcelo.regresionapp.model.Resultado;

import java.util.ArrayList;

public class NoLinealActivity extends AppCompatActivity {


    EditText editTextX;
    EditText editTextY;
    ArrayList<Double> listx;
    ArrayList<Double> listy;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItems;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_lineal);

        showToolbar("REGRESION NO LINEAL",true);

        listx = new ArrayList<Double>();
        listy = new ArrayList<Double>();

        editTextX = (EditText) findViewById(R.id.datox);
        editTextY = (EditText)findViewById(R.id.datoy);

        listItems = new ArrayList<String>();
        listView = findViewById(R.id.lista_de_datos_no_lineal);

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

    }

    public void ingresarDatos(View view) {
        if (!vacio(editTextX.getText().toString()) && !vacio(editTextY.getText().toString())){
            listx.add(Double.parseDouble(editTextX.getText().toString()));
            listy.add(Double.parseDouble(editTextY.getText().toString()));
            listItems.add(listItems.size()+") "+" x = "+editTextX.getText().toString()+" y = "+editTextY.getText().toString());
            actualizarLista();
            vaciarImputs();
            mostrarToast("ADD DATOS: OK");

        }else {
            mostrarToast("¡Debe completar todos los campos!");

        }
    }

    private void vaciarImputs() {
        editTextX.getText().clear();
        editTextY.getText().clear();

    }

    private void actualizarLista() {

        adapter.notifyDataSetChanged();

    }

    private boolean vacio(String editTextX) {
        if (editTextX.equals("") || editTextX.equals("null")){
            return  true;
        }else {
            return false;
        }
    }


    public void calcular_no_lineal(View view) {
        int tam = listx.size();
        if (tam > 0) {
            Log.d("TAMAÑOS DE ARRAYS", "" + tam);
            Regresion regresion = new Nolineal(tam);

            for (int i = 0; i < tam; i++) {
                regresion.addx(listx.get(i));
            }
            for (int i = 0; i < tam; i++) {
                regresion.addy(listy.get(i));
            }
            Resultado resultado = regresion.calcularResultado();

            Intent intent = new Intent(NoLinealActivity.this,ResContainer.class);

            intent.putExtra("A",String.valueOf(resultado.getParamA()));
            intent.putExtra("B",String.valueOf(resultado.getParamB()));
            intent.putExtra("ErrorA",String.valueOf(resultado.getErrorA()));
            intent.putExtra("ErrorB",String.valueOf(resultado.getErrorB()));
            intent.putExtra("param_a",String.valueOf(resultado.getParam_a()));
            intent.putExtra("param_b",String.valueOf(resultado.getParam_b()));
            intent.putExtra("error_param_a",String.valueOf(resultado.getError_param_a()));

            startActivity(intent);

        }else {
            mostrarToast("Se debe introducir los datos primero");
        }
    }

    private void mostrarToast(String msg){

        Toast toast2=   Toast.makeText(getBaseContext(),""+msg, Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.RIGHT|Gravity.RIGHT,0,0);
        toast2.show();

    };
    public void showToolbar(String titulo, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
