package aplicacion.logica.buy_perms;
import java.util.HashMap;
import java.io.Serializable;
import aplicacion.logica.Validate;

public abstract class BuyPerm implements Serializable {
    private long id;
    private HashMap<Long, Integer> products;

    public BuyPerm(long id, HashMap<Long, Integer> products){
        setId(id);
        setProducts(products);
    }    

    public void setId(long id){
        Validate.isNotEmpty(id);
        Validate.isGreaterThanZero(id);
        this.id = id;
    } 

    public HashMap<Long, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Long, Integer> products) {
        for(Long key: products.keySet()){
            Validate.isNotEmpty(key);
            Validate.isGreaterThanZero(key);
        }
        for(Integer value: products.values()){
            Validate.isNotEmpty(value);
            Validate.isGreaterThanZero(value);
        }

        this.products = products;
    }

    public long getId() {
        return id;
    }

    public abstract String getType();

}
