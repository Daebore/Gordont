package com.backendstreetboys.gordont;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.backendstreetboys.gordont.databinding.ActivityDietasEjerciciosBinding;

public class DietasEjerciciosActivity extends AppCompatActivity {

    private ActivityDietasEjerciciosBinding binding;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDietasEjerciciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botones de descarga de PDFs.
        binding.ButtonADieta.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.darthvader);
            mp.start();
            DescargarDieta();
        });
        binding.ButtonGym.setOnClickListener(v -> {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.darthvader);
            mp.start();
            DescargarGYM();
        });

        // Botones de la barra de menú.
        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
        });
        binding.ButtonHome.setOnClickListener(v -> {
            openMain();
        });
        binding.ButtonBascula.setOnClickListener(v -> {
            openComparar();
        });
        binding.ButtonSueno.setOnClickListener(v -> {
            openSueno();
        });
    }

    public void DescargarDieta() {
        String MY_URL = "https://fundaciondelcorazon.com/images/stories/file/dieta_sobrepeso.pdf";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
    }

    public void openComparar() {
        Intent intent = new Intent(this, RegistrosActivity.class);
        startActivity(intent);
    }


    public void DescargarGYM() {
        String MY_URL = "https://www.rockandwallclimbing.com/wp-content/uploads/2020/03/RUTINAS-DE-ENTRENAMIENTOS-EN-CASA.pdf";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
    }


    public void openModificable() {
        Intent intent = new Intent(this, ActualizarPyaActivity.class);
        startActivity(intent);
    }

    public void openMain() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openSueno() {
        Intent intent = new Intent(this, MimirActivity.class);
        startActivity(intent);
    }

}