package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import conference.db.Schedule;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ScheduleTimetableValidator implements ConstraintValidator<ScheduleTimetableValidation, AddScheduleRequest> {

    private final ScheduleRepo scheduleRepo;
    private final RoomRepo roomRepo;
    private final Validator validator;

    @Override
    public boolean isValid(AddScheduleRequest value, ConstraintValidatorContext ctx) {
        if (value == null) return false;

        final var room = roomRepo.findById(value.getRoomId()).orElseThrow();
        final var list = scheduleRepo.findSchedulesByRoom(room);

        final var validatorRequest = new ScheduleRequestInternal(value.getStartAt(), value.getFinishAt());

        return list.stream().allMatch(item -> isScheduleValid(item, validatorRequest));
    }

    @Data
    @AllArgsConstructor
    class ScheduleRequestInternal {
        private LocalDateTime startAt;
        private LocalDateTime finishAt;
    }

    private Boolean isScheduleValid(Schedule item, ScheduleRequestInternal request) {
        var isStartValid = !(request.getStartAt().isAfter(item.getStartAt()) && request.getStartAt().isBefore(item.getFinishAt()));
        var isFinishValid = !(request.getFinishAt().isAfter(item.getStartAt()) && request.getFinishAt().isBefore(item.getFinishAt()));
        var isBothValid = !(request.getStartAt().isBefore(item.getStartAt()) && request.getFinishAt().isAfter(item.getFinishAt()));

        var a = request.getStartAt().isAfter(item.getStartAt());

        return isStartValid && isFinishValid && isBothValid;
    }
}
