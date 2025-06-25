package aplicacion.logica.products;

import aplicacion.logica.Validate;
import java.time.LocalDate;
import java.util.Optional;

public class Batch {
    private int quantity;
    private long id;
    private Optional<LocalDate> production;
    private Optional<LocalDate> expiration;

    public Batch(int quantity, long id) {
        setQuantity(quantity);
        setId(id);
        setProduction(Optional.empty());
        setExpiration(Optional.empty());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Optional<LocalDate> getProduction() {
        return production;
    }

    public void setProduction(Optional<LocalDate> production) {
        if (production.isPresent() && Validate.isFuture(production.get())) {
            throw new IllegalArgumentException("La producción no puede ser del futuro");
        } else if (expiration.isPresent() && expiration.get().compareTo(production.get()) < 0) {
            throw new IllegalArgumentException("la fecha de vencimiento debe ser mayor que la de producción");
        }
        this.production = production;
    }

    public Optional<LocalDate> getExpiration() {
        return expiration;
    }

    public void setExpiration(Optional<LocalDate> expiration) {
        if (!production.isPresent()) {
            throw new IllegalArgumentException("No puede haber fecha de vencimiento, pero sí de producción");
        } else if (expiration.isPresent() && expiration.get().compareTo(production.get()) < 0) {
            throw new IllegalArgumentException("la fecha de vencimiento debe ser mayor que la de producción");
        }

        this.expiration = expiration;
    }

    public boolean isExpired() {
        return !expiration.isPresent() && expiration.get().compareTo(LocalDate.now()) <= 0;
    }

    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }
}
