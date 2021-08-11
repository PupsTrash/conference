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
    private LocalDateTime startAt;

    @NotNull
    private LocalDateTime finishAt;

    @NotNull
    private Long roomId;

    @NotNull
    private Long talkId;

}
