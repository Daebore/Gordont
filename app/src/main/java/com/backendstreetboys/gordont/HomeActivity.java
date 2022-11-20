package com.backendstreetboys.gordont;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.backendstreetboys.gordont.database.*;
import com.backendstreetboys.gordont.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private Bitmap takenPhotoBitmap;

    private ActivityHomeBinding binding;
    public AppDatabase bd;
    public UsuarioDao userDao;
    public PesoYAlturaDao pyaDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recogerDatosBD();

        // Botones de la barra de menú.
        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            openDietasEjercicios();
        });
        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
        });
        binding.ButtonSueno.setOnClickListener(v -> {
            openSueno();
        });
        binding.ButtonBascula.setOnClickListener(v -> {
            openComparar();
        });

        binding.camera.setOnClickListener(v -> {
            openCamera();
        });

    }

    private void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == Activity.RESULT_OK && requestCode == 1000){

            if (data != null){
                takenPhotoBitmap = data.getExtras().getParcelable("data");
                binding.camera.setImageBitmap(takenPhotoBitmap);

            }

        }


    }


    public void recogerDatosBD() {
        // Obtener objetos BD.
        bd = AppDatabase.getDatabase(getApplicationContext());
        userDao = bd.userDao();
        pyaDao = bd.pyaDao();

        // Sacar datos del usuario y calcular IMC.
        Usuario user = userDao.getAll().get(0);
        PesoYAltura pya = pyaDao.getLatest();
        double imc = operacionIMC(pya.altura, pya.peso);

        // Mostrar los datos en sus respectivos campos.
        binding.IMCtext.setText(String.valueOf(imc));
        binding.MENSAJEtext.setText(resultadoMensaje(imc));
        binding.textUser.setText(user.nombre);
    }

    public double operacionIMC(double doubleAltura, double doublePeso) {
        double alturaCuadrado = doubleAltura * doubleAltura;
        double resultado = doublePeso / alturaCuadrado;
        double resultadoF = Math.round(resultado * 100) / 100;

        System.out.println(" El peso es de" + doublePeso);
        System.out.println("La altura es de " + doubleAltura);
        System.out.println("La altura ^2 es " + alturaCuadrado);
        System.out.println("El resultado es de " + resultado);
        return resultadoF;
    }

    public String resultadoMensaje(double resultado) {
        String mensaje = null;
        if (resultado < 18.5) {
            mensaje = "Estás debajo de tu peso ideal";
            binding.MENSAJEtext.setTextColor(getResources().getColor(R.color.teal_200));
        } else if (resultado >= 18.5 && resultado < 24.9) {
            mensaje = "Estás en tu peso ideal";
            binding.MENSAJEtext.setTextColor(getResources().getColor(R.color.verde));
        } else if (resultado >= 25.0 && resultado < 29.9) {
            mensaje = "Tienes sobreso";
            binding.MENSAJEtext.setTextColor(getResources().getColor(R.color.amarillo));
        } else if (resultado >= 30.0 && resultado < 34.9) {
            mensaje = "Tienes obesidad grado I";
            binding.MENSAJEtext.setTextColor(getResources().getColor(R.color.orange));
        } else if (resultado >= 35 && resultado < 39.9) {
            mensaje = "Tienes obesidad de grado II";
            binding.MENSAJEtext.setTextColor(getResources().getColor(R.color.rojo));
        } else if (resultado >= 40.0) {
            mensaje = "Tienes obesidad grado III";
            binding.MENSAJEtext.setTextColor(getResources().getColor(R.color.purple_500));
        }
        return mensaje;
    }

    public void openModificable() {
        Intent intent = new Intent(this, ActualizarPyaActivity.class);
        startActivity(intent);
    }

    public void openDietasEjercicios() {
        Intent intent = new Intent(this, DietasEjerciciosActivity.class);
        startActivity(intent);
    }

    public void openSueno() {
        Intent intent = new Intent(this, MimirActivity.class);
        startActivity(intent);
    }

    public void openComparar() {
        Intent intent = new Intent(this, RegistrosActivity.class);
        startActivity(intent);
    }

}