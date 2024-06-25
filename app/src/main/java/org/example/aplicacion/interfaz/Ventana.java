package org.example.aplicacion.interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class Ventana extends JFrame{
    public Ventana(){
        JLabel fondoBlanco = new JLabel();
        fondoBlanco.setBackground(Color.white);
        fondoBlanco.setVisible(true);
        this.add(fondoBlanco);
        this.setSize(300,400);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Overrride
            public void mouseDragged(MouseEvent e) {
                e.
                // Obtener la ubicación actual del JFrame
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determinar el desplazamiento desde donde se presionó el mouse
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Mover el JFrame a la nueva ubicación
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });
    }
}
