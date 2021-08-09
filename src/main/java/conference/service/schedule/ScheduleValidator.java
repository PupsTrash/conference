package conference.service.schedule;

import conference.db.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleValidator {

    public Boolean isScheduleValid(Schedule item, Schedule request) {
        var isStartValid = !(request.getStartAt().isAfter(item.getStartAt()) && request.getStartAt().isBefore(item.getFinishAt()));
        var isFinishValid = !(request.getFinishAt().isAfter(item.getStartAt()) && request.getFinishAt().isBefore(item.getFinishAt()));
        var isBothValid = !(request.getStartAt().isBefore(item.getStartAt()) && request.getFinishAt().isAfter(item.getFinishAt()));

        return isStartValid && isFinishValid && isBothValid;
    }
}