package aplicacion.logica.products;

import aplicacion.logica.Validate;

public class Product {
    private double price;
    private String commonName;
    private long id;
    private ControlType control;

    public Product(double price, String commonName, long id, ControlType control) {
        setPrice(price);
        setCommonName(commonName);
        setId(id);
        setControl(control);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.price = price;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        if (commonName == null){
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        Validate.isThingName(commonName);

        this.commonName = commonName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        Validate.isNotEmpty(id);
        Validate.isGreaterThanZero(id);
        this.id = id;
    }

    public void setControl(ControlType control) {
        Validate.isNotEmpty(control);
        this.control = control;
    }

    public ControlType getControl() {
        return control;
    }

    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }

    @Override
    public boolean equals(Object other)
            throws IllegalArgumentException {
        if (other instanceof Product) {
            Product otherProduct = (Product) other;
            return id == otherProduct.getId();
        } else {
            throw new IllegalArgumentException("Un producto sólo puede ser igual a otro Prodcuto");
        }
    }

}
