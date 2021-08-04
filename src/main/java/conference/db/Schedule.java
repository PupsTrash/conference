package conference.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Schedule {
    @Id
    private Long id;

    private Long talk_id;
    private Long room_id;
}
