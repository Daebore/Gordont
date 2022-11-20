package com.backendstreetboys.gordont;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import com.backendstreetboys.gordont.database.AppDatabase;
import com.backendstreetboys.gordont.database.HorasSueno;
import com.backendstreetboys.gordont.databinding.ActivityMimirBinding;
import java.time.Instant;

public class MimirActivity extends AppCompatActivity {

    private ActivityMimirBinding binding;
    boolean isChronometerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMimirBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botones del cronómetro.
        binding.ButtonStartSuenyo.setOnClickListener(v -> {
            startCronometro();
        });
        binding.ButtonStopSuenyo.setOnClickListener(v -> {
            stopCronometro();
        });

        // Botones de la barra de menú.
        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            openDietasEjercicios();
        });
        binding.ButtonBascula.setOnClickListener(v -> {
            openComparar();
        });
        binding.ButtonHome.setOnClickListener(v -> {
            openMain();
        });
        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
        });
    }

    public void startCronometro() {
        if(!isChronometerRunning){
            Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
            simpleChronometer.start();
            isChronometerRunning = true;
        }
    }

    public void stopCronometro() {
        if(isChronometerRunning){
            Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
            // Tiempo contado por el cronómetro en milisegundos.
            long tiempo = SystemClock.elapsedRealtime() - simpleChronometer.getBase();
            simpleChronometer.stop();
            simpleChronometer.setBase(SystemClock.elapsedRealtime());
            anadirHorasSuenoBD(tiempo);
            isChronometerRunning = false;
        }
    }

    public void anadirHorasSuenoBD(long tiempoSueno){
        Instant instanteFin = Instant.now();
        AppDatabase bd = AppDatabase.getDatabase(getApplicationContext());
        bd.hsDao().insertAll(new HorasSueno(
                tiempoSueno,
                instanteFin.minusMillis(tiempoSueno).getEpochSecond(), // El momento de inicio es el momento de fin menos el tiempo de sueño.
                instanteFin.getEpochSecond()
        ));
    }

    public void openMain() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openModificable() {
        Intent intent = new Intent(this, ActualizarPyaActivity.class);
        startActivity(intent);
    }

    public void openComparar() {
        Intent intent = new Intent(this, RegistrosActivity.class);
        startActivity(intent);
    }

    public void openDietasEjercicios() {
        Intent intent = new Intent(this, DietasEjerciciosActivity.class);
        startActivity(intent);
    }

}