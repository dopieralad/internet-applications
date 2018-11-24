package pl.dopierala.ia.model.message;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for {@link Message Messages}.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/11/12
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
}
