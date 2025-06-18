package aplicacion.logica.products;

import aplicacion.logica.Validate;

public class Product {
    private double price;
    private String commonName;
    private long id;
    private ControlType[] controlTypes;

    public Product(double price, String commonName, long id, ControlType[] controlTypes) {
        setPrice(price);
        setCommonName(commonName);
        setId(id);
        setControlTypes(controlTypes);
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

    public void setControlTypes(ControlType[] controlTypes) {
        if (controlTypes == null) {
            throw new IllegalArgumentException(
                    "El tipo de control no puede ser nulo.(Odio java la puta madre cómo coño deja que las enums sean nulas)");
        }
        this.controlTypes = controlTypes;
    }

    public ControlType[] getControlTypes() {
        return controlTypes;
    }

    public boolean controledBy(ControlType controlType) {
        for (int i = 0; i < controlTypes.length; i++) {
            if (controlTypes[i] == controlType) {
                return true;
            }
        }
        return false;
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
            throw new IllegalArgumentException("Un producto sólo puede ser igual a otro Producto");
        }
    }

}
