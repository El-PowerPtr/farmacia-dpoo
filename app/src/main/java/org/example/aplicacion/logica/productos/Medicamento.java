package org.example.aplicacion.logica.productos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;


public class Medicamento {
    private String nombreCientifico;

    public Medicamento(String nombreCientifico) 
        throws IllegalArgumentException
    {
        setNombreCientifico(nombreCientifico);
    }

    // public void setId(int id)
    //     throws IllegalArgumentException 
    // {
    //     if (!Optional.ofNullable(id).isPresent())
    //         throw new IllegalArgumentException("No se permiten valores nulos!");

    //     if (id < 0)
    //         throw new IllegalArgumentException("Sólo números mayores que 1");
        
    //     this.id = id;
    // }

    public void setNombreCientifico(String nombreCientifico)
        throws IllegalArgumentException
    {
        if (!Optional.ofNullable(nombreCientifico).isPresent())
            throw new IllegalArgumentException("No se aceptan cadena nuñas");
        if (nombreCientifico.trim().isEmpty())
            throw new IllegalArgumentException("No se admiten cadenas vacías");

        this.nombreCientifico = nombreCientifico;    
    }

    

    // public int getId() {
    //     return id;
    // }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    
}
