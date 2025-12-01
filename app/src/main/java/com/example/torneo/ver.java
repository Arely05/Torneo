package com.example.torneo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import adaptadores.adaptadorver;

public class ver extends AppCompatActivity {
    RecyclerView r;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // NOTA: Se asume que has corregido activity_ver.xml para contener el RecyclerView
        setContentView(R.layout.activity_ver);

        r = findViewById(R.id.Rec);

        // CORRECCIÓN: Llamada al constructor que recibe el contexto.
        adaptadorver av = new adaptadorver(this);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        r.setAdapter(av);
        r.setLayoutManager(llm);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}