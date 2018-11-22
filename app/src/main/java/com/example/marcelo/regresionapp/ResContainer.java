package com.example.marcelo.regresionapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.marcelo.regresionapp.model.Resultado;

public class ResContainer extends AppCompatActivity {

    ResultadosFragment resultadosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_container);

        resultadosFragment = new ResultadosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,resultadosFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) // solo  por decoracion
                .addToBackStack(null).commit();                           // solo por decoracion

    }
}
