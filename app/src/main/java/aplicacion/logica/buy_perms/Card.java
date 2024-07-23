package aplicacion.logica.buy_perms;

import java.util.HashMap;
import aplicacion.logica.Validate;

public class Card extends BuyPerm {
    private String patientName;
    private String doctorName;
    
    public Card(long id, HashMap<Long, Integer> products, String patientName, String doctorName) {
        super(id, products);
        setPatientName(patientName);
        setDoctorName(doctorName);
    } 
    
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        Validate.isNotEmpty(patientName);
        Validate.isHumanName(patientName);
        this.patientName = patientName;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        Validate.isNotEmpty(doctorName);
        Validate.isHumanName(doctorName);
        this.doctorName = doctorName;
    }
    

    
}
