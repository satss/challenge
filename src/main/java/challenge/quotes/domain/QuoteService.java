package challenge.quotes.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class QuoteService {
    private final QuoteRepo quoteRepo;


    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }

    public QuoteDto addQuote(QuoteDto request, String username) {
        log.info("Adding quote");
        try {
            var quotes = Quote.builder().quote(request.quote()).authorUsername(username).build();
            var savedQuote = quoteRepo.save(quotes);
            log.info("quote has been added for user {}", username);

            return new QuoteDto(savedQuote.getId(), savedQuote.getQuote(), savedQuote.getAuthorUsername());
        }catch (Exception e) {
            log.error("Error while adding quote", e);
            throw e;
        }
    }


    public Page<Quote> getAllQuote(Integer page, Integer size) {
        return quoteRepo.findAll(PageRequest.of(page, size));
    }


    public Page<Quote> getQuotesByAuthorId(String userName, Integer page, Integer size) {
        return quoteRepo.findAllByAuthorId(userName, PageRequest.of(page, size));

    }
}
