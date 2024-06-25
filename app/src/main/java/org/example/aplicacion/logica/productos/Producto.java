package org.example.aplicacion.logica.productos;

import java.util.Optional;

public abstract class Producto {
    private Float precio;
    private String nombreComun;
    
    protected Producto(Float precio, String nombreComun)
        throws IllegalArgumentException    
    {
        setPrecio(precio);
        setNombreComun(nombreComun);
    }

    public Float getPrecio(){
        return precio;
    }

    public void setPrecio(Float precio)
        throws IllegalArgumentException
    {
        if (!Optional.ofNullable(precio).isPresent())
            throw new IllegalArgumentException("Valores nulos no permitidos!");
        if (precio <= 0)
            throw new IllegalArgumentException("Los valores deben ser números positivos.");
        
        this.precio = precio;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun)
        throws IllegalArgumentException
    {
        if (!Optional.ofNullable(nombreComun).isPresent())
            throw new IllegalArgumentException("No se aceptan cadena nuñas");
        if (nombreComun.trim().isEmpty())
            throw new IllegalArgumentException("No se admiten cadenas vacías");

        this.nombreComun = nombreComun;    
    }
}

