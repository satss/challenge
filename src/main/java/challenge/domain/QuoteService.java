package challenge.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuoteService {
    private final QuoteRepo quoteRepo;


    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }

    public Quote addQuote(Quote quote, String username) {
        var quotes = new QuoteDB(quote.quote(), 1L, username);
        var savedQuote = quoteRepo.save(quotes);
        return new Quote(savedQuote.getId(), savedQuote.getQuote(), savedQuote.getAuthorUsername());
    }


    public Page<QuoteDB> getAllQuote(Integer page, Integer size) {
        return quoteRepo.findAll(PageRequest.of(page, size));
    }


    public Page<QuoteDB> getQuotesByAuthorId(Long authorId, Integer page, Integer size) {
        return quoteRepo.findAllByAuthorId(authorId, PageRequest.of(page, size));

    }
}
