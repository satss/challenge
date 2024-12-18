package challenge.quotes.application;

import challenge.quotes.domain.QuoteDB;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PaginatedResponseDto(@JsonProperty("quotes") List<QuoteDB> quotes,
                                   @JsonProperty ("current_page_size") int currentPage,
                                   @JsonProperty("passed_page_size") int pageSize,
                                   @JsonProperty("total_no_items") Long totalItems) {
}
