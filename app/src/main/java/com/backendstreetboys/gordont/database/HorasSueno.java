package com.backendstreetboys.gordont.database;

import androidx.annotation.NonNull;
import androidx.room.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
public class HorasSueno {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "momento_inicio")
    public long momentoInicio; // Fecha y hora de inicio en segundos.

    @ColumnInfo(name = "momento_fin")
    public long momentoFin; // Fecha y hora de fin en segundos.

    @ColumnInfo(name = "tiempo_sueno")
    public long tiempoSueno; // Tiempo total de sueño en milisegundos.

    public LocalDateTime getInicioAsLDT(ZoneOffset zoffset){
        return LocalDateTime.ofEpochSecond(momentoInicio, 0, zoffset);
    }

    public LocalDateTime getFinAsLDT(ZoneOffset zoffset){
        return LocalDateTime.ofEpochSecond(momentoFin, 0, zoffset);
    }

    public HorasSueno() {
        super();
    }

    public HorasSueno(long tiempoSueno, long momentoInicio, long momentoFin) {
        this.tiempoSueno = tiempoSueno;
        this.momentoInicio = momentoInicio;
        this.momentoFin = momentoFin;
    }
}