package pl.dopierala.ia.config.security.auth.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.dopierala.ia.model.person.user.User;

/**
 * A secure implementation of {@link PasswordEncoder} to be used for hashing {@link User} passwords.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/12/01
 */
@Component
public class SecurePasswordEncoder extends BCryptPasswordEncoder {

    public SecurePasswordEncoder() {
        super(12);
    }
}
