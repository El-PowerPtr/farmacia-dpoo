package aplicacion.interfaz;

import javax.swing.JFrame;
import aplicacion.interfaz.ToolBar;
import javax.swing.JPanel;

public class Window extends JFrame{
    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JPanel());
        setJMenuBar(new ToolBar()); 
        setSize(400,400);
        setVisible(true);
    }
    
}
