package com.example.marcelo.regresionapp.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Write a description of class Regresion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Regresion
{
     protected Resultado resultado;
     protected ArrayList<Double> datosx;
     protected ArrayList<Double> datosy;
     protected int tam;

     public Regresion(int tam){
          this.datosx= new ArrayList<Double>();
          this.datosy= new ArrayList<Double>();
          this.tam = tam;

     }

     public  void addx(Double x){
          datosx.add(x);
     }

     public  void addy(Double y){
          datosx.add(y);
     }

     public Resultado calcularResultado(){
          Log.i("msgSuperClase:Regresion", "calcularResultado: se retorno desde superclase");
          return null;
          
     }

}
