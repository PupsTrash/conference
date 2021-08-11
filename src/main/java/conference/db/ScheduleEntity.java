package conference.db;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULE_GEN")
    @SequenceGenerator(name = "SCHEDULE_GEN", sequenceName = "schedule_seq", allocationSize = 1)

    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "talk_id")
    private TalkEntity talkEntity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    private LocalDateTime startAt;
    private LocalDateTime finishAt;

    @CreationTimestamp
    private OffsetDateTime created_at;
}
