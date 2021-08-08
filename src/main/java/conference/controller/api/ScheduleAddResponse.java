package conference.controller.api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleAddResponse {

    private LocalDateTime startAt;

    private LocalDateTime finishAt;

    private String title;

    private String description;

    private String roomNumber;
}
