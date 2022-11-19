package com.backendstreetboys.gordont.database;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity
public class Usuario {
    @PrimaryKey
    @NonNull
    public String nombre;

    public int edad;

    public String sexo;

    public Usuario() {
        super();
    }

    public Usuario(@NonNull String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
}
