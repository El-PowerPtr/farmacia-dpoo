package aplicacion.logica.products;

import aplicacion.logica.Validate;
import aplicacion.logica.products.Product;
import java.io.Serializable;

public class Medicine extends Product {
    private String scientificName;
    private int strenghtMg;
    private int tempAlmacenamiento;
    private Presentation presentation;

    public Medicine(long id, String commonName, double price, ControlType controlType,
            String scientificName, int strenghtMg, int tempAlmacenamiento) {
        super(id, commonName, price, controlType);
        setScientificName(scientificName);
        setStrenghtMg(strenghtMg);
        setTempAlmacenamiento(tempAlmacenamiento);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setScientificName(String scientificName) {
        if(!Validate.isThingName(scientificName)) {
            throw new IllegalArgumentException("Formato de nombre inválido, por favor use sólo caracteres alfanuméricos. Nombre: " + scientificName);
        }
        this.scientificName = scientificName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public int getStrenghtMg() {
        return strenghtMg;
    }

    public void setStrenghtMg(int strenghtMg) {
        if(strenghtMg <= 0) {
            throw new IllegalArgumentException("La fortaleza en miligramos debe ser un número natural positivo");
        }
        this.strenghtMg = strenghtMg;
    }

    public int getTempAlmacenamiento() {
        return tempAlmacenamiento;
    }

    public void setTempAlmacenamiento(int tempAlmacenamiento) {
        this.tempAlmacenamiento = tempAlmacenamiento;
    }

    public boolean sameMedicine(Medicine other) {
        return this.commonName.equals(other.commonName) 
                || this.scientificName.equals(other.scientificName)
                && (this.presentation != other.presentation
                    || this.strenghtMg != other.strenghtMg);
                
    }
}
