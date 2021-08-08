package conference.controller.api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddScheduleRequest {
    
    private LocalDateTime startAt;
    private LocalDateTime finishAt;
    private Long roomId;
    private Long talkId;
    
}
