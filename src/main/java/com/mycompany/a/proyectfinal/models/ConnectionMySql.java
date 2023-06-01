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
    
    public void insertMovie(Movie movie) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement("INSERT INTO pelicula (id_pelicula,titulo, genero, anio) VALUES (?, ?, ?, ?)");
        ps.setInt(1, movie.getIdMovie());
        ps.setString(2, movie.getNameMovie());
        ps.setString(3, movie.getGenderMovie());
        ps.setString(4, movie.getAnio());
        ps.executeUpdate();
    }

    public void insertActor(Actor actor) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement("INSERT INTO actor (id_actor, nombre) VALUES (?, ?)");
        ps.setInt(1, actor.getIdActor());
        ps.setString(2, actor.getNameActor());
        ps.executeUpdate();
    }

    public void insertDirector(Director director) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement("INSERT INTO director (id_director, nombre) VALUES (?, ?)");
        ps.setInt(1, director.getIdDirector());
        ps.setString(2, director.getNombreDirector());
        ps.executeUpdate();
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
            movie.setAnio(resultSet.getString("Anio"));
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
    
     public ArrayList<Movie> serchIdMovies(int num) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM peliculas WHERE id_pelicula LIKE ?");
        statement.setString(1, num + "%");
        ResultSet resultSet = statement.executeQuery();
        Movie movie;
        while (resultSet.next()) {
            movie = new Movie(resultSet.getInt("id_pelicula"), resultSet.getString("titulo"), resultSet.getString("genero"),resultSet.getString("anio"));
            movies.add(movie);
        }
        return movies;
    }

    public ArrayList<Actor> serchIdActors(int num) throws SQLException {
        ArrayList<Actor> actors = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM actores WHERE id_actor LIKE ?");
        statement.setString(1, num + "%");
        ResultSet resultSet = statement.executeQuery();
        Actor actor;
        while (resultSet.next()) {
            actor = new Actor(resultSet.getInt("id_actor"), resultSet.getString("nombre"));
            actors.add(actor);
        }

        return actors;
    }

    public ArrayList<Director> serchIdDirector(int num) throws SQLException {
        ArrayList<Director> directors = new ArrayList<>();
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM directores WHERE id_director LIKE ?");
        statement.setString(1, num + "%");
        ResultSet resultSet = statement.executeQuery();
        Director director;
        while (resultSet.next()) {
            director = new Director(resultSet.getInt("id_director"), resultSet.getString("nombre"));
            directors.add(director);
        }

        return directors;
    }

    public boolean delete(String table, String nameId, int id) throws SQLException {
        PreparedStatement statement = statement = connection.prepareStatement("DELETE FROM " + table + " WHERE " + nameId + " = ?");
        statement.setInt(1, id);
        int filasAfectadas = statement.executeUpdate();

        return filasAfectadas > 0;
    }

    public boolean update(int option, int id, String newInfo) throws SQLException {
        String[] info = newInfo.split(";");
        System.out.println(info[0] + "-" + info[1]);
            PreparedStatement statement = null;
            switch (option) {
                case 0 -> {
                    statement = connection.prepareStatement("UPDATE peliculas SET titulo = ?, genero = ?, anio = ? WHERE id_pelicula = ?");
                    statement.setString(1, info[0]);
                    statement.setString(2, info[1]);
                    statement.setString(3, info[2]);
                    statement.setInt(4, id);
                }
                case 1 -> {
                    statement = connection.prepareStatement("UPDATE actores SET nombre = ? WHERE id_actor = ?");
                    statement.setString(1, info[0]);
                    statement.setInt(2, id);
                }
                case 2 -> {
                    statement = connection.prepareStatement("UPDATE directores SET nombre = ? WHERE id_director = ?");
                    statement.setString(1, info[0]);
                    statement.setInt(2, id);
                }
            }
            int filasAfectadas = statement.executeUpdate();

            return (filasAfectadas > 0);
    }
}
