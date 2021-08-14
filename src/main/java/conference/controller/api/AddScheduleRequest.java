package conference.controller.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Schema(example = "2021-08-07T15:05")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startAt;

    @NotNull
    @Schema(example = "2021-08-07T16:05")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime finishAt;

    @NotNull
    private Long roomId;

    @NotNull
    private Long talkId;

}
