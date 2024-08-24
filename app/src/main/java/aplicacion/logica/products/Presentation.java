package aplicacion.logica.products;

import aplicacion.logica.Format;
import aplicacion.logica.Validate;

public class Presentation extends Product {

    private Medicine medicine;
    //private int temperature;   not important 
    private Format format;
    private int strengthMg;

    public Presentation(double price, String commonName,long id,ControlType control, Medicine medicine, Format format, int strengthMg) {
        super(price, commonName, id, control);
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

    public Medicine getMedicine() {
        return medicine;
    }

    

    
}
