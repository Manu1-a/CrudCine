package com.mycompany.a.proyectfinal.models;

/**
 *
 * @author gabdi
 */
public class MovieActor {

    private int idMovie;
    private int idActor;

    public MovieActor() {
    }

    public MovieActor(int idMovie, int idActor) {
        this.idMovie = idMovie;
        this.idActor = idActor;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }
}
