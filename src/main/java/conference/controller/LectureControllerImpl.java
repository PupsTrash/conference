package conference.controller;

import conference.controller.api.ScheduleAddResponse;
import conference.db.Room;
import conference.db.Schedule;
import conference.db.Talk;
import conference.service.ScheduleControllerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lecture")
@AllArgsConstructor
public class ListLecture {

    private final ScheduleControllerService service;
//    private final ScheduleRepo scheduleRepo;
//    private final TalkRepo talkRepo;

    @GetMapping
    public ScheduleAddResponse getAllSchedules() {
        return service.getAllSchedules();
    }

//    @PostMapping
//    public List<Schedule> addSchedule(@RequestParam(name = "title") String title,
//                                      @RequestParam(name = "description") String description,
//                                      @RequestParam(name = "start_at", required = false) LocalDateTime startAt,
//                                      @RequestParam(name = "finish_at", required = false) LocalDateTime finishAt,
//                                      @RequestParam(name = "room_id") String  roomNumber
//                                      ) {
//        Talk talk = new Talk();
//        talk.setTitle(title);
//        talk.setDescription(description);
//        talk.setStartAt(startAt);
//        talk.setFinishAt(finishAt);
//
//        Room room = new Room();
//        room.setNumber(roomNumber);
//
//        Schedule schedule = new Schedule();
//        schedule.setTalk(talk);
//        schedule.setRoom(room);
//        scheduleRepo.save(schedule);
//        final List<Schedule> all = scheduleRepo.findAll();
//        return all;
//    }
}
