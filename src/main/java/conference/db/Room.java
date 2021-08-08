package conference.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_GEN")
    @SequenceGenerator(name = "ROOM_GEN", sequenceName = "room_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private Integer number;

    @CreationTimestamp
    private LocalDateTime created_at;
}
