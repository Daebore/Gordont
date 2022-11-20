package com.backendstreetboys.gordont.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PesoYAlturaDao {
    @Query("SELECT * FROM PesoYAltura")
    List<PesoYAltura> getAll();

    @Query("SELECT * FROM PesoYAltura WHERE fecha IN (:PesoYAlturaFechas)")
    List<PesoYAltura> loadAllByDates(int[] PesoYAlturaFechas);

    @Query("SELECT * FROM PesoYAltura WHERE fecha=:fecha")
    PesoYAltura findByDate(long fecha);

    @Query("SELECT * FROM PesoYAltura WHERE fecha=(SELECT max(fecha) FROM PesoYAltura)")
    PesoYAltura getLatest();

    @Insert
    void insertAll(PesoYAltura... pyas);

    @Delete
    void delete(PesoYAltura pyas);
}
