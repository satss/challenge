package challenge.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "quotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quote;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_user_name")
    private String authorUsername;


    public QuoteDB(String quote, Long authorId, String authorUsername) {
        this.quote = quote;
        this.authorId = authorId;
        this.authorUsername = authorUsername;
    }

}
