package conference.controller;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;
import conference.service.schedule.Marker;
import conference.validation.constraints.Secondary;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Schedule controller", description = "Common logic with schedules.")
@RequestMapping("/schedule")

public interface ScheduleControllerApi {

    @GetMapping
    ScheduleGetResponse getAllSchedules();

    @GetMapping("/byRoom")
    ScheduleGetResponse getSchedulesByRoom(@RequestParam String number);


    @PostMapping
    /**
     * create Schedule
     * @VlidatedParam Secondary.class - check time in request
     * @VlidatedParam Marker.OnCreate.class - check id - must be Null
     */
    @Validated({Marker.OnCreate.class, Secondary.class})
    ScheduleAddResponse addSchedule(@Valid @RequestBody AddScheduleRequest request);


    @PutMapping
    /**
     * edit Schedule
     * @VlidatedParam Secondary.class - check time in request
     * @VlidatedParam Marker.OnUpdate.class - check id - must be NotNull
     */
    @Validated({Marker.OnUpdate.class, Secondary.class})
    ScheduleAddResponse editSchedule(@Valid @RequestBody AddScheduleRequest request);

    @DeleteMapping
    /**
     * delete Schedule
     * @VlidatedParam Marker.OnUpdate.class - check id - must be NotNull
     */
    @Validated({Marker.OnUpdate.class})
    void deleteSchedule(@Valid @RequestBody AddScheduleRequest request);

}
