package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.EditScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;
import conference.db.ScheduleEntity;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import conference.repositories.TalkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleControllerService {
    private final ScheduleRepo scheduleRepo;
    private final ScheduleMapper mapper;
    private final TalkRepo talkRepo;
    private final RoomRepo roomRepo;
    private final ScheduleValidator scheduleValidator;

    public ScheduleGetResponse getAllSchedules() {
        var scheduleList = scheduleRepo.findAll();
        return new ScheduleGetResponse(mapper.toResponse(scheduleList));
    }

    public ScheduleAddResponse addSchedule(AddScheduleRequest request) {
//        откуда берется в AddScheduleRequest roomId, talkId??????
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

    public ScheduleAddResponse editSchedule(EditScheduleRequest request) {
//        смотри комент выше
        return null;
    }
}
