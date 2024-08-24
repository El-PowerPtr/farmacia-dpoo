package aplicacion.logica.products;

import java.io.Serializable;

import aplicacion.logica.Validate;

public class Batch implements Cloneable, Serializable{
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

    public Product getProduct(){
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Batch newBatch = (Batch)super.clone();
        newBatch.setQuantity(quantity);
        newBatch.setProduct(product);
        newBatch.setId(id);

        return newBatch;
    }

    @Override
    public boolean equals(Object obj) {
        Batch externalBatch = (Batch)obj;

        return id == externalBatch.getId() && product == externalBatch.getProduct();
    }

    @Override
    public int hashCode() {
        return (int)id;
    }
}

