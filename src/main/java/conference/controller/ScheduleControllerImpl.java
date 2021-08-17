package conference.controller;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;
import conference.service.schedule.ScheduleControllerService;
import conference.validation.constraints.Secondary;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated({Secondary.class})
public class ScheduleControllerImpl implements ScheduleControllerApi {

    private final ScheduleControllerService service;


    @Override
    public ScheduleGetResponse getAllSchedules() {
        return service.getAllSchedules();
    }

    @Override
    public ScheduleGetResponse getSchedulesByRoom(String number) {
        return service.getScheduleByRoom(number);
    }

    @Override
    public ScheduleAddResponse addSchedule(AddScheduleRequest request) {
        return service.editAndAddSchedule(request);
    }

    @Override
    public ScheduleAddResponse editSchedule(AddScheduleRequest request) {
        return service.editAndAddSchedule(request);
    }

    @Override
    public void deleteSchedule(AddScheduleRequest request) {
        service.deleteSchedule(request.getId());
    }


}
