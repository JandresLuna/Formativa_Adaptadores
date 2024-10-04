package com.example.octubre4.clases;

public class Tarea {

    private String imagenTarea, nombreTarea, categoriaTarea, estadoTarea;

    public Tarea(String imagenTarea, String estadoTarea, String categoriaTarea, String nombreTarea) {
        this.imagenTarea = imagenTarea;
        this.estadoTarea = estadoTarea;
        this.categoriaTarea = categoriaTarea;
        this.nombreTarea = nombreTarea;
    }

    public String getImagenTarea() {
        return imagenTarea;
    }

    public void setImagenTarea(String imagenTarea) {
        this.imagenTarea = imagenTarea;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getCategoriaTarea() {
        return categoriaTarea;
    }

    public void setCategoriaTarea(String categoriaTarea) {
        this.categoriaTarea = categoriaTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
}

