package com.backendstreetboys.gordont;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface DaoUsuario {

    @Query("SELECT * FROM DatosGordo")
    List<DatosGordo>getAll();

    @Query("SELECT * FROM DatosGordo WHERE altura <180")
    DatosGordo findByAltura(double altura);

    @Insert
    void insertarGordon(DatosGordo datosGordos);
}
