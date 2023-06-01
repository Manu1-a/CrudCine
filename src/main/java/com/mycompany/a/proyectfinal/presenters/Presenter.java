package com.mycompany.a.proyectfinal.presenters;

import com.mycompany.a.proyectfinal.models.ConnectionMySql;
import com.mycompany.a.proyectfinal.views.FramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Silva
 */
public class Presenter implements ActionListener {

    private FramePrincipal framePrincipal;
    private ConnectionMySql connection;

    public Presenter() {
        init();
    }
    
    private void init() {
        try {
            this.connection = new ConnectionMySql();
            this.framePrincipal = new FramePrincipal(this);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡La Base de Datos no esta Conectada!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void fillTable() {
        try {
            this.framePrincipal.cleanTables();
            this.framePrincipal.fillTables(this.connection.getMovies(), this.connection.getActors(), this.connection.getDirectors());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Error al llenar las tablas!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
