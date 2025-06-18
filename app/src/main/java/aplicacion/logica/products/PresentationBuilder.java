package aplicacion.logica.products;

import aplicacion.logica.Format;
import aplicacion.logica.Validate;

public class PresentationBuilder {
    private long id;
    private String commonName;
    private double price;
    private Medicine medicine;
    private Format format;
    private ControlType control;
    private int strengthMg;

    public PresentationBuilder reset(){
        id = 0;
        commonName = null;
        price = 0;
        medicine = null;
        format = null;
        control = null;
        strengthMg = 0;

        return this;
    }

    public Presentation build(){
        Presentation presentation =  new Presentation(price, commonName, id, control, medicine, format, strengthMg);
        reset();
        return presentation;
    }

    public PresentationBuilder setMedicine(Medicine medicine) {
        Validate.isNotEmpty(medicine);
        this.medicine = medicine;

        return this;
    }

    public PresentationBuilder setStrengthMg(int strengthMg){
        Validate.isNotEmpty(strengthMg);
        Validate.isGreaterThanZero(strengthMg);

        this.strengthMg = strengthMg;
        
        return this;
    }

    public PresentationBuilder setFormat(Format format) {
        Validate.isNotEmpty(format);
        this.format = format;
        
        return this;
    }

    
    public PresentationBuilder setPrice(double price){
        Validate.isNotEmpty(price);
        Validate.isPositiveNumber(price);        
        this.price = price;
        
        return this;
    }

    public PresentationBuilder setCommonName(String commonName){
        Validate.isNotEmpty(commonName);
        Validate.isThingName (commonName);

        this.commonName = commonName;
        
        return this;    
    }

    public PresentationBuilder setControl(ControlType control){
        Validate.isNotEmpty(control);
        this.control = control;
        
        return this;
    }

    public PresentationBuilder setId(long id){
        Validate.isNotEmpty(id);
        Validate.isGreaterThanZero(id);
        this.id = id;
        
        return this;
    }  
}



  