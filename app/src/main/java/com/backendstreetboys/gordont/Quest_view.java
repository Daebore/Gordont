package com.backendstreetboys.gordont;

import android.content.Intent;
import android.media.MediaPlayer;
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

import com.backendstreetboys.gordont.database.*;
import com.backendstreetboys.gordont.util.*;
import com.backendstreetboys.gordont.databinding.ActivityQuestViewBinding;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Quest_view extends AppCompatActivity {

    EditText etNombre, etAltura, etPeso;
    Button etSave;

    public ActivityQuestViewBinding binding;
    public AppDatabase bd;
    UsuarioDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bd = AppDatabase.getDatabase(getApplicationContext());
        userDao = bd.userDao();

        if(!userDao.getAll().isEmpty()){
            startActivity(new Intent(this, MainActivity.class));
            setContentView(R.layout.activity_main);
        }else {



            binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
/*
            etNombre = findViewById(R.id.editNombre);
            etAltura = findViewById(R.id.editAltura);
            etPeso = findViewById(R.id.editPeso);
            etSave = findViewById(R.id.ButtonSave);
*/


            binding.ButtonSave.setOnClickListener(v -> {
                String peso = binding.editPeso.getText().toString();
                final String altura = binding.editAltura.getText().toString();
                final String edad = binding.editEdad.getText().toString();
                String nombre = binding.editNombre.getText().toString();
                int sexo = binding.opcionesSexo.getCheckedRadioButtonId();


                if (peso.isEmpty() || altura.isEmpty() || edad.isEmpty() || nombre.isEmpty() || sexo == -1) {

                    Log.d("Quest_view", "La altura, peso o edad estan vacios");

                    AppToast.showToast(this, "El peso, la altura , la edad o el nombre no pueden estar vacios", Toast.LENGTH_SHORT);

                } else {

                    double doubleAltura = Double.parseDouble(altura);

                    if (doubleAltura > 3) {
                        AppToast.showToast(this, "La altura tiene que ser en metros", Toast.LENGTH_SHORT);
                    } else {
                        double doublePeso = Double.parseDouble(peso);
                        int intEdad = Integer.parseInt(edad);
//                        double IMC = operacionIMC(doubleAltura, doublePeso);
//                        String mensajeFinal = resultadoMensaje(IMC);

                        String stringSexo;
                        if (sexo == binding.radioChico.getId()) {
                            stringSexo = "hombre";
                        } else {
                            stringSexo = "mujer";
                        }

                        //openMainActivity(IMC, mensajeFinal, nombre);

                        guardarEnBD(nombre, doubleAltura, doublePeso, intEdad, stringSexo);
                        startActivity(new Intent(this, MainActivity.class));

                        MediaPlayer mp = MediaPlayer.create(this, R.raw.hellothere);
                        mp.start();
                        setContentView(R.layout.activity_main);
                    }
                }
            });
        }

    }

    public void guardarEnBD(String nombre, double altura, double peso, int edad, String sexo){
        PesoYAlturaDao pyaDao = bd.pyaDao();

        userDao.insertAll(new Usuario(nombre, edad, sexo));
        pyaDao.insertAll(new PesoYAltura(Instant.now().getEpochSecond(), altura, peso));

    }

    public void openMainActivity(double IMC, String mensajeFinal, String nombre) {

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra(MainActivity.EL_IMC, IMC);
        intent.putExtra(MainActivity.EL_MENSAJE, mensajeFinal);
        intent.putExtra(MainActivity.EL_NOMBRE, nombre);

        startActivity(intent);

    }


}