package com.example.isaac.recum8uf1;

public class TallerModel {
    private String valoraciones;
    private String comentarios;

    public TallerModel(){
    }

    public TallerModel(String valoraciones, String comentarios) {
        this.valoraciones = valoraciones;
        this.comentarios = comentarios;
    }

    public String getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(String valoraciones) {
        this.valoraciones = valoraciones;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
