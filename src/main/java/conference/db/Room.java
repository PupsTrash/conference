package conference.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
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
    private Timestamp created_at;
}
