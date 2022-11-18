package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.backendstreetboys.gordont.databinding.ActivityComparaPesoBinding;

public class ComparaPeso extends AppCompatActivity {

    private ActivityComparaPesoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComparaPesoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            Log.d("MainActivity", "LLENGO A DIETAS EJERCICIOS");
            openDietasEjercicios();
            //  setContentView(R.layout.activity_dietas_ejercicios);
        });

        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
            // setContentView(R.layout.activity_modificable);
        });

        binding.ButtonSueno.setOnClickListener(v -> {
            openSueno();
            // setContentView(R.layout.activity_modificable);
        });

        binding.ButtonHome.setOnClickListener(v ->{
            openHome();
        });
    }



    public void openModificable(){

        Intent intent = new Intent(this, Modificable.class);



        startActivity(intent);

    }

    public void openDietasEjercicios(){

        Intent intent = new Intent(this, DietasEjercicios.class);



        startActivity(intent);

    }

    public void openSueno(){

        Intent intent = new Intent(this, Mimir.class);



        startActivity(intent);

    }

    public void openHome(){

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }



}