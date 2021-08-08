package conference.controller.api;

import conference.db.Room;
import conference.db.Talk;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


// TALK
// start, finish, talkTitle, talkDescription, talkRoomNumber
// 112a

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponseDto {

    private LocalDateTime startAt;

    private LocalDateTime finishAt;

    private String title;

    private String description;

    private String roomNumber;
}
