package com.example.marcelo.regresionapp;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
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
        textView1.setText("("+intent.getStringExtra("A")+"\u00B1"+intent.getStringExtra(" ErrorA")+")"+"  " + intent.getStringExtra("porcentualA")+"%");

        TextView textView2 = (TextView) findViewById(R.id.valor_B);
        textView2.setText("("+intent.getStringExtra("B")+"\u00B1"+intent.getStringExtra(" ErrorB")+")"+"  " + intent.getStringExtra("porcentualB")+"%");

        TextView textView3 = (TextView) findViewById(R.id.valor_param_a);
        textView3.setText("("+intent.getStringExtra("param_a")+"\u00B1"+intent.getStringExtra(" error_param_a")+")"+"  " + intent.getStringExtra("porcentual_a")+"%");

        TextView textView4 = (TextView) findViewById(R.id.valor_param_b);
        textView4.setText("("+intent.getStringExtra("B")+"\u00B1"+intent.getStringExtra(" ErrorB")+")"+"  " + intent.getStringExtra("porcentual_b")+"%");

        TextView textView5 = (TextView) findViewById(R.id.valor_param_coef_correl);
        textView5.setText(intent.getStringExtra("correlacion"));

        TextView textView6 = (TextView)findViewById(R.id.discrepancia);
        textView6.setText(intent.getStringExtra("discrepancia"));

        TextView textView7 = (TextView)findViewById(R.id.sigma);
        textView7.setText(intent.getStringExtra("sigma"));
        TextView textView8 = (TextView)findViewById(R.id.delta);
        textView8.setText(intent.getStringExtra("delta"));

        String lineal = intent.getStringExtra("de_lineal");

        if (lineal.equals("true")){
            TextView temp1 = findViewById(R.id.etiqueta_param_a);
            temp1.setText(getResources().getString(R.string.res_param_coeficiente_correlacion));
            textView3.setText(intent.getStringExtra("correlacion"));

            TextView temp2 = findViewById(R.id.etiqueta_param_b);
            TextView temp3 = findViewById(R.id.etiqueta_coef_correl);
            TextView temp4 = findViewById(R.id.valor_param_coef_correl);
            TextView temp5 = findViewById(R.id.valor_param_b);
            temp2.setVisibility(View.INVISIBLE);
            temp3.setVisibility(View.INVISIBLE);
            temp4.setVisibility(View.INVISIBLE);
            temp5.setVisibility(View.INVISIBLE);
        }


}
    public void showToolbar(String titulo, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}

