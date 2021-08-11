package conference.controller.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
//@Builder need it?
public class TalkAddResponse {

    @Schema(example = "JUG.ru java")
    private String title;

    @Schema(example = "Common description")
    private String description;
}
