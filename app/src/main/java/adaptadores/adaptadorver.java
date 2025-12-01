package adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torneo.R;
import com.example.torneo.Card;

import Pojo.global.info;


public class adaptadorver extends RecyclerView.Adapter<adaptadorver.Miniactivity> {
    public Context context;
    @NonNull
    @Override
    public Miniactivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=View.inflate(context,R.layout.milista,null);
        Miniactivity obj=new Miniactivity(v);
        return (obj);
    }

    @Override
    public void onBindViewHolder(@NonNull Miniactivity miact, int i) {
        final int pos=i;
        miact.NombreEq.setText(info.lista.get(i).getNomEqui());
        miact.NombreCap.setText(info.lista.get(i).getNomCap());
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
        return 0;
    }

    public class Miniactivity extends RecyclerView.ViewHolder{
        TextView NombreEq,NombreCap;
        public Miniactivity(@NonNull View itemView) {
            super(itemView);
            NombreEq=itemView.findViewById(R.id.NombreEquipo);
            NombreCap=itemView.findViewById(R.id.NombreCapitan);

        }
    }
}