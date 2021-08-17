package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    private Long id;
}
