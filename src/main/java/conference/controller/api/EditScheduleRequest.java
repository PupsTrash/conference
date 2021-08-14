package conference.controller.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class EditScheduleRequest {
    @NotNull
    @Schema(example = "2021-08-07T15:05")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime oldStartAt;

    @NotNull
    @Schema(example = "2021-08-07T16:05")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime oldFinishAt;

    @NotNull
    private Long oldRoomId;

    @NotNull
    private Long oldTalkId;



    @NotNull
    @Schema(example = "2021-08-07T16:05")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime editStartAt;

    @NotNull
    @Schema(example = "2021-08-07T17:05")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime editFinishAt;

    @NotNull
    private Long editRoomId;

    @NotNull
    private Long editTalkId;
}
