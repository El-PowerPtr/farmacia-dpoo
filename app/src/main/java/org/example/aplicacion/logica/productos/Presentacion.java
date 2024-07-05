package org.example.aplicacion.logica.productos;

public class Presentacion{
    private Formato formato;
    private int fortalezaMg;    
    
    public Presentacion(Formato formato, int fortalezaMg){
        this.setFortalezaMg(fortalezaMg);
        this.formato = formato;
    }

    public void setFortalezaMg(int fortalezaMg){
        Validador.validarNoNulo(fortalezaMg);
        Validador.validarMayorQueCero(fortalezaMg);

        this.fortalezaMg = fortalezaMg;
    }

    public enum Formato {
        PILDORA,
        CAPSULA,
        URGUENTO,
        JARABE,
        AEROSOL,
        POLVO,
        BIOSENSOR,
        INYECCION,
        ACEITE,
        MEDIDCINA_VERDE
    }
}