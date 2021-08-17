package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data

public class TalkAddRequest {
    @Schema(example = "JUG.ru java")
    private String title;

    @Schema(example = "Common description")
    private String description;

    private Long id;
}
