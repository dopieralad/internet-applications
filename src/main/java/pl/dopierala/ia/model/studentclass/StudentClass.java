package pl.dopierala.ia.model.studentclass;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pl.dopierala.ia.model.person.student.Student;

/**
 * JPA {@link Entity} representing a class of {@link Student Students}.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Entity
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true, nullable = false, updatable = false)
    private String name;
    @OneToMany(mappedBy = "studentClass")
    private Set<Student> students;

    @SuppressWarnings("unused") // Private no-arg constructor for Hibernate
    private StudentClass() {
    }

    public StudentClass(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
