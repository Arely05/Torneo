package com.example.torneo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Pojo.equipo;
import adaptadores.adaptadoreliminar;
import Pojo.global.info;

public class MainActivity extends AppCompatActivity {
    EditText NomEqui, NomCap, Tel , HoraIns, TiempoIns, Pago;
    Button button;
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

        toolbar=findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equipo unequipo = new equipo();
                unequipo.setNomEqui(NomEqui.getText().toString());
                unequipo.setNomCap(NomCap.getText().toString());
                unequipo.setTel(Tel.getText().toString());
                unequipo.setHora(HoraIns.getText().toString());
                unequipo.setFecha(TiempoIns.getText().toString());
                unequipo.setPago(Pago.getText().toString());

                info.lista.add(unequipo);


            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.opc1){
            Intent ver=new Intent(this, adaptadoreliminar.ver.class);
            startActivity(ver);
        }
        return super.onOptionsItemSelected(item);
    }
}