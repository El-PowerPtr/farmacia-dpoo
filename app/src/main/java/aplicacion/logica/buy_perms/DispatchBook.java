package aplicacion.logica.buy_perms;

import java.util.Set;

import aplicacion.logica.registers.Person;

public class DispatchBook {
    private long id;
    private String direccion;
    private Person leader;
    private Set<Person> members;

    public DispatchBook(long id, String direccion, Person leader, Set<Person> members) {
        this.id = id;
        this.direccion = direccion;
        this.leader = leader;
        this.members = members;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Person getLeader() {
        return leader;
    }

    public void setLeader(Person leader) {
        if (!members.contains(leader)) {
            throw new IllegalArgumentException("El jefe de núcleo debe estar inscrito en la libreta");
        }
        this.leader = leader;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }
}
