package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.backendstreetboys.gordont.databinding.ActivityMainBinding;
import com.backendstreetboys.gordont.databinding.ActivityModificableBinding;

public class Modificable extends AppCompatActivity {

    private ActivityModificableBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityModificableBinding.inflate(getLayoutInflater());

        setContentView(R.layout.activity_modificable);

        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            openDietasEjercicios();
           // setContentView(R.layout.activity_dietas_ejercicios);
        });

        binding.ButtonHome.setOnClickListener( v ->{
            openMain();
          //  setContentView(R.layout.activity_main);
        });



    }

    public void openMain(){

        Intent intent = new Intent(this, MainActivity.class);



        startActivity(intent);

    }

    public void openDietasEjercicios(){

        Intent intent = new Intent(this, DietasEjercicios.class);



        startActivity(intent);

    }


}