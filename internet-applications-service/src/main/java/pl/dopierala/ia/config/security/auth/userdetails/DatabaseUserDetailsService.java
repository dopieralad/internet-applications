package pl.dopierala.ia.config.security.auth.userdetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dopierala.ia.model.person.user.User;
import pl.dopierala.ia.model.person.user.UserRepository;

/**
 * {@link UserDetailsService User Details Service} that fetches {@link User Users} from database.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/12/01
 */
@Primary
@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        final Optional<User> optionalUser = userRepository.findByEmailIgnoreCase(email);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with e-mail: '%s' has not been found!", email));
        }

        final User user = optionalUser.get(); // NOSONAR False positive: ".isEmpty()" was called instead

        final Collection<GrantedAuthority> authorities = List
            .of(user.getClass().getSimpleName())
            .stream()
            .map(String::toUpperCase)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            authorities
        );
    }
}
