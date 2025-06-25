package aplicacion.logica.registers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aplicacion.logica.Validate;
import aplicacion.logica.buy_perms.BuyPerm;

public class ControlledPatient extends Person {
    private List<String> patologies;
    private List<BuyPerm> buyPerms;

    public ControlledPatient(String name, long id, String address, Sex sex, LocalDate birthDate) {
        super(name, id, address, sex, birthDate);
        patologies = new ArrayList<>();
        buyPerms = new ArrayList<>();
    }

    public List<String> getPatologies() {
        return patologies;
    }

    public List<BuyPerm> getBuyPerms() {
        return buyPerms;
    }

    public void setPathologies(List<String> patologies) {
        if (!patologies.stream().allMatch(Validate::isThingName)) {
            throw new IllegalArgumentException(
                    "Formato de nombre incorrecto, sólo caracteres alfanuméricos, guiones y espacios.");
        }
        this.patologies = patologies;
    }
}
