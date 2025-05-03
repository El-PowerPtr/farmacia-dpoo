import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MedicineRepository extends Serializable{

    private HashMap<Long, Medicine> medicines;

    public MedicineRepository(){
        medicines = new HashMap<>();
    }

    public void add(Medicine medicine){
        medicines.put(medicine.getId(), medicine);
    }

    public Medicine get(Long id){
        return medicines.get(id);
    }

    /**
     * Search a medicines by it's<b>scientific name</b or a part of it
     * 
     * @param name the medicine's name
     * @return All the medicine's that have (or contains that name)
     * @see Medicine
     */
    public ArrayList<Medicine> searchByName(String name){
        return medicines.values()
            .stream()
            .filter(e -> e.getScientificName().contains(name))
            .collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Returns the entire repository
     * 
     * @return All the medicines
     */
    public ArrayList<Medicine> getAll(){
        return new ArrayList(medicines.values());
            
    }

}
