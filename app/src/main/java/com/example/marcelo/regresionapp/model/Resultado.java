package com.example.marcelo.regresionapp.model;

import java.math.BigDecimal;

/**
 * Write a description of class Resultado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resultado
{
  double paramA;
  double paramB;
  Tipo tipoResultado;
  double param_a;
  double param_b;
  double errorA;
  double errorB;

  public Resultado(Tipo tipo){
    this.tipoResultado = tipo;

  }

  public double getErrorA() {
    return errorA;
  }

  public void setErrorA(double errorA) {
    this.errorA = errorA;
  }

  public double getErrorB() {
    return errorB;
  }

  public void setErrorB(double errorB) {
    this.errorB = errorB;
  }

  public double getParamA() {
    return paramA;
  }

  public void setParamA(Double paramA) {
    this.paramA = paramA;
  }

  public double getParamB() {
    return paramB;
  }

  public void setParamB(double paramB) {
    this.paramB = paramB;
  }

  public Tipo getTipoResultado() {
    return tipoResultado;
  }

  public void setTipoResultado(Tipo tipoResultado) {
    this.tipoResultado = tipoResultado;
  }

  public double getParam_a() {
    return param_a;
  }

  public void setParam_a(double param_a) {
    this.param_a = param_a;
  }

  public double getParam_b() {
    return param_b;
  }

  public void setParam_b(double param_b) {
    this.param_b = param_b;
  }
}
