package conference.controller;

import conference.db.Room;
import conference.db.Schedule;
import conference.db.Talk;
import conference.repositories.ScheduleRepo;
import conference.repositories.TalkRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class ListLecture {

    private final ScheduleRepo scheduleRepo;
    private final TalkRepo talkRepo;

    @GetMapping("/lecture")
    public List<Schedule> allSchedule() {
        List<Schedule> scheduleRepoAll = scheduleRepo.findAll();
        return scheduleRepoAll;
    }

    @PostMapping("/lecture")
    public List<Schedule> addSchedule(@RequestParam(name = "title") String title,
                                      @RequestParam(name = "description") String description,
                                      @RequestParam(name = "start_at", required = false) LocalDateTime startAt,
                                      @RequestParam(name = "finish_at", required = false) LocalDateTime finishAt,
                                      @RequestParam(name = "room_id") Integer roomNumber
                                      ) {
        Talk talk = new Talk();
        talk.setTitle(title);
        talk.setDescription(description);
        talk.setStart_at(startAt);
        talk.setFinish_at(finishAt);

        Room room = new Room();
        room.setNumber(roomNumber);

        Schedule schedule = new Schedule();
        schedule.setScheduleTalk(talk);
        schedule.setScheduleRoom(room);
        scheduleRepo.save(schedule);
        final List<Schedule> all = scheduleRepo.findAll();
        return all;
    }
}
