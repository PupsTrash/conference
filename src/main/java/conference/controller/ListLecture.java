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

import java.sql.Timestamp;

@RestController
@AllArgsConstructor
public class ListLecture {

    private final ScheduleRepo scheduleRepo;
    private final TalkRepo talkRepo;

    @GetMapping("/lecture")
    public Iterable<Schedule> allSchedule() {
        Iterable<Schedule> scheduleRepoAll = scheduleRepo.findAll();

        return scheduleRepoAll;
    }

    @PostMapping("/lecture")
    public Iterable<Schedule> addSchedule(@RequestParam(name = "title") String title,
                                      @RequestParam(name = "description") String description,
                                      @RequestParam(name = "start_at", required = false) Timestamp startAt,
                                      @RequestParam(name = "finish_at", required = false) Timestamp finishAt,
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

        return scheduleRepo.findAll();
    }
}
