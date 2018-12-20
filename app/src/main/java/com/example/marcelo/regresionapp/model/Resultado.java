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
  double sigma;
  double delta;

    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    double sumatoriaDiscrepancia2;

  double error_param_a;

  public double getCoef_corrl() {
    return coef_corrl;
  }

  public void setCoef_corrl(double coef_corrl) {
    this.coef_corrl = coef_corrl;
  }

  double coef_corrl;

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

  public double getError_param_a() {
    return error_param_a;
  }

  public void setError_param_a(double error_param_a) {
    this.error_param_a = error_param_a;
  }

  public double getSumatoriaDiscrepancia2() {
    return sumatoriaDiscrepancia2;
  }
  public void setSumatoriaDiscrepancia2(double sumatoriaDiscrepancia2) {
    this.sumatoriaDiscrepancia2 = sumatoriaDiscrepancia2;
  }
}
