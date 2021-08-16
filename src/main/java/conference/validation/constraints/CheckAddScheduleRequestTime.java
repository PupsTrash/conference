package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;


public interface CheckAddScheduleRequestTime {
    Boolean isValidTime(AddScheduleRequest value);
}
