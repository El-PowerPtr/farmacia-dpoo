package org.example.aplicacion.logica.productos;

import java.time.LocalDate;

public abstract class MedicamentoEnVenta extends Producto {

    private Medicamento medicamento;
    private Presentacion presentacion;

    public MedicamentoEnVenta(double precio, String nombreComun, Medicamento medicamento, Presentacion presentacion) {
        super(precio, nombreComun);
        this.medicamento = medicamento;
        this.presentacion = presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        Validador.validarNoNulo(presentacion);
        this.presentacion = presentacion;
    }

    public void setMedicamento(Medicamento medicamento) {
        Validador.validarNoNulo(medicamento);
        this.medicamento = medicamento;
    }
}
