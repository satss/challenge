package challenge.application;

public record QuoteRequestDto(String quote) {

     public QuoteRequestDto {
         if (quote == null || quote.isEmpty()) {
             throw new IllegalArgumentException("Quote cannot be null or empty");
         }
     }
}
