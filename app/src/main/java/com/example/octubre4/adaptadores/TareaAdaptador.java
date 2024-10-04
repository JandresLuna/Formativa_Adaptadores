package com.example.octubre4.adaptadores;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.octubre4.DetalleTarea;
import com.example.octubre4.R;
import com.example.octubre4.clases.Tarea;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TareaAdaptador extends RecyclerView.Adapter<TareaAdaptador.ViewHolder> {

    private List<Tarea> datos;

    public TareaAdaptador(List<Tarea> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public TareaAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaAdaptador.ViewHolder holder, int position) {
        Tarea dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nombre_tarea, text_categoria, text_estado;
        ImageView portada;
        Button btn_estado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Encontrar los elementos del XML por id
            txt_nombre_tarea = itemView.findViewById(R.id.txt_nombre_tarea);
            text_categoria = itemView.findViewById(R.id.text_categoria);
            text_estado = itemView.findViewById(R.id.text_estado);
            portada = itemView.findViewById(R.id.portada);
            btn_estado = itemView.findViewById(R.id.btn_estado);
        }

        public void bind(Tarea dato) {
            txt_nombre_tarea.setText(dato.getNombreTarea());
            text_categoria.setText(dato.getCategoriaTarea());
            text_estado.setText(dato.getEstadoTarea());

            // Cambiar el color del botón según el estado
            cambiarColorBotonSegunEstado(btn_estado, dato.getEstadoTarea());

            // Establecer la imagen de la tarea con Picasso
            Picasso.get().load(dato.getImagenTarea()).into(portada);

            // Al hacer clic en el item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    Gson gson = new Gson();
                    b.putString("tarea", gson.toJson(dato));

                    Intent i = new Intent(itemView.getContext(), DetalleTarea.class);
                    i.putExtras(b);

                    itemView.getContext().startActivity(i);
                }
            });
        }

        private void cambiarColorBotonSegunEstado(Button btn_estado, String estadoTarea) {
            int color;
            // Obtener el contexto del itemView
            View itemView = btn_estado.getRootView();
            switch (estadoTarea) {
                case "completada":
                    color = ContextCompat.getColor(itemView.getContext(), R.color.green);  // Color verde
                    break;
                case "pendiente":
                    color = ContextCompat.getColor(itemView.getContext(), R.color.red);    // Color rojo
                    break;
                case "en_progreso":
                    color = ContextCompat.getColor(itemView.getContext(), R.color.yellow); // Color amarillo
                    break;
                default:
                    color = ContextCompat.getColor(itemView.getContext(), R.color.gray);   // Color gris
                    break;
            }
            // Cambiar el color del botón
            btn_estado.setBackgroundTintList(ColorStateList.valueOf(color));
        }
    }
}
