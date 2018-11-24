package pl.dopierala.ia.model.person;

import javax.persistence.MappedSuperclass;

/**
 * A basic JPA {@link MappedSuperclass Superclass} representing
 * any Person in the school system.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@MappedSuperclass
public abstract class Person {

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
