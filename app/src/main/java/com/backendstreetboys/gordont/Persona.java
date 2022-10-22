package com.backendstreetboys.gordont;

public class Persona {

    protected   double altura;
    protected double peso;
    protected  int edad;
    protected  boolean sexo;


    public Persona(double altura, double peso, int edad, boolean sexo) {
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

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

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
}
