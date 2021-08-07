package conference.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "talk")
@Data
@NoArgsConstructor
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TALK_GEN")
    @SequenceGenerator(name = "TALK_GEN", sequenceName = "talk_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String title;
    private String description;
    private Timestamp start_at;
    private Timestamp finish_at;

    @CreationTimestamp
    private Timestamp created_at;
}
