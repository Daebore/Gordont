package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.backendstreetboys.gordont.databinding.ActivityDietasEjerciciosBinding;
import com.backendstreetboys.gordont.databinding.ActivityMainBinding;

public class DietasEjercicios extends AppCompatActivity {

    private ActivityDietasEjerciciosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DietasEjercicios", "HOLA EJERCICIOS uwu");
        binding = ActivityDietasEjerciciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("DietasEjercicios", "EL BINDING YA ESTA HECHO");


        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
           // setContentView(R.layout.activity_modificable);
        });

        binding.ButtonHome.setOnClickListener( v ->{
            Log.d("DietasEjercicios", "pulsando el boton de home");
            openMain();

           // setContentView(R.layout.activity_main);
        });

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