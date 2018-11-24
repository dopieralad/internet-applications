package pl.dopierala.ia.model.grade;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for {@link StudentGrade Student Grades}.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Repository
public interface GradeRepository extends JpaRepository<StudentGrade, UUID> {
}
