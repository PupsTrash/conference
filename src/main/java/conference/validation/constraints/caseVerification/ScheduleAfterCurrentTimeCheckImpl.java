package conference.validation.constraints.caseVerification;

import conference.controller.api.AddScheduleRequest;
import conference.db.ScheduleEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduleAfterCurrentTimeCheckImpl implements CheckAddScheduleRequestTime {

    /** check request time not in past and start is before finish
     */
    @Override
    public Boolean isValidTime(AddScheduleRequest value, List<ScheduleEntity> list) {
        return value.getStartAt().isAfter(LocalDateTime.now()) && value.getStartAt().isBefore(value.getFinishAt());
    }
}
