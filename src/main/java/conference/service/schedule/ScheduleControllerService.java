package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;

/**
 * method's for Schedule controller service
 */
public interface ScheduleControllerService {

    ScheduleGetResponse getAllSchedules();

    ScheduleAddResponse editAndAddSchedule(AddScheduleRequest request);

    void deleteSchedule(Long id);

    ScheduleGetResponse getScheduleByRoom(String number);
}
