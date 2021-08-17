package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ScheduleTimetableValidator implements ConstraintValidator<ScheduleTimetableValidation, AddScheduleRequest> {

    private final ScheduleRepo scheduleRepo;
    private final RoomRepo roomRepo;
    private final List<CheckAddScheduleRequestTime> requests;

    @Override
    public boolean isValid(AddScheduleRequest value, ConstraintValidatorContext ctx) {
        if (value == null) return false;

        final var room = roomRepo.findById(value.getRoomId()).orElseThrow();
        final var list = new ArrayList<>(scheduleRepo.findScheduleEntityByRoomEntity(room));
        if (value.getId() != null) {
            list.removeIf(p -> p.getId() == value.getId());
        }
        return requests.stream().allMatch(item -> item.isValidTime(value, list));
    }


}
