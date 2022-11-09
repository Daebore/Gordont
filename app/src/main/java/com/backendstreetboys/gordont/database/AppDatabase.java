package com.backendstreetboys.gordont.database;

import android.content.Context;

import androidx.room.*;

@Database(entities = {Usuario.class,PesoYAltura.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UsuarioDao userDao();

    public abstract PesoYAlturaDao pyaDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "gordont_database")
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

}
