package aplicacion.logica.buy_perms;

import aplicacion.logica.Validate;
import java.time.LocalDate;
import java.util.HashMap;

public class Recipe extends BuyPerm {
    private String patientName;
    private String doctorName;
    private long patientsId;
    private long doctorsId;
    private LocalDate date; 

    public Recipe(long id, HashMap<Long, Integer> products,
        String patientName, long patientsId, String doctorName, long doctorId, LocalDate date)
    {   
        super(id, products);
        setPatientName(patientName);
        setPatientsId(patientsId);
        setDoctorName(doctorName);
        setDoctorsId(doctorId);
        setDate(date);
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        Validate.isNotEmpty(patientName);
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        Validate.isNotEmpty(doctorName);
        this.doctorName = doctorName;
    }

    public long getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(long patientsId) {
        Validate.isNotEmpty(patientsId);
        Validate.isHumanId(patientsId);
        this.patientsId = patientsId;
    }

    public long getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(long doctorsId) {
        Validate.isNotEmpty(doctorsId);
        Validate.isHumanId(doctorsId);
        this.doctorsId = doctorsId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        Validate.isNotEmpty(date);
        Validate.isPast(date);
        this.date = date;
    }


    @Override
    public String getType(){
        return "RECETA";
    }
}