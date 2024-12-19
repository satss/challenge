package challenge.configure;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepo extends CrudRepository<Author, Long> {
    Optional<Author> findAuthorsByUsername(String username);
}
