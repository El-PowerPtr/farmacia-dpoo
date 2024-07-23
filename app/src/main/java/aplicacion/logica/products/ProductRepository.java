package aplicacion.logica.products;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.ArrayList;
import aplicacion.logica.Format;

public class ProductRepository {
    private HashSet<Product> products; // no le voy a poner getter a esa basura xdddddd 
    
    public ProductRepository(){
        this.products = new HashSet<>();
    }

    public boolean add(Product product){
        return products.add(product);
    }

    /**
     * Search a {@code Product} by name in a given list.
     * 
     * @param name The product name (or a part of it).
     * @param productArrayList The product list.
     * @return The products that contains the <b>name</b> in lexical order.
     * @see Product  
     * @see Presentation
     */
    public static ArrayList<Product> searchByName(String name, ArrayList<Product> productArrayList){
        return productArrayList.parallelStream()
            .filter(product ->{
                if (product instanceof Presentation)
                    return product.getCommonName().contains(name) 
                        || ((Presentation)product).getMedicine()
                            .getScientificName().contains(name);
                else
                    return product.getCommonName().contains(name);
            })              
            .sorted((productA, productB) -> productA.getCommonName().compareTo(productB.getCommonName()))
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public static ArrayList<Product> searchByFormat(Format format, ArrayList<Product> productArrayList){
        return productArrayList.parallelStream()
            .filter(element -> element instanceof Presentation 
                && ((Presentation)element).getFormat() == format)
            .sorted((productA, productB) -> productA.getCommonName().compareTo(productB.getCommonName()))
            .collect(Collectors.toCollection(ArrayList::new));
    } 

    public ArrayList<Product> getProductsAsArrayList() {
        return products.stream()
            .sorted((productA, productB) -> productA.getCommonName().compareTo(productB.getCommonName()))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
