package com.backendstreetboys.gordont;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.backendstreetboys.gordont.databinding.ActivityDietasEjerciciosBinding;
import com.backendstreetboys.gordont.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DietasEjercicios extends AppCompatActivity {

    private ActivityDietasEjerciciosBinding binding;

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DietasEjercicios", "HOLA EJERCICIOS uwu");
        binding = ActivityDietasEjerciciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("DietasEjercicios", "EL BINDING YA ESTA HECHO");


        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();

        });

        binding.ButtonHome.setOnClickListener( v ->{
            Log.d("DietasEjercicios", "pulsando el boton de home");
            openMain();


        });

        binding.ButtonADieta.setOnClickListener( v -> {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.darthvader);
            mp.start();
            DescargarDieta();

        });


        binding.ButtonGym.setOnClickListener( v -> {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.darthvader);
            mp.start();
            DescargarGYM();

        });


        binding.ButtonSueno.setOnClickListener(v -> {
            openSueno();
            // setContentView(R.layout.activity_modificable);
        });


    }

    public void DescargarDieta(){

        String MY_URL = "https://fundaciondelcorazon.com/images/stories/file/dieta_sobrepeso.pdf";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
    }


    public void DescargarGYM(){

        String MY_URL = "https://www.rockandwallclimbing.com/wp-content/uploads/2020/03/RUTINAS-DE-ENTRENAMIENTOS-EN-CASA.pdf";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MY_URL)));
    }


    public void openModificable(){

        Intent intent = new Intent(this, Modificable.class);

        startActivity(intent);
    }

    public void openMain(){

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


    public void openSueno(){

        Intent intent = new Intent(this, Mimir.class);

        startActivity(intent);

    }

}