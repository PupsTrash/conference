package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleGetResponse;
import conference.db.Room;
import conference.db.Schedule;
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

    public ScheduleGetResponse getAllSchedules() {
        var scheduleList = scheduleRepo.findAll();
        return new ScheduleGetResponse(mapper.toResponse(scheduleList));
    }

    public ScheduleAddResponse addSchedule(AddScheduleRequest request) {
        final var talk = talkRepo.findById(request.getTalkId()).orElseThrow();
        final var room = roomRepo.findById(request.getRoomId()).orElseThrow();

        final var schedule = new Schedule();
        schedule.setStartAt(request.getStartAt());
        schedule.setFinishAt(request.getFinishAt());
        schedule.setTalk(talk);
        schedule.setRoom(room);


        //
        var shedules = scheduleRepo.findSchedulesByRoom(room);
        boolean isDateValid = false;

        for (Schedule item :shedules) {
            var isStartValid = !(request.getStartAt().isAfter(item.getStartAt()) && request.getStartAt().isBefore(item.getFinishAt()));
            var isFinishValid = !(request.getFinishAt().isAfter(item.getStartAt()) && request.getFinishAt().isBefore(item.getFinishAt()));

            if (isStartValid && isFinishValid) {
                isDateValid = true;
                break;
            }
        }

        if (!isDateValid) return null;

        var savedSchedule = scheduleRepo.save(schedule);
        final var response = new ScheduleAddResponse();
        response.setDescription(schedule.getTalk().getDescription());
        response.setTitle(schedule.getTalk().getTitle());
        response.setStartAt(schedule.getStartAt());
        response.setFinishAt(schedule.getFinishAt());
        response.setRoomNumber(savedSchedule.getRoom().getNumber());


        return response;
    }

    public ScheduleGetResponse getScheduleByRoom(String number){
        var byRoom = scheduleRepo.findSchedulesByRoom_NumberOrderByStartAt(number);
        return new ScheduleGetResponse(mapper.toResponse(byRoom));
    }
}
