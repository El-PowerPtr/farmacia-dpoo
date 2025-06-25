package aplicacion.logica.ventas;

import java.util.Map;
import java.util.Set;

import aplicacion.logica.buy_perms.BuyPerm;
import aplicacion.logica.products.Product;

public class ShoppingCart {
    private Map<Product, Integer> products;
    private Set<BuyPerm> perms;
    private double payment;

    public ShoppingCart(Map<Product, Integer> products, Set<BuyPerm> perms, double payment) {
        this.products = products;
        this.perms = perms;
        this.payment = payment;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Set<BuyPerm> getPerms() {
        return perms;
    }

    public void setPerms(Set<BuyPerm> perms) {
        this.perms = perms;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

}
