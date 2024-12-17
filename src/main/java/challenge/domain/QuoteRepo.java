package challenge.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepo extends CrudRepository<QuoteDB, Long> {


    @Query("select qdb from QuoteDB qdb ")
    Page<QuoteDB> findAll(Pageable page);

    @Query("select qdb from QuoteDB qdb where qdb.authorId = :authorId")
    Page<QuoteDB> findAllByAuthorId(Long authorId, Pageable page);
}
