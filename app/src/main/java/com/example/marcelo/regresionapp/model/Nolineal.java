package com.example.marcelo.regresionapp.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Write a description of class Nolineal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nolineal extends Regresion
{
    private double sumatoriaX;
    private double sumatoriaY;
    private double sumatoriaXY;

    private double multiplicacion[];
    private double cuadradoX[];
    private double cuadradoY[];

    private double sumatoriaX2;
    private double sumatoriaY2;

    private double A;
    private double B;
    private double delta;
    private double sigma2;

    private double parametro_a;
    private double paramtro_b;



    public Nolineal(int tam) {
        super(tam);
        this.sumatoriaX=0;
        this.sumatoriaY=0;
        this.sumatoriaXY=0;

        this.cuadradoX= new double[tam];
        this.cuadradoY= new double[tam];
        this.multiplicacion= new double[tam];

        this.sumatoriaX2 = 0;
        this.sumatoriaY2 = 0;

        this.delta =0;
        this.sigma2=0;
        this.A=0;
        this.B=0;



    }

    @Override
    public Resultado calcularResultado(){
        //Calculos de valores, considerar inficar en un solo metodo luego
        aplicarLogNatural();

        sumatoriaX();
        sumatoriaY();
        calcularMultiplicacion();
        sumatoriaXY();
        cuadradosX();
        sumatoriaX2();
        cuadradosY();
        sumatoriaY2();
        calculosAB();
        calcularSigmaDelta();

        int TEMP = 2; // OJO TEMPORAL
        calcularParametro_a(2); //COMO DETERMINO LA BASE????
        resultado = new Resultado(Tipo.NO_LINEAL);
        resultado.setParamA(A);
        resultado.setParamB(B);
        resultado.setErrorA(calcularErrorA());
        resultado.setErrorB(calcularErrorB());

        return resultado;
    }

    private void calcularParametro_a( int base) {
         if (base != 10){
             parametro_a = Math.pow(10,A);
         }else{
             parametro_a =Math.exp(A);
         }
    }

    private double calcularErrorA() {
        return Math.sqrt(((sigma2)*(sumatoriaX2))/(delta));
    }
    private double calcularErrorB() {
        return Math.sqrt(((sigma2)*(tam))/(delta));
    }


    private double calcularB() {
        return (((tam)*(sumatoriaXY))-((sumatoriaX)*(sumatoriaY)))/(((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2)));
    }

    private double calcularA() {
        return (((sumatoriaY)*(sumatoriaX2))-((sumatoriaXY)*(sumatoriaX)))/(((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2)));
    }

    // Funciones para calcular variables, se los puede unificar luego

    private void sumatoriaX() {
        for (int i=0;i<this.tam;i++)
        {
            sumatoriaX+=this.datosx.get(i);

        }
    }
    private void sumatoriaY() {
        for (int i=0;i<this.tam;i++)
        {
            sumatoriaY+=this.datosy.get(i);

        }
    }

    private void calcularMultiplicacion(){
        for (int i=0;i<this.tam;i++)
        {
            multiplicacion[i]= this.datosx.get(i)*this.datosy.get(i);

        }
    }

    private void sumatoriaXY(){
        for (int i=0;i<this.tam;i++)
        {
            sumatoriaXY+=multiplicacion[i];

        }
    }

    private void cuadradosX(){
        for (int i=0;i<this.tam;i++)
        {
            cuadradoX[i]=this.datosx.get(i)*this.datosx.get(i);
        }
    }

    private void sumatoriaX2(){
        for (int i=0;i<tam;i++)
        {
            sumatoriaX2+=cuadradoX[i];
        }
    }

    private void cuadradosY(){
        for (int i=0;i<this.tam;i++)
        {
            cuadradoY[i]=this.datosy.get(i)*this.datosy.get(i);
        }
    }
    private void sumatoriaY2(){
        for (int i=0;i<tam;i++)
        {
            sumatoriaY2+=cuadradoY[i];

        }
    }

    private void calculosAB(){
        A = (((sumatoriaY)*(sumatoriaX2))-((sumatoriaXY)*(sumatoriaX)))/(((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2)));
        B = (((tam)*(sumatoriaXY))-((sumatoriaX)*(sumatoriaY)))/(((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2)));

    }
    private void calcularSigmaDelta(){
        delta=((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2));
        double sumatoriaDiscrepancia2=(sumatoriaY2)-((2)*(A)*(sumatoriaY))-((2)*(B)*(sumatoriaXY))+((tam)*(Math.pow(A,2)))+((2)*(A)*(B)*(sumatoriaX))+((Math.pow(B,2))*(sumatoriaX2));
        sigma2=(sumatoriaDiscrepancia2)/((tam)-(2));

    }

    public void aplicarLogNatural(){
        ArrayList<Double> tempx = datosx;
        ArrayList<Double> tempy = datosy;
        datosx.clear();
        datosy.clear();

        for (double x :tempx) {
            datosx.add(Math.log(x));
        }
        for (double y :tempy) {
            datosy.add(Math.log(y));
        }
        Log.d("fun cal log nat","Tam datosx"+datosx.size());
        Log.d("fun cal log nat","Tam datosy"+datosy.size());
    }
}
