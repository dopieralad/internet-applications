package pl.dopierala.ia.config.database;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.dopierala.ia.model.person.parent.Parent;
import pl.dopierala.ia.model.person.parent.ParentRepository;
import pl.dopierala.ia.model.studentclass.StudentClass;
import pl.dopierala.ia.model.studentclass.StudentClassRepository;

/**
 * {@link CommandLineRunner Runner} for database initialization at runtime.
 *
 * This is needed, because we are using an embedded H2 database,
 * which does not retain its state between application restarts.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/24
 */
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final StudentClassRepository studentClassRepository;
    private final ParentRepository parentRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseInitializer(StudentClassRepository studentClassRepository, ParentRepository parentRepository, PasswordEncoder passwordEncoder) {
        this.studentClassRepository = studentClassRepository;
        this.parentRepository = parentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        final List<StudentClass> studentClasses = initializeStudentClasses();
        initializeParents(studentClasses);
    }

    private List<StudentClass> initializeStudentClasses() {
        final Set<StudentClass> studentClasses = Set.of(
            new StudentClass("1A"),
            new StudentClass("1B"),
            new StudentClass("2A"),
            new StudentClass("3A"),
            new StudentClass("4A"),
            new StudentClass("4B"),
            new StudentClass("4C")
        );

        return studentClassRepository.saveAll(studentClasses);
    }

    private List<Parent> initializeParents(List<StudentClass> studentClasses) {
        final Parent firstParent = new Parent();
        firstParent.setEmail("daniel.dopierala@student.put.poznan.pl");
        firstParent.setPassword(passwordEncoder.encode("!QAZxsw2"));
        studentClasses.stream().findAny().ifPresent(firstParent::setStudentClass);

        final Parent secondParent = new Parent();
        secondParent.setEmail("test@example.com");
        secondParent.setPassword(passwordEncoder.encode("test"));
        studentClasses.stream().findAny().ifPresent(secondParent::setStudentClass);

        final Set<Parent> parents = Set.of(
            firstParent,
            secondParent
        );

        return parentRepository.saveAll(parents);
    }
}
