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
    /**
     * Search a {@code Product} by format in a given list.
     * 
     * @param format The product format (or a part of it).
     * @param productArrayList The product list.
     * @return The products that have the <b>format</b> in lexical order.
     * @see Product  
     * @see Presentation
     */
    public static ArrayList<Product> searchByFormat(Format format, ArrayList<Product> productArrayList){
        return productArrayList.parallelStream()
            .filter(element -> element instanceof Presentation 
                && ((Presentation)element).getFormat() == format)
            .map
            .sorted((productA, productB) -> productA.getCommonName().compareTo(productB.getCommonName()))
            .collect(Collectors.toCollection(ArrayList::new));
    } 

    /**
     * Gets the Products List as an ArrayList
     * 
     * @return The Products, in lexical order
     * @see Product
     */
    public ArrayList<Product> getProductsAsArrayList() {
        return products.stream()
            .sorted((productA, productB) -> productA.getCommonName().compareTo(productB.getCommonName()))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
