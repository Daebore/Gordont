package com.backendstreetboys.gordont;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        double imc = extras.getDouble(EL_IMC);
        String mensaje = extras.getString(EL_MENSAJE);

        String texto_imc = String.valueOf(imc);

        binding.IMCtext.setText(texto_imc);
        binding.MENSAJEtext.setText(mensaje);



    }



}