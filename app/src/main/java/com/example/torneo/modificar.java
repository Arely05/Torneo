package com.example.torneo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import Pojo.equipo;
import Pojo.global.info;

public class modificar extends AppCompatActivity {

    EditText EdtNombreEquipo, EdtNombreCapitan, EdtTelefono, EdtHora, EdtFecha, EdtPago;
    private int indiceActual = 0;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        // 1. Configurar el Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. Enlazar Vistas
        EdtNombreEquipo = findViewById(R.id.Mod_NombreEquipo);
        EdtNombreCapitan = findViewById(R.id.Mod_NombreCapitan);
        EdtTelefono = findViewById(R.id.Mod_Telefono);
        EdtHora = findViewById(R.id.Mod_HoraInscripcion);
        EdtFecha = findViewById(R.id.Mod_TiempoInscripcion);
        EdtPago = findViewById(R.id.Mod_Pago);

        if (!info.lista.isEmpty()) {
            mostrarEquipo(indiceActual);
        } else {
            Toast.makeText(this, "No Hay Equipos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_modificar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (info.lista.isEmpty()) return super.onOptionsItemSelected(item);

        int id = item.getItemId();

        if (id == R.id.action_siguiente) {
            indiceActual = (indiceActual + 1) % info.lista.size();
            mostrarEquipo(indiceActual);
            return true;
        } else if (id == R.id.action_anterior) {
            indiceActual = (indiceActual - 1 + info.lista.size()) % info.lista.size();
            mostrarEquipo(indiceActual);
            return true;
        } else if (id == R.id.action_guardar) {
            guardarCambios(indiceActual);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mostrarEquipo(int indice) {
        equipo equipoActual = info.lista.get(indice);
        EdtNombreEquipo.setText(equipoActual.getNomEqui());
        EdtNombreCapitan.setText(equipoActual.getNomCap());
        EdtTelefono.setText(equipoActual.getTel());
        EdtHora.setText(equipoActual.getHora());
        EdtFecha.setText(equipoActual.getFecha());
        EdtPago.setText(equipoActual.getPago());
    }

    private void guardarCambios(int indice) {
        equipo equipoActual = info.lista.get(indice);
        equipoActual.setNomEqui(EdtNombreEquipo.getText().toString());
        equipoActual.setNomCap(EdtNombreCapitan.getText().toString());
        equipoActual.setTel(EdtTelefono.getText().toString());
        equipoActual.setHora(EdtHora.getText().toString());
        equipoActual.setFecha(EdtFecha.getText().toString());
        equipoActual.setPago(EdtPago.getText().toString());

        Toast.makeText(this, "Guardado Correctamente: " + equipoActual.getNomEqui(), Toast.LENGTH_SHORT).show();
    }
}
