package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.backendstreetboys.gordont.databinding.ActivityQuestViewBinding;

public class Quest_view extends AppCompatActivity {
/*
    private ActivityQuestViewBinding binding;

    Persona persona;

    String peso = binding.editPeso.getText().toString();
    String altura = binding.editAltura.getText().toString();
    String edad = binding.editEdad.getText().toString();


    double doubleAltura = Integer.parseInt(altura);
    double doublePeso = Integer.parseInt(peso);
    int intEdad = Integer.parseInt(edad);


    double IMC = operacionIMC(doublePeso, doubleAltura, intEdad);


    String mensajeFinal = resultadoMensaje(IMC);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ButtonSave.setOnClickListener( v -> {

            operacionIMC(doublePeso, doubleAltura, intEdad);

            resultadoMensaje(IMC);

            openMainActivity(IMC, mensajeFinal);


        });

        setContentView(R.layout.activity_quest_view);
    }



    public double operacionIMC(double doubleAltura, double doublePeso, int intEdad){

        Persona persona = new Persona(doubleAltura, doublePeso, intEdad);

        double IMC = persona.resultadoOperacion(persona);

        return IMC;

    }


    public String resultadoMensaje(double resultado){
        String mensaje = null;


        if (resultado <  18.5){
            mensaje = "Tu estas gordon't ";
        }
        else if (resultado > 18.5 || resultado < 24.9){
            mensaje = "Tu estas chad ";
        }
        else if (resultado > 25.0  || resultado < 29.9){
            mensaje = "Tu estas gordo ";
        }
        else if (resultado > 30.0  || resultado < 39.9){
            mensaje = "Tu estas MUY GORDO ";
        }
        else if (resultado > 40.0 ){
            mensaje = "no se como coño estas vivo ";
        }

        return mensaje;

    }

    public void openMainActivity(double IMC, String mensajeFinal){

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(MainActivity.EL_IMC, IMC);
        intent.putExtra(MainActivity.EL_MENSAJE, mensajeFinal);

        startActivity(intent);

    }


*/




}