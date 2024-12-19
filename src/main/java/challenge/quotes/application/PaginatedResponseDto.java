package challenge.quotes.application;

import challenge.quotes.domain.Quote;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PaginatedResponseDto(@JsonProperty("quotes") List<Quote> quotes,
                                   @JsonProperty("total_pages") int totalPages,
                                   @JsonProperty ("page") int currentPage,
                                   @JsonProperty("total_items") long totalItems
                                   ) {
}
