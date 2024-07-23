package aplicacion.logica.products;

import java.util.ArrayList;
import java.util.HashMap;

public class BatchRepository {
    private HashMap<Product, ArrayList<Batch>> batches;

    public BatchRepository(){
        this.batches = new HashMap<>();
    }

    public HashMap<Product,ArrayList<Batch>> batches(Product product){
        return batches;
    }

}

