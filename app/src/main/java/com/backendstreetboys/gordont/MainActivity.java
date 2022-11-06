package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.backendstreetboys.gordont.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    /*
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            setContentView(binding.getRoot());

        }

       */
    public static final String EL_IMC = "imc";
    public static final String EL_MENSAJE = "mensaje";
    public static final String EL_NOMBRE = "nombre";


    /*
     * hola javi
     * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        double imc = extras.getDouble(EL_IMC);

        String mensaje = extras.getString(EL_MENSAJE);

        String nombre = extras.getString(EL_NOMBRE);

        String texto_imc = String.valueOf(imc);

        binding.IMCtext.setText(texto_imc);
        binding.MENSAJEtext.setText(mensaje);
        binding.textUser.setText(nombre);


        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
          openDietasEjercicios();
          //  setContentView(R.layout.activity_dietas_ejercicios);
        });

        binding.ButtonModificarPerfil.setOnClickListener(v -> {
           openModificable();
           // setContentView(R.layout.activity_modificable);
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



}