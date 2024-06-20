package org.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Medicamento implements Serializable {
    int id;
    String nombreCientifico;
    ArrayList<String> nombreComun;
    ArrayList<String> usos;
    ArrayList<String> contraindicaciones;
    
}
