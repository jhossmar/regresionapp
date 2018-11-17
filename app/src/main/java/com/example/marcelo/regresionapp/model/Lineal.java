package com.example.marcelo.regresionapp.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Write a description of class Lineal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lineal extends Regresion
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



    public Lineal(int tam) {
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

        resultado = new Resultado(Tipo.LINEAL);
        resultado.setParamA(A);
        resultado.setParamB(B);
        resultado.setErrorA(calcularErrorA());
        resultado.setErrorB(calcularErrorB());

        return resultado;
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





}
