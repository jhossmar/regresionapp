package com.example.marcelo.regresionapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcelo.regresionapp.model.Lineal;
import com.example.marcelo.regresionapp.model.Regresion;
import com.example.marcelo.regresionapp.model.Resultado;
import com.example.marcelo.regresionapp.model.Tipo;

import java.util.ArrayList;

public class LinealActivity extends Activity {

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
        setContentView(R.layout.activity_lineal);

        listx = new ArrayList<Double>();
        listy = new ArrayList<Double>();

        editTextX = (EditText) findViewById(R.id.editText_lineal_x);
        editTextY = (EditText)findViewById(R.id.editText_lineal_y);

        listItems = new ArrayList<String>();
        listView = findViewById(R.id.lista_de_datos);

        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        listView.setAdapter(adapter);

    }

    public void ingresarDato(View view) {
        if (!vacio(editTextX.getText().toString()) && !vacio(editTextY.getText().toString())){
            listx.add(Double.parseDouble(editTextX.getText().toString()));
            listy.add(Double.parseDouble(editTextY.getText().toString()));
            listItems.add(listItems.size()+"x="+editTextX.getText().toString()+"y="+editTextY.getText().toString());

            Log.d("VALOR DATO X"," ="+Double.parseDouble(editTextX.getText().toString()));
            Log.d("VALOR DATO Y"," ="+Double.parseDouble(editTextY.getText().toString()));

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


    private boolean vacio(String editTextX) {
        if (editTextX.equals("") || editTextX.equals("null")){
            Log.d("VACIO", "comprobando si es vacio ="+editTextX);
            return  true;
        }else {
            return false;
        }
    }

    private void actualizarLista() {

        adapter.notifyDataSetChanged();

    }

    public void calcular(View view) {
        int tam = listx.size();
        Log.d("TAMAÑOS DE ARRAYS",""+tam);
        Regresion regresion = new Lineal(tam);

        for (int i= 0 ; i<tam; i++){
            regresion.addx(listx.get(i));
        }
        for (int i= 0 ; i<tam; i++){
            regresion.addy(listy.get(i));
        }
       Resultado resultado = regresion.calcularResultado();

        listItems.clear();
        listItems.add("PARAMETRO  A = "+resultado.getParamA());
        listItems.add("PARAMETRO  B = "+resultado.getParamB());
        listItems.add("Error A = "+resultado.getErrorA());
        listItems.add("Error B = "+resultado.getErrorB());
        actualizarLista();
    }

   private void mostrarToast(String msg){

     Toast toast2=   Toast.makeText(getBaseContext(),""+msg, Toast.LENGTH_SHORT);
     toast2.setGravity(Gravity.RIGHT|Gravity.RIGHT,0,0);
     toast2.show();

   };
}
