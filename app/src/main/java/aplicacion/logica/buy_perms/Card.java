package aplicacion.logica.buy_perms;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import aplicacion.logica.products.ControlType;
import aplicacion.logica.products.Product;
import aplicacion.logica.registers.ControlledPatient;

public class Card extends BuyPerm {
    private Map<Product, Integer> products;
    private ControlledPatient patient;
    private LocalDate creationDate;
    private LocalDate expireDate;

    public Card(Map<Product, Integer> products, ControlledPatient patient, LocalDate creationDate,
            LocalDate expireDate) {
        setProducts(products);
        setPatient(patient);
        setCreationDate(creationDate);
        setExpireDate(expireDate);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private void setProducts(Map<Product, Integer> products) {
        if (products.size() == 0) {
            throw new IllegalArgumentException("El Tarjetón debe tener al menos un producto");
        } else if (products.size() > 4) {
            throw new IllegalArgumentException("El Tarjetón debe tener como máximo 4 productos");
        }
        List<Product> invalidProducts = products.keySet()
                .stream()
                .filter(x -> x.getControlType() == ControlType.CARD)
                .collect(Collectors.toList());
        if (!invalidProducts.isEmpty()) {
            throw new IllegalArgumentException(
                    "Hay uno(s) producto(s) que no se controlan por Tarjetón" + invalidProducts.stream()
                            .map(Product::getCommonName)
                            .collect(Collectors.toList()).toString());
        }
        this.products = products;
    }

    public ControlledPatient getPatient() {
        return patient;
    }

    private void setPatient(ControlledPatient patient) {
        this.patient = patient;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    private void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
