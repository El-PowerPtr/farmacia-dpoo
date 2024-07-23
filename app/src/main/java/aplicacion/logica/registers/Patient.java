package aplicacion.logica.registers;

import aplicacion.logica.Validate;
import java.util.ArrayList;

public class Patient extends Human {
    private ArrayList<String> patologies;

    public Patient(String name, long id, String address, Sex sex) {
        super(name, id, address, sex);
        this.patologies = new ArrayList<>();
    }
    
    public ArrayList <String> getPatologies(){
        return patologies;
    }

    public void addPatology(String patology){
        Validate.isNotEmpty(patology);
        Validate.isThingName(patology);
        patologies.add(patology);
    }
}
