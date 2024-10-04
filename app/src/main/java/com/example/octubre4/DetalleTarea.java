package com.example.octubre4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.octubre4.clases.Tarea;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetalleTarea extends AppCompatActivity {

    TextView txt_nombre_tarea_detalle, text_categoria_detalle, text_estado_detalle;
    ImageView portada_detalle;
    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tarea);


        txt_nombre_tarea_detalle = findViewById(R.id.txt_nombre_tarea_detalle);
        text_categoria_detalle = findViewById(R.id.text_categoria_detalle);
        text_estado_detalle = findViewById(R.id.text_estado_detalle);
        portada_detalle = findViewById(R.id.portada_detalle);
        btn_volver = findViewById(R.id.btn_volver);

        Bundle b = getIntent().getExtras();
        Gson gson = new Gson();
        Tarea tarea = gson.fromJson(b.getString("tarea"), Tarea.class);


        txt_nombre_tarea_detalle.setText(tarea.getNombreTarea());
        text_categoria_detalle.setText(tarea.getCategoriaTarea());
        text_estado_detalle.setText(tarea.getEstadoTarea());

        Picasso.get().load(tarea.getImagenTarea()).into(portada_detalle);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetalleTarea.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}