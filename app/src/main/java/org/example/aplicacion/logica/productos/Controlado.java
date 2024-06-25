package org.example.aplicacion.logica.productos;

public interface Controlado<T> {
    int decidirCantidad(T permiso);
    boolean validarPermiso(T permiso);
} 
