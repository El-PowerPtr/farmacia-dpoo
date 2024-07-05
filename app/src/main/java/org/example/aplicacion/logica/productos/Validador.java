package org.example.aplicacion.logica.productos;

import java.util.Arrays;
import java.util.Optional;
import java.time.LocalDate;

public final class Validador{
    public static void validarNoNulo(double valor){
        if(!Optional.ofNullable(valor).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }
    public static void validarNoNulo(int valor){
        if(!Optional.ofNullable(valor).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }
    public static void validarNoNulo(String valor){
        if(!Optional.ofNullable(valor).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");

        if(valor.trim().isEmpty())
            throw new IllegalArgumentException("No se permiten cadenas vacías!");
    }
    
    public static void validarNoNulo(Object valor){
        if (!Optional.ofNullable(valor).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }

    public static void validarPositivo(int valor){
        if(valor <= 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que 0!");
    }

    public static void validarPositivo(double valor){
        if(valor <= 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que 0!");
    }

    public static void validarMayorQueCero(int valor){
        if(valor < 0)
            throw new IllegalArgumentException("Los valores deben ser números naturales!");
    }

    public static void validarMayorQueCero(double valor){
        if(valor < 0)
            throw new IllegalArgumentException("Los valores deben ser números naturales!");
    }

    public static void validarNombresProductos(String nombre){
        if(!Arrays.stream(nombre.split("[\\s-]"))                       // separo todo usando espacios o guiones (-)
                    .allMatch(parte -> 
                        !parte.trim().isEmpty()                             //no tiene espacios o guiones repetidos, así como tampoco espacios que toquen guiones
                        && parte.matches("[\\w\\dáéíóúñüÁÉÍÓÚÑÜ]+")))   // sólo tiene letras o números
            throw new IllegalArgumentException("El nombre proveído es incorrecto, sólo se permiten caraceteres alfanuméricos, espacios o el guión (-)\n Nombre proporcionado:" + nombre + "\n");
    }

    public static void validarNombresPersonas(String nombre){
        if(!Arrays.stream(nombre.split("[\\s]")) //divido la funcion por espacios
                        .allMatch(parte -> 
                            parte.matches("[\\wáéíóúñüÁÉÍÓÚÑÜ]+"))) //verifico si sólo hay letras
            throw new IllegalArgumentException("El nombre proveído es incorrecto, sólo se permiten caracteres de alfabeto español o espacios\n Nombre proporcionado:" + nombre + "\n");
    }

    public void validarFechaFutura(LocalDate fecha){
        if (fecha.compareTo(LocalDate.now()) < 0)
            throw new IllegalArgumentException("una fecha de vencimiento no debe estar en tiempo pasado, de ser así debería desecharse el lote");
    }
}