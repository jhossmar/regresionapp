package com.example.marcelo.regresionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class NoLinealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_lineal);
    }

    public void ingresarDatos(View view) {

        mostrarToast("Se preciono el boton ingresar");
    }

    public void calcular_no_lineal(View view) {
        mostrarToast("Se preciono el boron calcular");
    }

    private void mostrarToast(String msg){

        Toast toast2=   Toast.makeText(getBaseContext(),""+msg, Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.RIGHT|Gravity.RIGHT,0,0);
        toast2.show();

    };

}
