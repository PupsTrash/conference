package conference.validation.constraints;

import conference.controller.api.AddScheduleRequest;
import conference.db.ScheduleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class OverlapTimeCheckImpl implements CheckAddScheduleRequestTime {

    @Override
    public Boolean isValidTime(AddScheduleRequest value, List<ScheduleEntity> list) {

        final var validatorRequest = new OverlapTimeCheckImpl.ScheduleRequestInternal(value.getStartAt(), value.getFinishAt());
        return list.stream().allMatch(item -> isScheduleValid(item, validatorRequest));
    }

    public Boolean isScheduleValid(ScheduleEntity item, ScheduleRequestInternal request) {


        if (request.getStartAt().isEqual(item.getStartAt())) {
            return false;
        }
        if(request.getFinishAt().isEqual(item.getFinishAt())){return false;}

        /**
         * request startAt is not in the border item time
         * ..!req............StartAt--???.........
         * ..item.......|--------------|.........
         */
        var isStartValid = !(request.getStartAt().isAfter(item.getStartAt()) && request.getStartAt().isBefore(item.getFinishAt()));

        /** request FinishAt is not in the border item time
         * ..!req............???---F.........
         * ..item.........|-----------|.........
         */
        var isFinishValid = !(request.getFinishAt().isAfter(item.getStartAt()) && request.getFinishAt().isBefore(item.getFinishAt()));

        /** item time is not in the request item time
         * ..!req.......S-------------F.........
         * ..item..........|------|.........
         */
        var isBothValid = !(request.getStartAt().isBefore(item.getStartAt()) & request.getFinishAt().isAfter(item.getFinishAt()));


        return isStartValid && isFinishValid && isBothValid;
    }

    @Data
    @AllArgsConstructor
    class ScheduleRequestInternal {
        private LocalDateTime startAt;
        private LocalDateTime finishAt;
    }
}
