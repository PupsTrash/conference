package conference.controller;

import conference.controller.api.ScheduleGetResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Schedule controller", description = "Common logic with schedules.")
@RequestMapping("/schedule")
public interface ScheduleControllerApi {

    @GetMapping
    ScheduleGetResponse getAllSchedules();
}
