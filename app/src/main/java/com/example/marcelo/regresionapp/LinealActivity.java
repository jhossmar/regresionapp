package com.example.marcelo.regresionapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LinealActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineal);

        TextView textw_atras = findViewById(R.id.btn_atras);

        final Button btn_atras = findViewById(R.id.btn_atras);
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    btn_atras.setText("SE HIZO CLICK EN ATRAS");
                Intent intent = new Intent(LinealActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
