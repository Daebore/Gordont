package com.backendstreetboys.gordont;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

//import androidx.annotation.RequiresApi;
//import androidx.room.Room;

import com.backendstreetboys.gordont.database.*;
import com.backendstreetboys.gordont.util.*;
import com.backendstreetboys.gordont.databinding.ActivityQuestViewBinding;

import java.time.Instant;

public class QuestViewActivity extends AppCompatActivity {

    public ActivityQuestViewBinding binding;
    public AppDatabase bd;
    UsuarioDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = AppDatabase.getDatabase(getApplicationContext());
        userDao = bd.userDao();

        if (!userDao.getAll().isEmpty()) {
            startActivity(new Intent(this, HomeActivity.class));
            setContentView(R.layout.activity_home);
        } else {
            binding = ActivityQuestViewBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

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
                        String stringSexo;

                        if (sexo == binding.radioChico.getId()) {
                            stringSexo = "hombre";
                        } else {
                            stringSexo = "mujer";
                        }
                        guardarEnBD(nombre, doubleAltura, doublePeso, intEdad, stringSexo);
                        MediaPlayer mp = MediaPlayer.create(this, R.raw.hellothere);
                        mp.start();
                        startActivity(new Intent(this, HomeActivity.class));
                        setContentView(R.layout.activity_home);
                    }
                }
            });
        }
    }

    public void guardarEnBD(String nombre, double altura, double peso, int edad, String sexo) {
        PesoYAlturaDao pyaDao = bd.pyaDao();
        userDao.insertAll(new Usuario(nombre, edad, sexo));
        pyaDao.insertAll(new PesoYAltura(Instant.now().getEpochSecond(), altura, peso));
    }

}