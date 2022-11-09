package com.backendstreetboys.gordont.database;

import android.arch.lifecycle.LiveData;

import androidx.room.*;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuario WHERE nombre IN (:usuarioNombres)")
    List<Usuario> loadAllByNames(int[] usuarioNombres);

    @Query("SELECT * FROM usuario WHERE nombre=:name")
    Usuario findByName(String name);

    @Insert
    void insertAll(Usuario... users);

    @Delete
    void delete(Usuario user);
}