package aplicacion.logica;

import java.util.Arrays;
import java.time.LocalDate;

public final class Validate {

    /**
     * Verifies that a person's identification number is valid or not
     * 
     * @param id the person's id
     */
    public static boolean isHumanId(long id) {
        return 01010100000L < id && id < 99999999999L;
    }

    /**
     * Verifies that a product's name is valid
     * 
     * @param name the product's name
     */
    public static boolean isThingName(String name) {
        return Arrays.stream(name.split("[\\s-]")) // separo todo usando espacios o guiones (-)
                .allMatch(part ->
                // no tiene espacios o guiones repetidos, así como tampoco espacios que toquen
                // guiones
                !part.trim().isEmpty()
                        // sólo tiene letras o números
                        && part.matches("[\\w\\dáéíóúñüÁÉÍÓÚÑÜ]+"));
    }

    /**
     * Verifies that a person's name is valid
     * 
     * @param name the person's name
     */
    public static boolean isHumanName(String name) {
        return Arrays.stream(name.split("[\\s]")) // divido la funcion por espacios
                .allMatch(part -> part.matches("[\\wáéíóúñüÁÉÍÓÚÑÜ]+")); // verifico si sólo hay letras
    }

    public static boolean isFuture(LocalDate date) {
        return date.compareTo(LocalDate.now()) > 0;
    }

    public static boolean isPast(LocalDate date) {
        return date.compareTo(LocalDate.now()) < 0;
    }

}
