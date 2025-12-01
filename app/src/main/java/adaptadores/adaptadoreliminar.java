package adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.torneo.R;

import Pojo.equipo;
import Pojo.global.info;

public class adaptadoreliminar extends RecyclerView.Adapter<adaptadoreliminar.Miniactivity> {

    private Context context;

    public adaptadoreliminar(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Miniactivity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.eli, parent, false);
        return new Miniactivity(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Miniactivity holder, int position) {
        final equipo equipoActual = info.lista.get(position);

        holder.checkBox.setText(equipoActual.getNomEqui());
        holder.checkBox.setChecked(info.listabaja.contains(equipoActual));

        holder.checkBox.setOnClickListener(v -> {
            CheckBox c = (CheckBox) v;
            if (c.isChecked()) {
                if (!info.listabaja.contains(equipoActual))
                    info.listabaja.add(equipoActual);
            } else {
                info.listabaja.remove(equipoActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return info.lista.size();
    }

    public static class Miniactivity extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public Miniactivity(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.CheckBox_Eliminar);
        }
    }

    public class ver {
    }
}
