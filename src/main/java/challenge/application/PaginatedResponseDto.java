package challenge.application;

import challenge.domain.Quote;
import challenge.domain.QuoteDB;

import java.util.List;

public record PaginatedResponseDto(List<QuoteDB> quote, int currentPage, int pageSize, Long totalItems) {
}
