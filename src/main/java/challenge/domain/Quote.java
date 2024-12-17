package challenge.domain;

import jakarta.persistence.Entity;

public record Quote(String quote) {
    public Quote {
     if (quote == null || quote.isEmpty()) {
        throw new IllegalArgumentException("Quote cannot be null or empty");
    }
    }
}
