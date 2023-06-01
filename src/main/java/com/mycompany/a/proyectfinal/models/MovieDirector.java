package com.mycompany.a.proyectfinal.models;

/**
 *
 * @author gabdi
 */
public class MovieDirector {
    
    private int idMovie;
    private int idDirector;

    public MovieDirector(int idMovie, int idDirector) {
        this.idMovie = idMovie;
        this.idDirector = idDirector;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }
}
