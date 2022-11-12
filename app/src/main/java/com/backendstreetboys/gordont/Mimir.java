package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.backendstreetboys.gordont.databinding.ActivityMainBinding;
import com.backendstreetboys.gordont.databinding.ActivityMimirBinding;

public class Mimir extends AppCompatActivity {

    private ActivityMimirBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMimirBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            openDietasEjercicios();
            // setContentView(R.layout.activity_dietas_ejercicios);
        });

        binding.ButtonHome.setOnClickListener(v -> {
            openMain();
            //  setContentView(R.layout.activity_main);
        });

        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
            // setContentView(R.layout.activity_modificable);
        });



    }



    public void openMain () {

        Intent intent = new Intent(this, MainActivity.class);


        startActivity(intent);

    }

    public void openModificable(){

        Intent intent = new Intent(this, Modificable.class);



        startActivity(intent);

    }

    public void openDietasEjercicios () {

        Intent intent = new Intent(this, DietasEjercicios.class);


        startActivity(intent);

    }

}