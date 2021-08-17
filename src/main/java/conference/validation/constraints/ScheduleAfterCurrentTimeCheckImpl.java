package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleAfterCurrentTimeCheckImpl implements CheckAddScheduleRequestTime {

    /** check request time not in past and start is before finish
     */
    @Override
    public Boolean isValidTime(AddScheduleRequest value) {
        return value.getStartAt().isAfter(LocalDateTime.now()) && value.getStartAt().isBefore(value.getFinishAt());
    }
}
