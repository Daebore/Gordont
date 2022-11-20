package com.backendstreetboys.gordont.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface HorasSuenoDao {
    @Query("SELECT * FROM HorasSueno")
    List<HorasSueno> getAll();

    @Query("SELECT * FROM HorasSueno WHERE momento_inicio IN (:HorasSuenoInicios)")
    List<HorasSueno> loadAllByInicio(int[] HorasSuenoInicios);

    @Query("SELECT * FROM HorasSueno WHERE momento_inicio=:momento_inicio")
    HorasSueno findByInicio(long momento_inicio);

    @Query("SELECT * FROM HorasSueno WHERE momento_inicio=(SELECT max(momento_inicio) FROM HorasSueno)")
    HorasSueno getLatest();

    @Insert
    void insertAll(HorasSueno... horasSuenos);

    @Delete
    void delete(HorasSueno horasSueno);
}
