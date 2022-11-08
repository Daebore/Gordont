package com.backendstreetboys.gordont;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import androidx.annotation.RequiresApi;
//import androidx.room.Room;

import com.backendstreetboys.gordont.databinding.ActivityQuestViewBinding;

import java.time.LocalDate;

public class Quest_view extends AppCompatActivity {

    EditText etNombre, etAltura, etPeso;
    Button etSave;

    public ActivityQuestViewBinding binding;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
/*
        etNombre = findViewById(R.id.editNombre);
        etAltura = findViewById(R.id.editAltura);
        etPeso = findViewById(R.id.editPeso);
        etSave = findViewById(R.id.ButtonSave);
*/



        binding.ButtonSave.setOnClickListener( v -> {
            String peso = binding.editPeso.getText().toString();
          final  String altura = binding.editAltura.getText().toString();
          final  String edad = binding.editEdad.getText().toString();
            String nombre = binding.editNombre.getText().toString();


            if (peso.isEmpty() || altura.isEmpty() || edad.isEmpty() || nombre.isEmpty()){

                Log.d("Quest_view" , "La altura, peso o edad estan vacios");

                Toast.makeText(this, "El peso, la altura , la edad o el nombre no pueden estar vacios", Toast.LENGTH_SHORT).show();

            }
            else {


                double doubleAltura = Double.parseDouble(altura);

                if (doubleAltura >3){

                    Toast.makeText(this, "La altura tiene que ser en metros", Toast.LENGTH_SHORT).show();


                }else{





                double doublePeso = Double.parseDouble(peso);
                int intEdad = Integer.parseInt(edad);


                double IMC = operacionIMC(doubleAltura, doublePeso);


                String mensajeFinal = resultadoMensaje(IMC);

                openMainActivity(IMC, mensajeFinal, nombre);


                setContentView(R.layout.activity_main);
            }
        }
        });

    }



    public double operacionIMC(double doubleAltura, double doublePeso){

        System.out.println(" El peso es de" + doublePeso);

        System.out.println("La altura es de " + doubleAltura);

        double alturaCuadrado = doubleAltura * doubleAltura;

        System.out.println("La altura ^2 es " + alturaCuadrado);

        double resultado =  doublePeso /  alturaCuadrado ;

        System.out.println( "El resultado es de " + resultado);



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

    public void openMainActivity(double IMC, String mensajeFinal, String nombre){

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(MainActivity.EL_IMC, IMC);
        intent.putExtra(MainActivity.EL_MENSAJE, mensajeFinal);
        intent.putExtra(MainActivity.EL_NOMBRE,nombre);

        startActivity(intent);

    }







}