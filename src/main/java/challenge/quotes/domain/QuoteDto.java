package challenge.quotes.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public record QuoteDto(@JsonProperty("id") Long id, @JsonProperty("quote") String quote,
                       @JsonProperty("author_name") String authorName){
    public QuoteDto {
        if (quote == null || quote.isEmpty()) {
            throw new IllegalArgumentException("Quote cannot be null or empty");
        }
        if (quote.length() > 1000) {
            throw new IllegalArgumentException("Quote cannot be longer than 1000 characters");
        }
    }
}
