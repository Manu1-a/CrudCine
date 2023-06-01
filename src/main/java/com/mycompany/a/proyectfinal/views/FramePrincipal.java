package com.mycompany.a.proyectfinal.views;

import com.mycompany.a.proyectfinal.models.Actor;
import com.mycompany.a.proyectfinal.models.Director;
import com.mycompany.a.proyectfinal.models.Movie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Manuel Silva
 */
public class FramePrincipal extends JFrame {

    private final ActionListener actionListener;
    private JPanel contentPane;
    private JPanel panelTitle;
    private JTabbedPane tabbedPane;
    private PanelButtons panelButtons;
    private PanelActor panelActor;
    private PanelDirector panelDirector;
    private PanelMovie panelMovie;
    

    public FramePrincipal(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1000, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        addContentPane();
        addPanelTitle();
        addTabbedPane();
        addPanelButtons();
        this.pack();
    }
    
    private void addContentPane() {
        this.contentPane = new JPanel();
        this.contentPane.setBackground(Color.WHITE);
        this.contentPane.setPreferredSize(this.getSize());
        this.contentPane.setLayout(new BorderLayout());

        this.getContentPane().add(this.contentPane, BorderLayout.CENTER);
    }

    private void addPanelTitle() {
        this.panelTitle = new JPanel();
        this.panelTitle.setBackground(Color.WHITE);
        this.panelTitle.add(jLabelTitle());

        this.contentPane.add(this.panelTitle, BorderLayout.NORTH);
    }

    private JLabel jLabelTitle() {
        JLabel label = new JLabel("SISTEMA DE CINE");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        return label;
    }

    private void initPanels() {
        this.panelMovie = new PanelMovie(this.actionListener);
        this.panelActor = new PanelActor(this.actionListener);
        this.panelDirector = new PanelDirector(this.actionListener);
    }
    
    private void addTabbedPane() {
        this.tabbedPane = new JTabbedPane();
        this.tabbedPane.setBackground(Color.WHITE);
        this.tabbedPane.setFont(new Font("Arial", Font.PLAIN, 16));

        UIManager.put("TabbedPane.tabAreaBackground", Color.WHITE);
        UIManager.put("TabbedPane.contentAreaColor", Color.WHITE);

        initPanels();
        this.tabbedPane.addTab("PELICULAS", this.panelMovie);
        this.tabbedPane.addTab("ACTORES", this.panelActor);
        this.tabbedPane.addTab("DIRECTORES", this.panelDirector);

        this.contentPane.add(this.tabbedPane, BorderLayout.CENTER);
    }
    
    private void addPanelButtons() {
        this.panelButtons = new PanelButtons(this.actionListener);
        this.panelButtons.setBackground(Color.WHITE);
        this.panelButtons.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));

        this.contentPane.add(this.panelButtons, BorderLayout.SOUTH);
    }
    
    public void cleanTables() {
        this.panelMovie.clean();
        this.panelActor.clean();
        this.panelDirector.clean();
    }
    
    public void fillTables(ArrayList<Movie> movies, ArrayList<Actor> actors, ArrayList<Director> directors) {
        this.panelMovie.loadData(movies);
        this.panelActor.loadData(actors);
        this.panelDirector.loadData(directors);
    }
}
