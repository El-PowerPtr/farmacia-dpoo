package org.example.aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import org.example.aplicacion.interfaz.RectanguloBonito;
import org.example.aplicacion.interfaz.Ventana;
import java.util.function.Function;
public class App {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        var rectangulo = new RectanguloBonito();

        ventana.fondoBlanco.add(rectangulo,BorderLayout.CENTER);
       
    }

}
