package org.example.aplicacion.logica.products;

@SuppressWarnings("unused")
public class Presentation extends Product {

    private Medicine medicine;
    private Format format;
    private int strengthMg;

    public Presentation(double price, String commonName,long id, Medicine medicine, Format format, int strengthMg) {
        super(price, commonName, id);
        setMedicine(medicine);
        setFormat(format);
        setStrengthMg(strengthMg);
    }

    public void setMedicine(Medicine medicine) {
        Validate.isNotEmpty(medicine);
        this.medicine = medicine;
    }

    public int getStrengthMg() {
        return strengthMg;
    }

    public void setStrengthMg(int strengthMg){
        Validate.isNotEmpty(strengthMg);
        Validate.isGreaterThanZero(strengthMg);

        this.strengthMg = strengthMg;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        Validate.isNotEmpty(format);
        this.format = format;
    }

    public Object getMedicine() {
        return medicine;
    }

    public enum Format {
        PILL,
        CAPSULE,
        CREAM,
        SYRUP,
        SPRAY,
        POWDER,
        BIOSENSOR,
        INJECTION,
        OIL,
        GREEN_MEDICINE
    }

    
}
