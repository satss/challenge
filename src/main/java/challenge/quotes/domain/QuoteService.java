package challenge.quotes.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    private final QuoteRepo quoteRepo;


    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }

    public QuoteDto addQuote(QuoteDto request, String username) {
        var quotes = Quote.builder().quote(request.quote()).authorUsername(username).build();
        var savedQuote = quoteRepo.save(quotes);
        return new QuoteDto(savedQuote.getId(), savedQuote.getQuote(), savedQuote.getAuthorUsername());
    }


    public Page<Quote> getAllQuote(Integer page, Integer size) {
        return quoteRepo.findAll(PageRequest.of(page, size));
    }


    public Page<Quote> getQuotesByAuthorId(String userName, Integer page, Integer size) {
        return quoteRepo.findAllByAuthorId(userName, PageRequest.of(page, size));

    }
}
