package challenge.quotes.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepo extends CrudRepository<Quote, Long> {


    @Query("select qdb from Quote qdb ")
    Page<Quote> findAll(Pageable page);

    @Query("select qdb from Quote qdb where qdb.authorUsername = :authorUserName")
    Page<Quote> findAllByAuthorId(String authorUserName, Pageable page);
}
