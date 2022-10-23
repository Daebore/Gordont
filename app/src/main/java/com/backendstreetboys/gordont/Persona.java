package com.backendstreetboys.gordont;

import android.os.Parcelable;

import org.w3c.dom.ls.LSOutput;

public class Persona  {

    protected   double altura;
    protected double peso;
    protected  int edad;



    public Persona(double altura, double peso, int edad) {
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;

    }


    public double resultadoOperacion(Persona persona){

        double resultado = peso * (altura * altura);

        return resultado;



    }







    public double getAltura() {return altura;}

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
