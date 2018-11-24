package pl.dopierala.ia.model.person.parent;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import pl.dopierala.ia.model.person.student.Student;
import pl.dopierala.ia.model.person.user.User;

/**
 * JPA {@link Entity} representing a school {@link Student Student's} Parent.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Entity
public class Parent extends User {

    @OneToMany(mappedBy = "parent")
    private Set<Student> children;

    public Set<Student> getChildren() {
        return children;
    }
}
