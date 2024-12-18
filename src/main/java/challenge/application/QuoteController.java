package challenge.application;

import challenge.domain.Quote;
import challenge.domain.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {


    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping()
    private Quote registerQuotes(@RequestBody Quote request) {
        return quoteService.addQuote(request);
    }

    @GetMapping()
    private PaginatedResponseDto getAllQuotes(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                              @RequestParam(name = "size", defaultValue = "1") Integer size) {
        var quotes = quoteService.getAllQuote(page, size);
        return new PaginatedResponseDto(quoteService.getAllQuote(page, size).getContent(),
                quotes.getNumber(), quotes.getNumberOfElements(),
                quotes.getTotalElements()
        );

    }

    @GetMapping("/authors/{id}")
    private PaginatedResponseDto getAllQuotesByAuthor(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(name = "size", defaultValue = "1") Integer size,
                                                      @PathVariable Long id) {
        var quotes = quoteService.getQuotesByAuthorId(id, page, size);

        return new PaginatedResponseDto(quotes.getContent(),
                quotes.getNumber(), quotes.getNumberOfElements(),
                quotes.getTotalElements()
        );

    }


}
