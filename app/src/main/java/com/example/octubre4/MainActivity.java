package com.example.octubre4;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.octubre4.adaptadores.TareaAdaptador;
import com.example.octubre4.clases.Tarea;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button btn_estado;
    RecyclerView rcv_tarea;
    List<Tarea> listaTareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_tarea = findViewById(R.id.rcv_tarea);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv_tarea.setLayoutManager(gridLayoutManager);

        Tarea t1 = new Tarea("https://i.ibb.co/Y3G8jHW/1-removebg-preview.png", "completada","matematicas","Formativa 1");
        Tarea t2 = new Tarea("https://i.ibb.co/VMLrxWK/2-removebg-preview.png", "en_progreso","informatica","Formativa 2");
        Tarea t3 = new Tarea("https://i.ibb.co/58bkZWX/3-removebg-preview.png", "completada","trabajo","Reunion de trabajo");
        Tarea t4 = new Tarea("https://i.ibb.co/g3z9VHR/4-removebg-preview.png", "pendiente","familia","Cumpleaños");
        Tarea t5 = new Tarea("https://i.ibb.co/ftHG5Wb/5-removebg-preview.png", "completada","deporte","Partido del domingo");
        Tarea t6 = new Tarea("https://i.ibb.co/Y3G8jHW/1-removebg-preview.png", "en_progreso","matematicas","Estudiar");
        Tarea t7 = new Tarea("https://i.ibb.co/58bkZWX/3-removebg-preview.png", "pendiente","trabajo","Presentación");
        Tarea t8 = new Tarea("https://i.ibb.co/VMLrxWK/2-removebg-preview.png", "sin estado","informatica","Porgramar en Kotlin");


        listaTareas.add(t1);
        listaTareas.add(t2);
        listaTareas.add(t3);
        listaTareas.add(t4);
        listaTareas.add(t5);
        listaTareas.add(t6);
        listaTareas.add(t7);
        listaTareas.add(t8);

        rcv_tarea.setAdapter(new TareaAdaptador(listaTareas));


    }
}