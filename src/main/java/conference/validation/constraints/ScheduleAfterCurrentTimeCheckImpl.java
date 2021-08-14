package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class ScheduleAfterCurrentTimeCheckImpl implements CheckScheduleTimeRequest{
    @Override
    public Boolean isValidTime(AddScheduleRequest value) {
        return value.getStartAt().isAfter(LocalDateTime.now()) && value.getStartAt().isBefore(value.getFinishAt());
    }
}
