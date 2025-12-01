package com.example.torneo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Pojo.producto; // CORREGIDO: Usa 'producto'
import Pojo.global.info;
import adaptadores.adaptadoreliminar;

public class MainActivity extends AppCompatActivity {
    EditText NomEqui, NomCap, Tel , HoraIns, TiempoIns, Pago;
    Button button, ButtonVer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        NomEqui = findViewById(R.id.NombreEquipo);
        NomCap = findViewById(R.id.NombreCapitan);
        Tel = findViewById(R.id.Telefono);
        HoraIns = findViewById(R.id.HoraInscripcion);
        TiempoIns = findViewById(R.id.TiempoInscripcion);
        Pago = findViewById(R.id.Pago);
        button = findViewById(R.id.button);
        ButtonVer = findViewById(R.id.ButtonVer);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                producto nuevoProducto = new producto(); // Usa 'producto'
                nuevoProducto.setNomProd(NomEqui.getText().toString());
                nuevoProducto.setDescripcion(NomCap.getText().toString());
                nuevoProducto.setPrecio(Tel.getText().toString());
                nuevoProducto.setCantidad(HoraIns.getText().toString());
                nuevoProducto.setCodigo(TiempoIns.getText().toString());
                nuevoProducto.setProveedor(Pago.getText().toString());

                info.lista.add(nuevoProducto);
                Toast.makeText(MainActivity.this, "Producto registrado: " + nuevoProducto.getNomProd(), Toast.LENGTH_SHORT).show();


            }
        });

        ButtonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verActivity = new Intent(MainActivity.this, ver.class);
                startActivity(verActivity);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.opc1){
            Intent eliminar=new Intent(this, Eliminar.class); // <-- Navega a Eliminar
            startActivity(eliminar);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}