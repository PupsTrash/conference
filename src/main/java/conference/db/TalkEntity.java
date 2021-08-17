package conference.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "talk")
@Getter
@Setter
@NoArgsConstructor
public class TalkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TALK_GEN")
    @SequenceGenerator(name = "TALK_GEN", sequenceName = "talk_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String title;
    private String description;


    @CreationTimestamp
    private OffsetDateTime createdAt;
}
