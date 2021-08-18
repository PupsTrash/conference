package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleAddResponse {
    @Schema(example = "2021-01-31 11:01")
    private LocalDateTime startAt;

    @Schema(example = "2021-01-31 12:30")
    private LocalDateTime finishAt;

    @Schema(example = "JUG.ru java")
    private String title;

    @Schema(example = "Common description")
    private String description;

    @Schema(example = "1a")
    private String roomNumber;
}
