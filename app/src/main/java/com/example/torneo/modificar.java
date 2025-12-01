package com.example.torneo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import Pojo.producto; // Usa 'producto'
import Pojo.global.info;

public class modificar extends AppCompatActivity {

    EditText EdtNombreEquipo, EdtNombreCapitan, EdtTelefono, EdtHora, EdtFecha, EdtPago;
    Button ButtonAnterior, ButtonGuardar, ButtonSiguiente;
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

        // Enlazar botones del layout (CORREGIDO)
        ButtonAnterior = findViewById(R.id.Button_Anterior);
        ButtonGuardar = findViewById(R.id.Button_Guardar);
        ButtonSiguiente = findViewById(R.id.Button_Siguiente);


        if (!info.lista.isEmpty()) {
            mostrarEquipo(indiceActual);
        } else {
            Toast.makeText(this, "No Hay Productos Registrados", Toast.LENGTH_SHORT).show();
        }

        // 3. Configurar Listeners para los botones (CORREGIDO)
        ButtonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.lista.isEmpty()) return;
                indiceActual = (indiceActual + 1) % info.lista.size();
                mostrarEquipo(indiceActual);
            }
        });

        ButtonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.lista.isEmpty()) return;
                indiceActual = (indiceActual - 1 + info.lista.size()) % info.lista.size();
                mostrarEquipo(indiceActual);
            }
        });

        ButtonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.lista.isEmpty()) return;
                guardarCambios(indiceActual);
            }
        });
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

        // El menú de Toolbar también maneja la navegación, por eso se mantiene
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
        producto productoActual = info.lista.get(indice);
        // Uso de nuevos getters
        EdtNombreEquipo.setText(productoActual.getNomProd());
        EdtNombreCapitan.setText(productoActual.getDescripcion());
        EdtTelefono.setText(productoActual.getPrecio());
        EdtHora.setText(productoActual.getCantidad());
        EdtFecha.setText(productoActual.getCodigo());
        EdtPago.setText(productoActual.getProveedor());
    }

    private void guardarCambios(int indice) {
        producto productoActual = info.lista.get(indice);
        // Uso de nuevos setters
        productoActual.setNomProd(EdtNombreEquipo.getText().toString());
        productoActual.setDescripcion(EdtNombreCapitan.getText().toString());
        productoActual.setPrecio(EdtTelefono.getText().toString());
        productoActual.setCantidad(EdtHora.getText().toString());
        productoActual.setCodigo(EdtFecha.getText().toString());
        productoActual.setProveedor(EdtPago.getText().toString());

        Toast.makeText(this, "Modificación Guardada: " + productoActual.getNomProd(), Toast.LENGTH_SHORT).show();
    }
}