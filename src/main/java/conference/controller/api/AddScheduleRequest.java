package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddScheduleRequest {
    @Schema(example = "2021-01-31T11:01:55")
    private LocalDateTime startAt;

    @Schema(example = "2021-01-31T12:30:01")
    private LocalDateTime finishAt;

    @Schema(example = "1")
    private Long roomId;

    @Schema(example = "1")
    private Long talkId;

}
