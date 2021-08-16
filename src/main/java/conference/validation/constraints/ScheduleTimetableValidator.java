package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@AllArgsConstructor
public class ScheduleTimetableValidator implements ConstraintValidator<ScheduleTimetableValidation, AddScheduleRequest> {

    private final List<CheckAddScheduleRequestTime> requests;

    @Override
    public boolean isValid(AddScheduleRequest value, ConstraintValidatorContext ctx) {
        if (value == null) return false;

        return requests.stream().allMatch(item -> item.isValidTime(value));
    }


}
