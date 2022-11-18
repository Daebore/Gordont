package com.backendstreetboys.gordont;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Chronometer;

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

        binding.ButtonBascula.setOnClickListener( v ->{
            openComparar();
        });

        binding.ButtonHome.setOnClickListener(v -> {
            openMain();
            //  setContentView(R.layout.activity_main);
        });

        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
            // setContentView(R.layout.activity_modificable);
        });


        binding.ButtonStartSuenyo.setOnClickListener( v-> {
            startCronometro();
        });


        binding.ButtonStopSuenyo.setOnClickListener( v-> {
            stopCronometro();
        });


    }


    public void startCronometro(){
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer

        simpleChronometer.start(); // start a chronometer
    }

    public void stopCronometro(){
        Chronometer simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer

        simpleChronometer.stop();
        simpleChronometer.setBase(SystemClock.elapsedRealtime()); // start a chronometer
    }



    public void openMain () {

        Intent intent = new Intent(this, MainActivity.class);


        startActivity(intent);

    }

    public void openModificable(){

        Intent intent = new Intent(this, Modificable.class);



        startActivity(intent);

    }

    public void openComparar(){

        Intent intent = new Intent(this, ComparaPeso.class);

        startActivity(intent);
    }

    public void openDietasEjercicios () {

        Intent intent = new Intent(this, DietasEjercicios.class);


        startActivity(intent);

    }

}