package aplicacion.logica.registers;

import aplicacion.logica.Validate;
import aplicacion.logica.buy_perms.BuyPerm;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

//all of this class atributes are final, "setters" are just for validation
public class Purchase implements Comparable<Purchase> , Serializable{
    public final LocalDateTime time;
    public final long buyPermId;
    public final String buyPermType;
    public final long personId;
    public final HashMap<Long, BatchSell> boughtProducts;
    private boolean valid;

    public Purchase(LocalDateTime time, BuyPerm buyPerm, HashMap<Long, BatchSell> bougthProducts, long personId) {
        this.time = setTime(time);
        this.buyPermId = setBuyPermId(buyPerm);
        this.buyPermType = setBuyPermType(buyPerm);
        this.boughtProducts = setBoughtProducts(bougthProducts);
        this.personId = setPersonId(personId);
        this.valid = true;
    }

    private LocalDateTime setTime(LocalDateTime time) {
        Validate.isNotEmpty(time);
        Validate.isPast(time.toLocalDate());
        return time;
    }

    private HashMap<Long, BatchSell> setBoughtProducts(HashMap<Long, BatchSell> bougthProducts) {
        for (Long product : bougthProducts.keySet()) {
            Validate.isGreaterThanZero(product.longValue());
        }

        for (BatchSell batchSell : bougthProducts.values()) {
            Validate.isNotEmpty(batchSell.batch);
            Validate.isGreaterThanZero(batchSell.batch);

            Validate.isNotEmpty(batchSell.number);
            Validate.isGreaterThanZero(batchSell.number);
        }
        return bougthProducts;
    }

    private String setBuyPermType(BuyPerm buyPerm) {
        return buyPerm.getType();
    }

    private long setBuyPermId(BuyPerm buyPerm) {
        return buyPerm.getId();
    }

    private long setPersonId(long personId) {
        Validate.isNotEmpty(personId);
        Validate.isHumanId(personId);
        return personId;
    }


    @Override
    public int compareTo(Purchase o) {
        int result = time.compareTo(o.time);
        if (result == 0)
            result += ((Long) personId).compareTo(o.personId);
        return result;
    }

    public static class BatchSell {
        public final Long batch;
        public final Integer number;

        public BatchSell(Long batch, Integer number) {
            this.batch = setBatch(batch);
            this.number = setNumber(number);
        }

        private long setBatch(long batch) {
            Validate.isNotEmpty(batch);
            Validate.isGreaterThanZero(batch);

            return batch;
        }

        private int setNumber(int batch) {
            Validate.isNotEmpty(batch);
            Validate.isGreaterThanZero(batch);

            return batch;
        }
    }

    public boolean getValid(){
        return valid;
    }

    public void revertValid(){
        valid = !valid;
    }
}
