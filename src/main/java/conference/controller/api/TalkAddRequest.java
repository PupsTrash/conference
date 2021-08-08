package conference.controller.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TalkAddRequest {
    private String title;
    private String description;
}
