package com.backendstreetboys.gordont.database;

import androidx.annotation.NonNull;
import androidx.room.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
public class PesoYAltura {
    @PrimaryKey
    @NonNull
    public long fecha;

    @ColumnInfo(name = "altura")
    public double altura;

    @ColumnInfo(name = "peso")
    public double peso;

    public LocalDateTime getFechaLDT(){
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(fecha), ZoneId.of("ECT"));
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
