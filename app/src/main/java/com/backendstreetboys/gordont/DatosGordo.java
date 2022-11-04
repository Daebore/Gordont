package com.backendstreetboys.gordont;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity
public class DatosGordo {

    @PrimaryKey
    @NonNull
    public double altura;
    public double peso;
    public LocalDate fecha;

    public DatosGordo(@NonNull  double altura, double peso, LocalDate fecha) {
        this.altura = altura;
        this.peso = peso;
        this.fecha = fecha;
    }
}
