package aplicacion.logica.buy_perms;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import aplicacion.logica.Validate;
import aplicacion.logica.products.ControlType;
import aplicacion.logica.products.Product;

public class Recipe extends BuyPerm {
    private String doctorName;
    private long doctorsId;
    private LocalDate creationDate;
    private Map<Product, Integer> products;

    public Recipe(HashMap<Product, Integer> products,
            String doctorName, long doctorId, LocalDate creationDate) {
        setProducts(products);
        setDoctorName(doctorName);
        setDoctorId(doctorId);
        setCreationDate(creationDate);
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        if (!Validate.isHumanName(doctorName)) {
            throw new IllegalArgumentException("Nombre inválido: " + doctorName);
        }
        this.doctorName = doctorName;
    }

    public long getDoctorId() {
        return doctorsId;
    }

    public void setDoctorId(long doctorsId) {
        if (!Validate.isHumanId(doctorsId)) {
            throw new IllegalArgumentException("Número de carnét de identidad inválido");
        }
        this.doctorsId = doctorsId;
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

    public long getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(long doctorsId) {
        this.doctorsId = doctorsId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        if (Validate.isFuture(creationDate)) {
            throw new IllegalArgumentException("La fecha de creación no puede ser futura");
        }
        this.creationDate = creationDate;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
