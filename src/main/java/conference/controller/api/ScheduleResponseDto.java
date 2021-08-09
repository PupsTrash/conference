package conference.controller.api;

import conference.db.Room;
import conference.db.Talk;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "2021-01-31T11:01:55", description = "Have to be before finish_at field")
    private LocalDateTime startAt;

    @Schema(example = "2021-01-31T12:30:01")
    private LocalDateTime finishAt;

    @Schema(example = "JUG.ru java")
    private String title;

    @Schema(example = "Common description")
    private String description;

    @Schema(example = "122a")
    private String roomNumber;
}
