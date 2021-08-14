package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;


public interface CheckScheduleTimeRequest {
    Boolean isValidTime(AddScheduleRequest value);
}
