package aplicacion.logica.registers;

import java.io.Serializable;
import java.time.LocalDate;
import aplicacion.logica.Validate;

public class Human implements Serializable  {
    protected String name;
    protected Sex sex;
    protected long id;
    protected String address; 
    protected LocalDate birthDate;

    public Human(String name, long id, String address, Sex sex, LocalDate birthDate){
        setBirthDate(birthDate);
        setName(name);
        setSex(sex);
        setId(id);
        setAddress(address);
    }

    protected void setName(String name){
        if (name == null){

        }
        Validate.isHumanName(name);
        this.name = name;
    }

    protected void setAddress(String address){
        Validate.isNotEmpty(address);
        this.address = address;
    }
    
    protected void setId(long id){
        Validate.isNotEmpty(id);
        Validate.isHumanId(id);
        this.id = id;
    }

    protected void setSex(Sex sex){
        Validate.isNotEmpty(sex);
        this.sex = sex;
    }

    protected void setBirthDate(LocalDate birthDate){
        if(birthDate == null){
            throw new IllegalArgumentException("La fecha es nula por alguna razón");
        }
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public boolean equals(Human other){
        return other instanceof Human && id == other.getId();
    }

}
