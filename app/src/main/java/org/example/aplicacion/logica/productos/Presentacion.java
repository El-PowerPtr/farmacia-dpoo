package org.example.aplicacion.logica.productos;


@SuppressWarnings("unused")
public class Presentacion{
    private Formato formato;
    private int fortalezaMg;    
    
    public Presentacion(Formato formato, int fortalezaMg){
        this.setFortalezaMg(fortalezaMg);
        this.formato = formato;
    }
    
    public int getFortalezaMg() {
        return fortalezaMg;
    }


    public void setFortalezaMg(int fortalezaMg){
        Validador.validarNoNulo(fortalezaMg);
        Validador.validarMayorQueCero(fortalezaMg);

        this.fortalezaMg = fortalezaMg;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        Validador.validarNoNulo(formato);
        this.formato = formato;
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