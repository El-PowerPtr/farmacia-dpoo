package aplicacion.logica.registers;

import java.time.LocalDate;

import aplicacion.logica.Validate;

public class Person {
    protected String name;
    protected Sex sex;
    protected long id;
    protected String address;
    protected LocalDate birthDate;

    public Person(String name, long id, String address, Sex sex, LocalDate birthDate) {
        setBirthDate(birthDate);
        setName(name);
        setSex(sex);
        setId(id);
        setAddress(address);
    }

    protected void setName(String name) {
        if (!Validate.isHumanName(name)) {
            throw new IllegalArgumentException(name + " no es el nombre de una ersona");
        }
        this.name = name;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected void setId(long id) {
        Validate.isHumanId(id);
        this.id = id;
    }

    protected void setSex(Sex sex) {
        if (sex == null) {
            throw new IllegalArgumentException("El sexo es nulo.");
        }
        this.sex = sex;
    }

    protected void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha es nula por alguna razón.");
        }
        if (Validate.isFuture(birthDate)) {
            throw new IllegalArgumentException(
                    "Las fechas de nacimiento no pueden estar ubicadas en el futuro.");
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

    public boolean equals(Person other) {
        return other instanceof Person && id == other.getId();
    }
}
