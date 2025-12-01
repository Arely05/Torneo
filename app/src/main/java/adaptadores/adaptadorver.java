package adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torneo.R;
import com.example.torneo.Card;

import Pojo.global.info;
import Pojo.producto; // CORREGIDO: Importa 'producto'


public class adaptadorver extends RecyclerView.Adapter<adaptadorver.Miniactivity> {
    public Context context;

    public adaptadorver(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Miniactivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.milista, parent, false);
        Miniactivity obj = new Miniactivity(v);
        return (obj);
    }

    @Override
    public void onBindViewHolder(@NonNull Miniactivity miact, int i) {
        final int pos=i;
        producto productoActual = info.lista.get(i); // Usa 'producto'

        miact.NombreEq.setText(productoActual.getNomProd());
        miact.NombreCap.setText(productoActual.getDescripcion());

        miact.NombreCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card = new Intent(context, Card.class);
                card.putExtra("posicion",pos);
                context.startActivity(card);

            }
        });
    }

    @Override
    public int getItemCount() {
        return info.lista.size();
    }

    public class Miniactivity extends RecyclerView.ViewHolder{
        TextView NombreEq,NombreCap;
        public Miniactivity(@NonNull View itemView) {
            super(itemView);
            NombreEq=itemView.findViewById(R.id.ListaEqui);
            NombreCap=itemView.findViewById(R.id.ListaCapi);

        }
    }
}