package com.backendstreetboys.gordont;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.backendstreetboys.gordont.database.AppDatabase;
import com.backendstreetboys.gordont.database.PesoYAltura;
import com.backendstreetboys.gordont.database.PesoYAlturaDao;
import com.backendstreetboys.gordont.databinding.ActivityActualizarPyaBinding;
import com.backendstreetboys.gordont.util.AppToast;

import java.time.Instant;

public class ActualizarPyaActivity extends AppCompatActivity {

    private ActivityActualizarPyaBinding binding;
    public AppDatabase bd;
    public PesoYAlturaDao pyaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActualizarPyaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botón de actualizar datos de peso y altura.
        binding.ButtonAct.setOnClickListener(v -> {
            String altura = binding.alturaAct.getText().toString();
            String peso = binding.pesoAct.getText().toString();

            if (altura.isEmpty() || peso.isEmpty()) {
                AppToast.showToast(this, "El peso y la altura no pueden estar vacios", Toast.LENGTH_SHORT);
            } else {
                double doubleAltura = Double.parseDouble(altura);
                double doublePeso = Double.parseDouble(peso);

                if (doubleAltura > 3) {
                    AppToast.showToast(this, "La altura tiene que ser en metros", Toast.LENGTH_SHORT);
                } else {
                    anadirPyaBD(doubleAltura, doublePeso);
                    AppToast.showToast(this, "Peso y altura actualizados", Toast.LENGTH_SHORT);
                    MediaPlayer mp = MediaPlayer.create(this, R.raw.r2d2);
                    mp.start();
                    openMain();
                }
            }
        });

        // Botones de la barra de menú.
        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            openDietasEjercicios();
        });
        binding.ButtonHome.setOnClickListener(v -> {
            openMain();
        });
        binding.ButtonSueno.setOnClickListener(v -> {
            openSueno();
        });
        binding.ButtonBascula.setOnClickListener(v -> {
            openComparar();
        });
    }

    public void anadirPyaBD(double altura, double peso) {
        bd = AppDatabase.getDatabase(getApplicationContext());
        pyaDao = bd.pyaDao();
        pyaDao.insertAll(new PesoYAltura(Instant.now().getEpochSecond(), altura, peso));
    }

    public void openMain() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSueno() {
        Intent intent = new Intent(this, MimirActivity.class);
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