package challenge.quotes.application;

import challenge.quotes.domain.QuoteDto;
import challenge.quotes.domain.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public QuoteDto registerQuotes(@RequestBody QuoteDto request) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            return quoteService.addQuote(request, userDetails.getUsername());

        }catch (Exception e){
            throw new IllegalStateException("Could not register new quote");
        }

    }

    @GetMapping()
    public PaginatedResponseDto getAllQuotes(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                              @RequestParam(name = "size", defaultValue = "10") Integer size) {
        var quotes = quoteService.getAllQuote(page, size);
        return new PaginatedResponseDto(quoteService.getAllQuote(page, size).getContent(),
                quotes.getTotalPages(), quotes.getNumber(),
                quotes.getTotalElements()
        );

    }

    @GetMapping("/authors/{userName}")
    public PaginatedResponseDto getAllQuotesByAuthor(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(name = "size", defaultValue = "10") Integer size,
                                                      @PathVariable String userName) {

        var quotes = quoteService.getQuotesByAuthorId(userName, page, size);
        return new PaginatedResponseDto(quotes.getContent(),
                quotes.getTotalPages(), quotes.getNumber(),
                quotes.getTotalElements()
        );

    }


}
