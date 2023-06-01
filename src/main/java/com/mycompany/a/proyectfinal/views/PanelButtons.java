package com.mycompany.a.proyectfinal.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Manuel Silva
 */
public class PanelButtons extends JPanel {

    public final static String[] OPTIONS = {"Selecciona una opcion...", "Añadir Actor", "Añadir Director", "Añadir Pelicula"};

    private final ActionListener actionListener;
    private MyButton buttonSerch;
    private JTextField searchField;
    private MyButton buttonPDF;
    private JComboBox<String> comboBox;

    public PanelButtons(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        addSerch();
        addButtonPdf();
        addOptionRecord();
    }

    private void addSerch() {
        this.searchField = new JTextField(20);
        this.searchField.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        Document document = this.searchField.getDocument();

        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
                if (isNumeric(text)) {
                    super.insertString(fb, offset, text, attrs);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isNumeric(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isNumeric(String text) {
                return text.matches("\\d*");
            }
        };
        ((AbstractDocument) document).setDocumentFilter(filter);
        this.buttonSerch = new MyButton("Buscar");
        this.buttonSerch.setPreferredSize(new Dimension(200, 30));
        this.buttonSerch.setActionCommand("search");
        this.buttonSerch.addActionListener(this.actionListener);
        this.add(this.searchField);
        this.add(this.buttonSerch);
    }

    private void addButtonPdf() {
        this.buttonPDF = new MyButton("Generar PDF");
        this.buttonPDF.setPreferredSize(new Dimension(200, 30));
        this.buttonPDF.setActionCommand("pdf");
        this.buttonPDF.addActionListener(this.actionListener);
        this.add(this.buttonPDF);
    }

    private void addOptionRecord() {
        this.comboBox = new JComboBox<>(OPTIONS);

        this.comboBox.addActionListener(this.actionListener);
        this.comboBox.setPreferredSize(new Dimension(200, 30));
        this.add(this.comboBox);
    }
}
