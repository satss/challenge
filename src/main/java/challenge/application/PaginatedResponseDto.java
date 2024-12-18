package challenge.application;

import challenge.domain.QuoteDB;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PaginatedResponseDto(@JsonProperty("quotes") List<QuoteDB> quotes,
                                   @JsonProperty ("current_page_size") int currentPage,
                                   int pageSize, Long totalItems) {
}
