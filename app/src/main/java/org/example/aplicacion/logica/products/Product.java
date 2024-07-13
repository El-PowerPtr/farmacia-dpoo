package org.example.aplicacion.logica.products;

public abstract class Product {
    private double price;
    private String commonName;
    private long id;
    
    protected Product(double price, String commonName, long id){
        setPrice(price);
        setCommonName(commonName);
        setId(id);
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        Validate.isNotEmpty(price);
        Validate.isPositiveNumber(price);        
        this.price = price;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName){
        Validate.isNotEmpty(commonName);
        Validate.isProductName (commonName);

        this.commonName = commonName;    
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        Validate.isNotEmpty(id);
        Validate.isGreaterThanZero(id);
        this.id = id;
    }     
}