package aplicacion.logica.registers;

import java.util.TreeMap;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;


public class PurchaseHistory implements Serializable{    

    private TreeMap<LocalDateTime,Purchase> history;
    
    public PurchaseHistory() {
        this.history = new TreeMap<>();
    }

    /**
     * Shows all the registered purchases from the last 30 days
     */
    public Purchase[] last30Days(){
        return history.subMap(LocalDateTime.now().minusMonths(1), LocalDateTime.now())
            .sequencedValues()
            .toArray(Purchase[]::new);
    }  

     /**
     * Shows all the registered purchases from this month
     */
    public Purchase[] thisMonth(){
        return history.subMap(LocalDate.now()
                .atStartOfDay().
                minusDays(LocalDate.now().getDayOfMonth()),LocalDateTime.now())
                    .sequencedValues()
                    .toArray(Purchase[]::new);
    }

    public TreeMap<LocalDateTime, Purchase> getHistory() {
        return history;
    }

}