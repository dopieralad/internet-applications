package pl.dopierala.ia.config.security.csrf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Component;

/**
 * A secure {@link CsrfTokenRepository CSRF Token Repository} for single-page applications.
 *
 * @author Daniel Dopierała (daniel.dopierala@snpgroup.com)
 * @since 2018/12/01
 */
@Component
public class SecureCsrfTokenRepository implements CsrfTokenRepository {

    private final CookieCsrfTokenRepository csrfTokenRepository;

    public SecureCsrfTokenRepository() {
        csrfTokenRepository = new CookieCsrfTokenRepository();
        // Cookie has to be read by Javascript and sent as "X-XSRF-TOKEN" header
        csrfTokenRepository.setCookieHttpOnly(false);
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        return csrfTokenRepository.generateToken(request);
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        csrfTokenRepository.saveToken(token, request, response);
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        return csrfTokenRepository.loadToken(request);
    }
}
