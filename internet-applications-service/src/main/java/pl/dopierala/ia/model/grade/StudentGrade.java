package pl.dopierala.ia.model.grade;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import pl.dopierala.ia.model.person.student.Student;
import pl.dopierala.ia.model.task.Task;

/**
 * JPA {@link Entity} representing a {@link Grade}
 * given to a {@link Student} for a specific {@link Task}.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Entity
public class StudentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Grade grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Task task;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
