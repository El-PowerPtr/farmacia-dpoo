package org.example.aplicacion.logica.productos;

public abstract class Producto {
    private double precio;
    private String nombreComun;
    
    protected Producto(double precio, String nombreComun){
        setPrecio(precio);
        setNombreComun(nombreComun);
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        Validador.validarNoNulo(precio);
        Validador.validarPositivo(precio);        
        this.precio = precio;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun){
        Validador.validarNoNulo(nombreComun);
        Validador.validarNombresProductos(nombreComun);

        this.nombreComun = nombreComun;    
    }
     
}