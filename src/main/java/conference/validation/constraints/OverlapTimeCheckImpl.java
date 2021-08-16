package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleResponseDto;
import conference.db.ScheduleEntity;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OverlapTimeCheckImpl implements CheckAddScheduleRequestTime {
    private final ScheduleRepo scheduleRepo;
    private final RoomRepo roomRepo;

    @Override
    public Boolean isValidTime(AddScheduleRequest value) {
        final var room = roomRepo.findById(value.getRoomId()).orElseThrow();
        final var list = scheduleRepo.findScheduleEntityByRoomEntity(room).stream().
                filter(p -> p.getFinishAt().isEqual(value.getFinishAt())).collect(Collectors.toList());

        list.removeIf(p -> p.getId() == value.getId());


        final var validatorRequest = new OverlapTimeCheckImpl.ScheduleRequestInternal(value.getStartAt(), value.getFinishAt());
        return list.stream().allMatch(item -> isScheduleValid(item, validatorRequest));
    }



    @Data
    @AllArgsConstructor
    class ScheduleRequestInternal {
        private LocalDateTime startAt;
        private LocalDateTime finishAt;
    }


    private Boolean isScheduleValid(ScheduleEntity item, ScheduleRequestInternal request) {

        if (request.getStartAt().isEqual(item.getStartAt())){
            return false;
        }
        //..!req............S--???.........
        //..item.......|--------------|.........
        var isStartValid = !(request.getStartAt().isAfter(item.getStartAt()) && request.getStartAt().isBefore(item.getFinishAt()));

        //..!req............???---F.........
        //..item.........|-----------|.........
        var isFinishValid = !(request.getFinishAt().isAfter(item.getStartAt()) && request.getFinishAt().isBefore(item.getFinishAt()));

        //..!req.......S-----------F.........
        //..item..........|------|.........
        var isBothValid = !(request.getStartAt().isBefore(item.getStartAt()) && request.getFinishAt().isAfter(item.getFinishAt()));

        var a = request.getStartAt().isAfter(item.getStartAt());

        return isStartValid && isFinishValid && isBothValid;
    }
}
