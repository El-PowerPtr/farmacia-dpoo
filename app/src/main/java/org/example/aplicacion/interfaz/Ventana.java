package org.example.aplicacion.interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class Ventana extends JFrame{
    public Ventana(){
        //crea un fondo blanco
        JLabel fondoBlanco = new JLabel();
        fondoBlanco.setBackground(Color.white);
        fondoBlanco.setVisible(true);
        this.setLocationRelativeTo(null);
        this.add(fondoBlanco);
        this.setTitle("Farmacia Farmacéutica de Fármacos");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
