package com.example.marcelo.regresionapp.model;

import java.util.*;
public class RELACIONNOLINEAL
{
       public static void main (String args[])
       {
           Scanner entrada= new Scanner(System.in);
           
           System.out.println("Digite el numero de datos que va a ingresar");
           int tam=entrada.nextInt();
          
           //SUPERCLASE Regresion{ 
               //double datosX[];
               //double datosY[];
               //int tam;
           //public Regresion(int tam ) {
               double datosX[]= new double [tam];
               double datosY[]= new double [tam];
            //}
           //}
           //clase LINEAL{} NOLINEAL{}
           
           
           //UTILIZAR VENTANAS PARA LLENAR LOS ARRAYS datosX, y datosy
           System.out.println("Digite sus datos en X");
           for (int i=0;i<tam;i++)
           {
               datosX[i]=entrada.nextDouble();
               
            }
            System.out.println("Digite sus datos en Y");
              for (int i=0;i<tam;i++)
           {
               datosY[i]=entrada.nextDouble();
               
            }
           
            //subproceso sumatoria X
            double sumatoriaX=0;
            for (int i=0;i<tam;i++)
            {
                sumatoriaX+=datosX[i];
                
            }
          System.out.println("la sumatoria en X es:"+sumatoriaX);
            //subproceso sumatoria Y
             double sumatoriaY=0;
            for (int i=0;i<tam;i++)
            {
                sumatoriaY+=datosY[i];
                
            }
            System.out.println("la sumatoria en Y es:"+sumatoriaY);
            //como le hago un subproceso de multiplicacion

           double multiplicacion[]= new double [tam] ;
            for (int i=0;i<tam;i++)
            {
                multiplicacion[i]= datosX[i]*datosY[i];
                
            }
            
             //subproceso sumatoria XY
             double sumatoriaXY=0;
            for (int i=0;i<tam;i++)
            {
                sumatoriaXY+=multiplicacion[i];
                
            }
            System.out.println("la sumatoria en XY es:"+sumatoriaXY);
             //subproceso cuadradoX
            double cuadradoX[]= new double [tam];
            for (int i=0;i<tam;i++)
            {
                cuadradoX[i]=datosX[i]*datosX[i];
            }
            //subproceso sumatoria cuadradoX
             double sumatoriaX2=0;
            for (int i=0;i<tam;i++)
            {
                sumatoriaX2+=cuadradoX[i];
                
            }
            System.out.println("la sumatoria en X2 es:"+sumatoriaX2);
             //subproceso cuadradoY
             double cuadradoY[]= new double [tam];
             for (int i=0;i<tam;i++)
            {
                cuadradoY[i]=datosY[i]*datosY[i];
            }
             //subproceso sumatoria cuadradoY
             double sumatoriaY2=0;
            for (int i=0;i<tam;i++)
            {
                sumatoriaY2+=cuadradoY[i];
                
            }
            System.out.println("la sumatoria en Y2 es:"+sumatoriaY2);
            
            //subproceso determinarPArametroA
            double A=(((sumatoriaY)*(sumatoriaX2))-((sumatoriaXY)*(sumatoriaX)))/(((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2)));
             System.out.println("Parametro A:"+ A);
            
            double B=(((tam)*(sumatoriaXY))-((sumatoriaX)*(sumatoriaY)))/(((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2))); 
            System.out.println("Parametro B:"+ B);
            
            //subproceso HallarDelta
            double delta=0;
            delta=((tam)*(sumatoriaX2))-(Math.pow(sumatoriaX,2));
            //subproceso sumatoriaDiscrepamciasAlCuadrado
            double sumatoriaDiscrepancia2=(sumatoriaY2)-((2)*(A)*(sumatoriaY))-((2)*(B)*(sumatoriaXY))+((tam)*(Math.pow(A,2)))+((2)*(A)*(B)*(sumatoriaX))+((Math.pow(B,2))*(sumatoriaX2));
            //subproceso sigma cuadrado
            double sigma2=0;
            sigma2=(sumatoriaDiscrepancia2)/((tam)-(2));
            //subproceso determinar el errror de A
            double errorA=0;
            errorA=Math.sqrt(((sigma2)*(sumatoriaX2))/(delta));
            //subproceso determinarErrorB
            double errorB=0;
            errorB=Math.sqrt(((sigma2)*(tam))/(delta));
            //RESULTADO
            System.out.println("A = ("+ A + "+-" + errorA + ")");
            System.out.println("B = ("+ B + "+-" + errorB + ")");

    }
}