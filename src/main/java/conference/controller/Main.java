package conference.controller;

import conference.db.Room;
import conference.db.Schedule;
import conference.db.Talk;
import conference.repositories.RoomRepo;
import conference.repositories.ScheduleRepo;
import conference.repositories.TalkRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class Main {
private TalkRepo talkRepo;
private RoomRepo roomRepo;
private final ScheduleRepo scheduleRepo;


    @GetMapping("/main")
    public Optional<Schedule> main(){

        final Optional<Schedule> schedule = scheduleRepo.findById(1L);
        return schedule;
    }


    @GetMapping("/room")
    public String room(){
        Room room = new Room();
        room.setNumber(1);
        roomRepo.save(room);
        return "check this shit fuck";

    }
}
