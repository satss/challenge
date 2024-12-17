package challenge.application;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {

    @PostMapping()
    private String  registerQuotes(@RequestBody QuoteRequestDto request) {
        return "hey there a quote is registered";


    }
}
