package challenge.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
public class AuthorDetailsService implements UserDetailsService {
    private final AuthorRepo authorRepo;

    public AuthorDetailsService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Author> authorOptional = authorRepo.findAuthorsByUsername(username);
        if (authorOptional.isEmpty()) {
            log.error("Author not found for name {}", username);
            throw new UsernameNotFoundException("Author not found for name: " + username);
        }

        Author author = authorOptional.get();
        List<SimpleGrantedAuthority> grantedAuthorities = author.getPolicy().getPermissions()
                .stream().map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .toList();

        return User.withUsername(author.getUsername())
                .password(author.getPassword())
                .authorities(grantedAuthorities)
                .build();
    }
}
