package aplicacion.interfaz;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ToolBar extends JMenuBar{
    public ToolBar(){
        //creo los meúns y les asigno los items a cada uno
        JMenu files = new JMenu("Archivos");

        JMenuItem importFile = new JMenuItem("Importar");
        files.add(importFile);
        JMenu exportFile = new JMenu("Exportar");
        files.add(exportFile);

        JMenu registers = new JMenu ("Registros");
        JMenuItem create = new JMenuItem("Crear");
        registers.add(create);
        JMenuItem delete = new JMenuItem ("Eliminar");
        registers.add(delete);

        JMenu config = new JMenu("Configuration");

        JMenu help = new JMenu("Ayuda");

        add(files);
        add(registers);
        add(config);
        add(help);
    }
}