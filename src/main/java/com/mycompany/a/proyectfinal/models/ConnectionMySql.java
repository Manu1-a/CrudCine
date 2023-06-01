package com.mycompany.a.proyectfinal.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manuel Silva
 */
public class ConnectionMySql {

    public static final String URL = "jdbc:mysql://localhost:3306/proyectobd";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    private Connection connection;

    public ConnectionMySql() {
    }

    public void initConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public ArrayList<Movie> getMovies() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM pelicula");;
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setIdMovie(resultSet.getInt("id_pelicula"));
            movie.setNameMovie(resultSet.getString("titulo"));
            movie.setGenderMovie(resultSet.getString("genero"));
            movies.add(movie);
        }
        return movies;
    }
    
    public ArrayList<Director> getDirectors() throws SQLException {
        ArrayList<Director> directors = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM director");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Director director = new Director();
            director.setIdDirector(resultSet.getInt("id_director"));
            director.setNombreDirector(resultSet.getString("nombre"));
            directors.add(director);
        }
        return directors;
    }
    
    public ArrayList<Actor> getActors() throws SQLException {
        ArrayList<Actor> actors = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM actor");
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {            
            Actor actor = new Actor();
            actor.setIdActor(resultSet.getInt(resultSet.findColumn("id_actor")));
            actor.setNameActor(resultSet.getString("nombre"));
        }
        return actors;
    }
    
    public ArrayList<MovieActor> getMovieActors() throws SQLException {
        ArrayList<MovieActor> movieActors = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM pelicula_actor");
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {            
            MovieActor movieActor = new MovieActor();
            movieActor.setIdActor(resultSet.getInt(resultSet.findColumn("id_pelicula")));
            movieActor.setIdMovie(resultSet.getInt(resultSet.findColumn("id_actor")));
        }
        return movieActors;
    }
    
    public ArrayList<MovieDirector> getMovieDirectors() throws SQLException {
        ArrayList<MovieDirector> movieDirectors = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM pelicula_director");
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {            
            MovieActor movieActor = new MovieActor();
            movieActor.setIdActor(resultSet.getInt(resultSet.findColumn("id_pelicula")));
            movieActor.setIdMovie(resultSet.getInt(resultSet.findColumn("id_director")));
        }
        return movieDirectors;
    }
}
