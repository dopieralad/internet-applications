package pl.dopierala.ia.model.person.student;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pl.dopierala.ia.model.person.Person;
import pl.dopierala.ia.model.person.user.User;
import pl.dopierala.ia.model.studentclass.StudentClass;

/**
 * JPA {@link Entity} representing a school's Student.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Entity
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private byte[] image;
    @ManyToOne(optional = false)
    private User parent;
    @ManyToOne(optional = false)
    private StudentClass studentClass;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }
}
