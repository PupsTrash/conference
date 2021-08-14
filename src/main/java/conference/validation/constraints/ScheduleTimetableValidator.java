package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import conference.db.ScheduleEntity;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class ScheduleTimetableValidator implements ConstraintValidator<ScheduleTimetableValidation, AddScheduleRequest> {


    private final Validator validator;
    private final List<CheckScheduleTimeRequest> requests;

    @Override
    public boolean isValid(AddScheduleRequest value, ConstraintValidatorContext ctx) {
        if (value == null) return false;

        return requests.stream().allMatch(item -> item.isValidTime(value));
    }


}
