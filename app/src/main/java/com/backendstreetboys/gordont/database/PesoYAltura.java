package com.backendstreetboys.gordont.database;

import androidx.annotation.NonNull;
import androidx.room.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
public class PesoYAltura {
    @PrimaryKey
    @NonNull
    public long fecha; // Fecha y hora en segundos.

    public double altura;

    public double peso;

    public LocalDateTime getFechaLDT(ZoneOffset zoffset){
        return LocalDateTime.ofEpochSecond(fecha, 0, zoffset);
    }

    public PesoYAltura() {
        super();
    }

    public PesoYAltura(@NonNull long fecha, double altura, double peso) {
        this.fecha = fecha;
        this.altura = altura;
        this.peso = peso;
    }
}
