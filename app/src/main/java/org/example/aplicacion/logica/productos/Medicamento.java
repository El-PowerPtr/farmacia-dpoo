package org.example.aplicacion.logica.productos;


public class Medicamento {
    private String nombreCientifico;
    private int id;

    public Medicamento(String nombreCientifico) 
        throws IllegalArgumentException
    {
        setNombreCientifico(nombreCientifico);
    }

    public void setId(int id)
        throws IllegalArgumentException 
    {
        Validador.validarNoNulo(id);
        Validador.validarMayorQueCero(id);
        this.id = id;
    }

    public void setNombreCientifico(String nombreCientifico)
        throws IllegalArgumentException
    {
        //si ponen espacios al principio o al final los quito
        String nombreArreglado = nombreCientifico.trim();   
        //valido si la cadena no es nula y rel formato es correcto
        Validador.validarNoNulo(nombreArreglado);
        Validador.validarNombresProductos(nombreArreglado);

        this.nombreCientifico = nombreArreglado;    
    }

    public int getId() {
        return id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    
}
