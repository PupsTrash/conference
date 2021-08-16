package conference.service.schedule;

import conference.controller.api.*;
import conference.db.ScheduleEntity;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import conference.repositories.TalkRepo;
import conference.validation.constraints.Primary;
import conference.validation.constraints.ScheduleTimetableValidation;
import conference.validation.constraints.Secondary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Service

@RequiredArgsConstructor
public class ScheduleControllerService {
    private final ScheduleRepo scheduleRepo;
    private final ScheduleMapper mapper;
    private final TalkRepo talkRepo;
    private final RoomRepo roomRepo;

    public ScheduleGetResponse getAllSchedules() {
        var scheduleList = scheduleRepo.findAll();
        return new ScheduleGetResponse(mapper.toResponse(scheduleList));
    }

    public ScheduleAddResponse addSchedule(AddScheduleRequest request) {
        final var talk = talkRepo.findById(request.getTalkId()).orElseThrow();
        final var room = roomRepo.findById(request.getRoomId()).orElseThrow();

        final var schedule = new ScheduleEntity();
        schedule.setStartAt(request.getStartAt());
        schedule.setFinishAt(request.getFinishAt());
        schedule.setTalkEntity(talk);
        schedule.setRoomEntity(room);
        var savedSchedule = scheduleRepo.save(schedule);
        return mapper.toAddResponses(savedSchedule);
    }

    public ScheduleGetResponse getScheduleByRoom(String number){
        var byRoom = scheduleRepo.findScheduleEntityByRoomEntity_NumberOrderByStartAt(number);
        return new ScheduleGetResponse(mapper.toResponse(byRoom));
    }


}
