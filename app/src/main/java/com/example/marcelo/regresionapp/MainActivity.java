package com.example.marcelo.regresionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_lineal = (Button)findViewById(R.id.btn_lineal);
        btn_lineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itent= new Intent(MainActivity.this, LinealActivity.class);
                startActivity(itent);
            }
        });
        Button btn_no_lineal = (Button)findViewById(R.id.btn_no_lineal);
        btn_no_lineal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itent= new Intent(MainActivity.this, NoLinealActivity.class);
                startActivity(itent);
            }
        });


    }

}
