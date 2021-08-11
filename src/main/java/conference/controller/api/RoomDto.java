package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RoomDto {
    @Schema(example = "1a", description = "number (name) Room")
    private String numberRoom;

    @Schema(example = "1")
    private Long idRoom;
}
