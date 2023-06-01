package com.mycompany.a.proyectfinal.models;

/**
 *
 * @author gabdi
 */
public class Director {

    private int idDirector;
    private String nameDirector;

    public Director() {
    }
    
    public Director(int id_Director, String nameDirector) {
        this.idDirector = id_Director;
        this.nameDirector = nameDirector;

    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombreDirector() {
        return nameDirector;
    }

    public void setNombreDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }

}
