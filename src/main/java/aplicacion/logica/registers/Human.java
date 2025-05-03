package aplicacion.logica.registers;

import java.io.Serializable;

import aplicacion.logica.Validate;

public class Human implements Serializable  {
    protected String name;
    protected Sex sex;
    protected long id;
    protected String address; 

    public Human(String name, long id, String address, Sex sex){
        setName(name);
        setSex(sex);
        setId(id);
        setAddress(address);
    }

    protected void setName(String name){
        Validate.isNotEmpty(name);
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
