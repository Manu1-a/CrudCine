package com.mycompany.a.proyectfinal.models;

/**
 *
 * @author gabdi
 */
public class Movie {

    private int idMovie;
    private String nameMovie;
    private String genderMovie;
    private String year;

    public Movie() {
    }

    public Movie(int idMovie, String nameMovie, String genderMovie, String year) {
        this.idMovie = idMovie;
        this.nameMovie = nameMovie;
        this.genderMovie = genderMovie;
        this.year = year;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getGenderMovie() {
        return genderMovie;
    }

    public void setGenderMovie(String genderMovie) {
        this.genderMovie = genderMovie;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
