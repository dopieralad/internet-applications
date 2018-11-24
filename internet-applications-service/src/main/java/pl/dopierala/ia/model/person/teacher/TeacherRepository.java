package pl.dopierala.ia.model.person.teacher;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for {@link Teacher Teachers}.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
}
