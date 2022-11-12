package com.backendstreetboys.gordont;

import android.content.Intent;
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


        binding.ButtonGym.setOnClickListener( v -> {
            DescargarGYM();

        });




    }



    public void DescargarGYM(){

        String MY_URL = "https://seom.org/seomcms/images/stories/recursos/Guias_Nutricion_Ejercicio_Cancer_Mama.pdf";
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


}