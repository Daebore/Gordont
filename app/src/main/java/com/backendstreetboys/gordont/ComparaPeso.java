package com.backendstreetboys.gordont;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import com.backendstreetboys.gordont.database.AppDatabase;
import com.backendstreetboys.gordont.database.HorasSueno;
import com.backendstreetboys.gordont.database.HorasSuenoDao;
import com.backendstreetboys.gordont.database.PesoYAltura;
import com.backendstreetboys.gordont.database.PesoYAlturaDao;
import com.backendstreetboys.gordont.databinding.ActivityComparaPesoBinding;

public class ComparaPeso extends AppCompatActivity {

    private ActivityComparaPesoBinding binding;
    ZoneOffset zoffset = ZoneId.systemDefault().getRules().getOffset(Instant.now());
    ArrayList<PesoYAltura> historialPya;
    ArrayList<HorasSueno> historialHs;
    int posPya;
    int posHs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComparaPesoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recogerDatosBD();

        // Flechas de registro de peso y de sueño.
        binding.flechaPesoAnterior.setOnClickListener(v -> {
            if (posPya > 0) {
                posPya--;
                binding.editRPeso.setText(formatPeso(historialPya.get(posPya)));
            }
        });
        binding.flechaPesoPosterior.setOnClickListener(v -> {
            if (posPya < historialPya.size() - 1) {
                posPya++;
                binding.editRPeso.setText(formatPeso(historialPya.get(posPya)));
            }
        });
        binding.flechaSuenoAnterior.setOnClickListener(v -> {
            if (posHs > 0) {
                posHs--;
                binding.editHSuenio.setText(formatSueno(historialHs.get(posHs)));
            }
        });
        binding.flechaSuenoPosterior.setOnClickListener(v -> {
            if (posHs < historialHs.size() - 1) {
                posHs++;
                binding.editHSuenio.setText(formatSueno(historialHs.get(posHs)));
            }
        });

        // Botones de la barra de menú.
        binding.ButtonDietasEjercicios.setOnClickListener(v -> {
            Log.d("MainActivity", "LLENGO A DIETAS EJERCICIOS");
            openDietasEjercicios();
        });
        binding.ButtonModificarPerfil.setOnClickListener(v -> {
            openModificable();
        });
        binding.ButtonSueno.setOnClickListener(v -> {
            openSueno();
        });
        binding.ButtonHome.setOnClickListener(v -> {
            openHome();
        });
    }

    public void recogerDatosBD() {
        // Obtener objetos BD.
        AppDatabase bd = AppDatabase.getDatabase(getApplicationContext());
        PesoYAlturaDao pyaDao = bd.pyaDao();
        HorasSuenoDao hsDao = bd.hsDao();
        historialPya = (ArrayList<PesoYAltura>) pyaDao.getAll();
        historialHs = (ArrayList<HorasSueno>) hsDao.getAll();
        posPya = historialPya.size() - 1;
        posHs = historialHs.size() - 1;

        // Sacar datos del usuario.
//        System.out.println("Imprimiendo historialPya: ");
//        for (PesoYAltura pya : historialPya) {
//            LocalDateTime ldt = LocalDateTime.ofEpochSecond(pya.fecha, 0, zoffset);
//            System.out.println("pya: " + pya.altura + " " + pya.peso + " " + ldt.toString());
//        }
//        System.out.println("Imprimiendo historialHs: ");
//        for (HorasSueno hs : historialHs) {
//            LocalDateTime ldtInicio = LocalDateTime.ofEpochSecond(hs.momentoInicio, 0, zoffset);
//            LocalDateTime ldtFin = LocalDateTime.ofEpochSecond(hs.momentoFin, 0, zoffset);
//            System.out.println("hs: " + ldtInicio.toString() + " " + ldtFin.toString() + " " +
//                    TimeUnit.MILLISECONDS.toHours(hs.tiempoSueno) + ":"
//                    + TimeUnit.MILLISECONDS.toMinutes(hs.tiempoSueno) + ":"
//                    + TimeUnit.MILLISECONDS.toSeconds(hs.tiempoSueno));
//        }

        // Mostrar los datos en sus respectivos campos.
        binding.editRPeso.setText(formatPeso(historialPya.get(posPya)));
        binding.editHSuenio.setText(formatSueno(historialHs.get(posHs)));
    }

    public String formatPeso(PesoYAltura pya) {
        LocalDateTime ldtPya = pya.getFechaLDT(zoffset);
        return pya.peso + "kg, " + pya.altura + "m (" + ldtPya.getDayOfMonth() + "/"
                + ldtPya.getMonthValue() + "/" + ldtPya.getYear() + ", " + ldtPya.getHour() + ":"
                + ldtPya.getMinute() + ")";
    }

    public String formatSueno(HorasSueno hs) {
        LocalDateTime ldtHsInicio = hs.getInicioAsLDT(zoffset);
        LocalDateTime ldtHsFin = hs.getFinAsLDT(zoffset);
        long hours = TimeUnit.MILLISECONDS.toHours(hs.tiempoSueno);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(hs.tiempoSueno)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(hs.tiempoSueno));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(hs.tiempoSueno)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(hs.tiempoSueno));
        return hours + "h " + minutes + "min " + seconds + "s, inicio: "
                + ldtHsInicio.getHour() + ":" + ldtHsInicio.getMinute() + ", fin: "
                + ldtHsFin.getHour() + ":" + ldtHsFin.getMinute();
    }

    public void openModificable() {
        Intent intent = new Intent(this, Modificable.class);
        startActivity(intent);
    }

    public void openDietasEjercicios() {
        Intent intent = new Intent(this, DietasEjercicios.class);
        startActivity(intent);
    }

    public void openSueno() {
        Intent intent = new Intent(this, Mimir.class);
        startActivity(intent);
    }

    public void openHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}