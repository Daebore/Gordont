package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.backendstreetboys.gordont.databinding.ActivityDietasEjerciciosBinding;

public class DietasEjercicios extends AppCompatActivity {

    private ActivityDietasEjerciciosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding=  ActivityDietasEjerciciosBinding.inflate(getLayoutInflater());

        setContentView(R.layout.activity_dietas_ejercicios);


        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
           // setContentView(R.layout.activity_modificable);
        });

        binding.ButtonHome.setOnClickListener( v ->{
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