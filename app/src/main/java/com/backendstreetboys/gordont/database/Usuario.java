package com.backendstreetboys.gordont.database;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity
public class Usuario {
    @PrimaryKey
    @NonNull
    public String nombre;

    @ColumnInfo(name = "edad")
    public int edad;

    @ColumnInfo(name = "sexo")
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
