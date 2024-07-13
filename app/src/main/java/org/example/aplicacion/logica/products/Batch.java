package org.example.aplicacion.logica.products;

public class Batch {
    private int quantity;
    private Product product;
    private long id;

    public Batch(int quantity, Product product, long id){
        setQuantity(quantity);
        setProduct(product);
        setId(id);
    }

    public void setProduct(Product product) {
        Validate.isNotEmpty(product);
        this.product = product;
    }

    public Product geProduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        Validate.isNotEmpty(quantity);
        Validate.isPositiveNumber(quantity);
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        Validate.isNotEmpty(id);
        Validate.isGreaterThanZero(id);
        this.id = id;
    }
}
