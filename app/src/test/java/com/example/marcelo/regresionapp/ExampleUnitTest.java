package com.example.marcelo.regresionapp;

import com.example.marcelo.regresionapp.model.Lineal;
import com.example.marcelo.regresionapp.model.Nolineal;
import com.example.marcelo.regresionapp.model.Regresion;
import com.example.marcelo.regresionapp.model.Resultado;

import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

      Regresion regresion1;
      Regresion regresion2;
    @Before
    public void before(){
        regresion1 = new Nolineal(6);
        regresion2 = new Lineal(5);

        regresion1.addx(2.221);
        regresion1.addx(1.940);
        regresion1.addx(1.745);
        regresion1.addx(1.498);
        regresion1.addx(0.999);
        regresion1.addx(0.712);

        regresion1.addy(44.75);
        regresion1.addy(28.20);
        regresion1.addy(21.71);
        regresion1.addy(13.75);
        regresion1.addy(4.09);
        regresion1.addy(1.48);

        regresion2.addx(1.0);
        regresion2.addx(2.0);
        regresion2.addx(3.0);
        regresion2.addx(4.0);
        regresion2.addx(5.0);

        regresion2.addy(8.65);
        regresion2.addy(17.30);
        regresion2.addy(25.95);
        regresion2.addy(34.63);
        regresion2.addy(43.31);

    }
    @Test
    public void probarDatos() {
        System.out.println("REGRESION NO LINEAL");
        Resultado resultado = regresion1.calcularResultado();
        System.out.println("RESULTADO A = "+resultado.getParamA());
        System.out.println("RESULTADO B = "+resultado.getParamB());
        System.out.println("RESULTADO param_a= "+ resultado.getParam_a());
        System.out.println("RESULTADO param_b= "+ resultado.getParam_b());
        System.out.println("ErrorA = "+ resultado.getErrorA());
        System.out.println("ErroB = "+ resultado.getErrorB());

        System.out.println(" ");

        Resultado resultado2 = regresion2.calcularResultado();
        System.out.println("REGRESION LINEAL");
        System.out.println("RESULTADO A= "+ resultado2.getParamA());
        System.out.println("RESULTADO B= "+ resultado2.getParamB());
        System.out.println("EroorA="+resultado2.getErrorA());
        System.out.println("EroorB="+resultado2.getErrorB());

       assertEquals(-0.027,resultado2.getParamA(),0.0001);
       assertEquals(8.665,resultado2.getParamB(),0.0001);

    }

}