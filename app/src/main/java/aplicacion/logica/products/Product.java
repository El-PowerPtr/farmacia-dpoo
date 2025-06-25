package aplicacion.logica.products;

import aplicacion.logica.Validate;

public class Product {
    protected double price;
    protected String commonName;
    protected long id;
    protected ControlType controlType;

    public Product(long id, String commonName, double price, ControlType controlType) {
        setPrice(price);
        setCommonName(commonName);
        setId(id);
        setControlType(controlType);
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
        if (commonName == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        Validate.isThingName(commonName);

        this.commonName = commonName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public void setControlType(ControlType controlType) {
        this.controlType = controlType;
    }

    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }
}
