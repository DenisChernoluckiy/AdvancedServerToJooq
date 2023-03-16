package advanced_server.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import static io.jsonwebtoken.lang.Strings.hasText;

@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private static final String AUTHORIZATION = "Authorization";
    private final JwtProvider jwtProvider;
    private final UserDetailsServiceImpl appUserDetailsService;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException,
                                            ServletException {
        try {
            Optional<String> userToken = getTokenFromRequest((HttpServletRequest) request);
            if (userToken.isPresent() && jwtProvider.validateToken(userToken.get())) {
                String id = jwtProvider.getIdFromToken(userToken.get());
                UserDetailsImpl userDetails = appUserDetailsService.loadUserByUsername(id);
                var auth = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        catch (JwtException error) {
           error.getMessage();
        }
        chain.doFilter(request, response);
    }

    private Optional<String> getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return Optional.of(bearer.substring(7));
        }
        return Optional.empty();
    }
}
