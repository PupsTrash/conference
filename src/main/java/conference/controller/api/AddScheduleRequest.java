package conference.controller.api;

import conference.validation.constraints.ScheduleTimetableValidation;
import conference.validation.constraints.Secondary;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@ScheduleTimetableValidation(groups = {Secondary.class})
public class AddScheduleRequest {

    @NotNull
    @Schema(example = "2021-01-31T11:01:55")
    private LocalDateTime startAt;

    @NotNull
    @Schema(example = "2021-01-31T12:30:01")
    private LocalDateTime finishAt;

    @NotNull
    private Long roomId;

    @NotNull
    private Long talkId;

}
