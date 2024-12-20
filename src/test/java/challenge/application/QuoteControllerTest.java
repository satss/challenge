package challenge.application;


import challenge.quotes.application.QuoteController;
import challenge.quotes.domain.Quote;
import challenge.quotes.domain.QuoteDto;
import challenge.quotes.domain.QuoteRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.stream.Stream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Import(MysqlConfig.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class QuoteControllerTest {

    @Autowired
    QuoteRepo quoteRepo;

    @Autowired
    QuoteController quoteController;

    @BeforeEach
    void setUp() {
        quoteRepo.deleteAll();
    }


    @Test
    void verifyTheDatabaseIsNotEmpty() {
        var quote = new Quote(null, "In three words " +
                "I can sum up everything I've learned about life: It goes on", "sata");
        Long quoteId = quoteRepo.save(quote).getId();
        Assertions.assertThat(quoteRepo.findById(quoteId).get()).isNotNull();
    }

    @Test
    @WithMockUser(username = "Janina@89", password = "pass", roles = "WRITER")
    void registerQuote() {
        var quote = new QuoteDto(null, "In three words I can sum up everything " +
                "I've learned about life: It goes on", null);
        var savedQuote = quoteController.registerQuotes(quote);
        var foundQuote = quoteRepo.findById(savedQuote.getBody().id());
        Assertions.assertThat(foundQuote).isNotNull();
        Assertions.assertThat(foundQuote.get().getAuthorUsername()).isEqualTo("Janina@89");

    }

    @Test
    @WithMockUser(username = "Janina@89", password = "pass", roles = "WRITER")
    void findAllQuotes() {
        var quote = new QuoteDto(null, "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock"
                , null);
        var savedQuote = quoteController.registerQuotes(quote);
        var paginatedResponse = quoteController.getAllQuotes(0, 10);
        Assertions.assertThat(paginatedResponse.quotes()).isNotNull();
        Assertions.assertThat(paginatedResponse.totalItems()).isEqualTo(1);

    }


    @Test
    @WithMockUser(username = "James", password = "pass", roles = "WRITER")
    void findAllQuotesBySpecificAuthor() {
        var requestOne = new QuoteDto(null, "Everything everyone all at once-Phase I", null);
        var requestTwo = new QuoteDto(null, "Everything everyone all at once-Phase II", null);
        var requestThree = new QuoteDto(null, "Everything everyone all at once-Phase III", null);

        quoteController.registerQuotes(requestOne);
        quoteController.registerQuotes(requestTwo);
        quoteController.registerQuotes(requestThree);
        var paginatedResponseBySpecificUser = quoteController.getAllQuotesByAuthor(0, 10, "James");
        Assertions.assertThat(paginatedResponseBySpecificUser.quotes()).isNotNull();
        Assertions.assertThat(paginatedResponseBySpecificUser.totalItems()).isEqualTo(3);


    }


    static Stream<QuoteDto> getQuoteDtos() {
        return Stream.of(new QuoteDto(null, "While you may find me but not yet", null),
         new QuoteDto(null, "While you may find me but not yet-Part2", null),
         new QuoteDto(null, "While you may find me but not yet", null));
    }

    @ParameterizedTest
    @WithMockUser(username = "Janina@89", password = "pass", roles = "WRITER")
    @MethodSource("getQuoteDtos")
    void registerMultipleQuotes(QuoteDto request) {
        var savedQuote = quoteController.registerQuotes(request);
        var foundQuote = quoteRepo.findById(savedQuote.getBody().id());
        Assertions.assertThat(foundQuote).isNotNull();

    }





}