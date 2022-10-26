package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.backendstreetboys.gordont.databinding.ActivityQuestViewBinding;

public class Quest_view extends AppCompatActivity {
/*
    private ActivityQuestViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ButtonSave.setOnClickListener(v -> {


            setContentView(R.layout.activity_quest_view);

        });

    }
}
*/

    public ActivityQuestViewBinding binding;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ButtonSave.setOnClickListener( v -> {
            String peso = binding.editPeso.getText().toString();
            String altura = binding.editAltura.getText().toString();
            String edad = binding.editEdad.getText().toString();



            if (peso.isEmpty() || altura.isEmpty() || edad.isEmpty()){

                Log.d("Quest_view" , "La altura, peso o edad estan vacios");

                Toast.makeText(this, "El peso, la altura o la edad no pueden estar vacios", Toast.LENGTH_SHORT).show();

            }
            else {


                double doubleAltura = Double.parseDouble(altura);
                double doublePeso = Double.parseDouble(peso);
                int intEdad = Integer.parseInt(edad);


                double IMC = operacionIMC(doublePeso, doubleAltura);


                String mensajeFinal = resultadoMensaje(IMC);

                openMainActivity(IMC, mensajeFinal);


                setContentView(R.layout.activity_main);
            }

        });

    }



    public double operacionIMC(double doubleAltura, double doublePeso){



        double resultado = doublePeso * (doubleAltura * doubleAltura);


        return resultado;

    }


    public String resultadoMensaje(double resultado){
        String mensaje = null;


        if (resultado <  18.5){
            mensaje = "Tu estas gordon't ";
        }
        else if (resultado > 18.5 && resultado < 24.9){
            mensaje = "Tu estas chad ";
        }
        else if (resultado > 25.0  && resultado < 29.9){
            mensaje = "Tu estas gordo ";
        }
        else if (resultado > 30.0  && resultado < 39.9){
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







}

