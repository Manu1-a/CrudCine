package com.mycompany.a.proyectfinal.models;

/**
 *
 * @author gabdi
 */
public class Actor {

    private int idActor;
    private String nameActor;

    public Actor() {
    }

    public Actor(int id_actor, String nameActor) {
        this.idActor = id_actor;
        this.nameActor = nameActor;

    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }
}
