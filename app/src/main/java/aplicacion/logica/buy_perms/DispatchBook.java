package aplicacion.logica.buy_perms;

import java.util.ArrayList;
import java.util.HashMap;

import aplicacion.logica.registers.Human;

public class DispatchBook extends BuyPerm{
    private ArrayList<Human> members;
    private Human familyHead;

    public DispatchBook(long id, HashMap<Long, Integer> products, ArrayList<Human> members, Human familyHead){
        super(id, products);
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

    @Override
    public String getType(){
        return "LIBRETA";
    }    
}
