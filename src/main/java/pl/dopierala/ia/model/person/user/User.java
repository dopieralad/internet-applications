package pl.dopierala.ia.model.person.user;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

import pl.dopierala.ia.model.person.Person;
import pl.dopierala.ia.model.studentclass.StudentClass;

/**
 * JPA {@link Entity} representing a school system's User.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Email
    @Column(unique = true, nullable = false, updatable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToOne(optional = false)
    private StudentClass studentClass;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
