package aplicacion.logica.registers;

import aplicacion.logica.Validate;
import aplicacion.logica.buy_perms.BuyPerm;

import java.util.ArrayList;

public class Patient extends Human {
    private ArrayList<String> patologies;
    private ArrayList<BuyPerm> buyPerms;

    public Patient(String name, long id, String address, Sex sex) {
        super(name, id, address, sex);
        this.patologies = new ArrayList<>();
        this.buyPerms = new ArrayList<>();
    }
    
    public ArrayList <String> getPatologies(){
        return patologies;
    }

    public ArrayList<BuyPerm> getBuyPerms() {
        return buyPerms;
    }
    
    public void addPatology(String patology){
        Validate.isNotEmpty(patology);
        Validate.isThingName(patology);
        patologies.add(patology);
    }
}
