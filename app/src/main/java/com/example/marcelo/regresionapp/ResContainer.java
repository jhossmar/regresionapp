package com.example.marcelo.regresionapp;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.example.marcelo.regresionapp.model.Resultado;

import org.w3c.dom.Text;

public class ResContainer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_container);
        showToolbar("RESULTADOS",false);

//        Log.d("RESULTADO",intent.getStringExtra("A"));
//
//        resultadosFragment = new ResultadosFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,resultadosFragment)
//                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) // solo  por decoracion
//                .addToBackStack(null).commit();                           // solo por decoracion

        Intent intent =getIntent();
        TextView textView1 = (TextView) findViewById(R.id.valor_A);
        textView1.setText("("+intent.getStringExtra("A")+" +- "+intent.getStringExtra("ErrorA")+")");

        TextView textView2 = (TextView) findViewById(R.id.valor_B);
        textView2.setText("("+intent.getStringExtra("B")+" +- "+intent.getStringExtra("ErrorB")+")");

        TextView textView3 = (TextView) findViewById(R.id.valor_param_a);
        textView3.setText("("+intent.getStringExtra("param_a")+" +- "+intent.getStringExtra("error_param_a")+")");

        TextView textView4 = (TextView) findViewById(R.id.valor_param_b);
        textView4.setText("("+intent.getStringExtra("B")+" +- "+intent.getStringExtra("ErrorB")+")");

        TextView textView5 = (TextView) findViewById(R.id.valor_param_coef_correl);
        textView5.setText(intent.getStringExtra("correlacion"));

}
    public void showToolbar(String titulo, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}

