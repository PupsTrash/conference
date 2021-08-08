package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;
import conference.repositories.ScheduleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleControllerService {
    private final ScheduleRepo scheduleRepo;
    private final ScheduleMapper mapper;

    public ScheduleGetResponse getAllSchedules() {
        var scheduleList = scheduleRepo.findAll();
        return new ScheduleGetResponse(mapper.toResponse(scheduleList));
    }

    public ScheduleAddResponse addSchedule(AddScheduleRequest request) {
        
    }
}
