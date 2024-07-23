package aplicacion.logica.products;

import aplicacion.logica.Validate;

public class Medicine {
    private String scientificName;
    private long id;

    public Medicine(String scientificName, long id) {
        setScientificName(scientificName);
        setId(id);
    }

    public void setId(long id){
        Validate.isNotEmpty(id);
        Validate.isGreaterThanZero(id);
        this.id = id;
    }

    public void setScientificName(String scientificName){
        //si ponen espacios al principio o al final los quito
        String fixedName = scientificName.trim();   
        //valido si la cadena no es nula y rel format es correcto
        Validate.isNotEmpty(fixedName);
        Validate.isThingName(fixedName);

        this.scientificName = fixedName;    
    }

    public long getId(){
        return id;
    }

    public String getScientificName() {
        return scientificName;
    }

    @Override
    public boolean equals(Object other){
        Medicine otherMedicine = (Medicine)other;
        return id == otherMedicine.getId() || scientificName == otherMedicine.getScientificName();
    }

    @Override
    public int hashCode(){
        return ((Long)id).hashCode();
    }
    
    @Override 
    public Object clone(){
        return new Medicine(scientificName, id);
    }
}
