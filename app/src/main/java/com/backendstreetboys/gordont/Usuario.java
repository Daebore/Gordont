package com.backendstreetboys.gordont;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "nombreUsuario")
    String nombreUsuario;

    @ColumnInfo(name = "altura")
    double altura;

    @ColumnInfo(name = "peso")
    double peso;


    public Usuario(int id, String nombreUsuario, double altura, double peso) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.altura = altura;
        this.peso = peso;

        id++;

    }
}
