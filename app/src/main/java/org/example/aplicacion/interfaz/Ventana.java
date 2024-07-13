package org.example.aplicacion.interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

public class Ventana extends JFrame{
    public final JPanel fondoBlanco;

    public Ventana(){
        super();
        //crea un fondo blanco
        this.fondoBlanco = new JPanel();
        fondoBlanco.setBackground(Color.white);
        fondoBlanco.setVisible(true);
        
        this.setSize(480,480);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(fondoBlanco, BorderLayout.CENTER);
        this.setTitle("Farmacia Farmacéutica de Fármacos");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
