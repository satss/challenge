package challenge.quotes.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public record Quote(@JsonProperty("id") Long id, @JsonProperty("quote") String quote,
                    @JsonProperty("author_name") String authorName) {
    public Quote {
        if (quote == null || quote.isEmpty()) {
            throw new IllegalArgumentException("Quote cannot be null or empty");
        }
    }
}
