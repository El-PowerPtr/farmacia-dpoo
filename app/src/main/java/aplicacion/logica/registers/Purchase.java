package aplicacion.logica.registers;
import aplicacion.logica.Validate;
import aplicacion.logica.buy_perms.BuyPerm;

import java.time.LocalDateTime;
import java.util.HashMap;

//all of this class atributes are final, "setters" are just for validation
public class Purchase {
    public final LocalDateTime time; 
    public final long buyPermId;
    public final String buyPermType;
    public final HashMap <Long, Integer> products;
    
    public Purchase(LocalDateTime time, BuyPerm buyPerm, HashMap<Long, Integer> products) {
        this.time = setTime(time);
        this.buyPermId = setBuyPermId(buyPerm);
        this.buyPermType = setBuyPermType(buyPerm);
        this.products = setProducts(products);
    }

    private LocalDateTime setTime(LocalDateTime time){
        Validate.isNotEmpty(time);
        Validate.isPast(time.toLocalDate());
        return time;
    }

    private HashMap<Long, Integer> setProducts(HashMap<Long, Integer> products){
        for(Long product: products.keySet()){
            Validate.isGreaterThanZero(product.longValue());
        }

        for (Integer number : products.values()) {
            Validate.isNotEmpty(number);
            Validate.isGreaterThanZero(number.intValue());
        }
        return products;
    }

    private String setBuyPermType(BuyPerm buyPerm){
        Validate.isNotEmpty(buyPerm);
        return buyPerm.getClass().getCanonicalName();
    }

    private long setBuyPermId(BuyPerm buyPerm){
        Validate.isNotEmpty(buyPerm);
        return buyPerm.getId();
    }
}
