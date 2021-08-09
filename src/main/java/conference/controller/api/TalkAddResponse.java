package conference.controller.api;

import lombok.Data;

@Data
//@Builder need it?
public class TalkAddResponse {
    private String title;
    private String description;
}
