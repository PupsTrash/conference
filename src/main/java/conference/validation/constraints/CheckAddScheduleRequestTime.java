package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import conference.db.ScheduleEntity;

import java.util.List;


public interface CheckAddScheduleRequestTime {
    /**
     *
     * @param value - request for check
     * @param list - among which the check is performed
     * @return - true - time in request is valid
     */
    Boolean isValidTime(AddScheduleRequest value, List<ScheduleEntity> list);
}
