package aplicacion.logica.buy_perms;

import java.util.ArrayList;

import aplicacion.logica.registers.Human;
import aplicacion.logica.registers.Patient;

public class DispatchBook {
    private ArrayList<Human> members;
    private Human familyHead;

    public DispatchBook(ArrayList<Human> members, Human familyHead){
        setMembers(members);
        setFamilyHead(familyHead);
    }
    
    public ArrayList<Human> getMembers() {
        return members;
    }
    public void setMembers(ArrayList<Human> members) {
        this.members = members;
    }
    public Human getFamilyHead() {
        return familyHead;
    }
    public void setFamilyHead(Human familyHead) {
        this.familyHead = familyHead;
    }    

    
}
