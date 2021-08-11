package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
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

        final var talk = talkRepo.findById(request.getTalkId()).orElseThrow();
        final var room = roomRepo.findById(request.getRoomId()).orElseThrow();


        final var schedule = new ScheduleEntity();
        schedule.setStartAt(request.getStartAt());
        schedule.setFinishAt(request.getFinishAt());
        schedule.setTalkEntity(talk);
        schedule.setRoomEntity(room);
        //
        var shedules = scheduleRepo.findScheduleEntityByRoomEntity(room);
//        boolean isDateValid = false;
        for (ScheduleEntity item :shedules) {
//            var isStartValid = !(request.getStartAt().isAfter(item.getStartAt()) && request.getStartAt().isBefore(item.getFinishAt()));
//            var isFinishValid = !(request.getFinishAt().isAfter(item.getStartAt()) && request.getFinishAt().isBefore(item.getFinishAt()));
            if (!scheduleValidator.isScheduleValid(item, schedule)) {
                throw new RuntimeException();
//                break;
            }
        }

//        if (!isDateValid) return null;
        var savedSchedule = scheduleRepo.save(schedule);
//        final var response = new ScheduleAddResponse();
//        response.setDescription(schedule.getTalk().getDescription());
//        response.setTitle(schedule.getTalk().getTitle());
//        response.setStartAt(schedule.getStartAt());
//        response.setFinishAt(schedule.getFinishAt());
//        response.setRoomNumber(savedSchedule.getRoom().getNumber());
//
//
//        return response;
        return mapper.toAddResponses(savedSchedule);
    }

    public ScheduleGetResponse getScheduleByRoom(String number){
        var byRoom = scheduleRepo.findScheduleEntityByRoomEntity_NumberOrderByStartAt(number);
        return new ScheduleGetResponse(mapper.toResponse(byRoom));
    }
}
