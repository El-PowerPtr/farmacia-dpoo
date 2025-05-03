package aplicacion.logica;

import java.util.Arrays;
import java.util.Optional;
import java.time.LocalDate;

public final class Validate{

    public static void isNotEmpty(boolean value){
        if(!Optional.ofNullable(value).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }
    
    public static void isNotEmpty(double value){
        if(!Optional.ofNullable(value).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }

    public static void isNotEmpty(int value){
        if(!Optional.ofNullable(value).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }

    public static void isNotEmpty(long value){
        if(!Optional.ofNullable(value).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }

    public static void isNotEmpty(String value){
        if(!Optional.ofNullable(value).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");

        if(value.trim().isEmpty())
            throw new IllegalArgumentException("No se permiten cadenas vacías!");
    }
    
    public static void isNotEmpty(Object value){
        if (!Optional.ofNullable(value).isPresent())
            throw new IllegalArgumentException("No se permiten valores nulos!");
    }


    public static void isPositiveNumber(int value){
        if(value < 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que 0!");
    }

    public static void isPositiveNumber(long value){
        if(value < 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que 0!");
    }

    public static void isPositiveNumber(double value){
        if(value < 0)
            throw new IllegalArgumentException("Los valores deben ser mayores que 0!");
    }

    public static void isGreaterThanZero(int value){
        if(value <= 0)
            throw new IllegalArgumentException("Los valores deben ser números naturales!");
    }

    public static void isGreaterThanZero(long value){
        if(value <= 0)
            throw new IllegalArgumentException("Los valores deben ser números naturales!");
    }

    public static void isGreaterThanZero(double value){
        if(value <= 0)
            throw new IllegalArgumentException("Los valores deben ser números naturales!");
    }

    
    /**
     * Verifies that a person's identification number is valid or not
     * 
     * @param id the person's id
     * @throws IllegalArgumentException The id is not a valid one
     */
    public static void isHumanId(long id){
        if (id < 01010100000L && id > 99999999999L)
            throw new IllegalArgumentException("Carnet de identidad inválido!");
    }

    public static void isThingName(String name){
        if(!Arrays.stream(name.split("[\\s-]"))                       // separo todo usando espacios o guiones (-)
                    .allMatch(part -> 
                        !part.trim().isEmpty()                             //no tiene espacios o guiones repetidos, así como tampoco espacios que toquen guiones
                        && part.matches("[\\w\\dáéíóúñüÁÉÍÓÚÑÜ]+")))   // sólo tiene letras o números
            throw new IllegalArgumentException("El nombre proveído es incorrecto, sólo se permiten caraceteres alfanuméricos, espacios o el guión (-)\n Nombre proporcionado:" + name + "\n");
    }

    public static void isHumanName(String name){
        if(!Arrays.stream(name.split("[\\s]")) //divido la funcion por espacios
                        .allMatch(part -> 
                            part.matches("[\\wáéíóúñüÁÉÍÓÚÑÜ]+"))) //verifico si sólo hay letras
            throw new IllegalArgumentException("El nombre proveído es incorrecto, sólo se permiten caracteres de alfabeto español o espacios\n Nombre proporcionado:" + name + "\n");
    }

    public static void isFuture(LocalDate date){
        if (date.compareTo(LocalDate.now()) < 0)
            throw new IllegalArgumentException("una fecha de vencimiento no debe estar en tiempo pasado, de ser así debería desecharse el lote");
    }

    public static void isPast(LocalDate date){
        if (date.compareTo(LocalDate.now()) > 0)
            throw new IllegalArgumentException("una fecha de vencimiento no debe estar en tiempo futuro, en Cuba no hay máquinas del tiempo!");
    }

    
}