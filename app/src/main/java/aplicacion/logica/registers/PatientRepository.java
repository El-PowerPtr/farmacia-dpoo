package aplicacion.logica.registers;

import java.util.HashMap;
import java.io.Serializable;

public class PatientRepository implements Serializable{
    public HashMap<Long, Patient> patients;

    public PatientRepository(){
        patients = new HashMap<>();
    }

    public HashMap<Long, Patient> getPatients() {
        return patients;
    }
}

