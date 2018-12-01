package pl.dopierala.ia.config.security.auth.userdetails;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController REST Controller} for fetching current user's authentication details.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/12/01
 */
@RestController("/auth/user")
public class UserDetailsController {

    @GetMapping
    public Object getCurrentUserDetails(@AuthenticationPrincipal Object principal) {
        return principal;
    }
}
