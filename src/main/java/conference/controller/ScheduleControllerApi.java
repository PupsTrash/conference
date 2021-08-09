package conference.controller;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Schedule controller", description = "Common logic with schedules.")
@RequestMapping("/schedule")
public interface ScheduleControllerApi {

    @GetMapping
    ScheduleGetResponse getAllSchedules();

    @GetMapping("/byRoom")
    ScheduleGetResponse getSchedulesByRoom(@RequestParam String number);


    @PostMapping
    ScheduleAddResponse addSchedule(@RequestBody AddScheduleRequest request);
}
