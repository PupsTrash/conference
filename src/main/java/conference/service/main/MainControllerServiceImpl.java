package conference.service.main;

import conference.controller.api.ScheduleGetResponse;
import conference.repositories.RoomRepo;
import conference.service.schedule.ScheduleControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainControllerServiceImpl implements MainControllerService {
    private final ScheduleControllerService scheduleControllerService;
    private final RoomRepo roomRepo;

    @Override
    public List<ScheduleGetResponse> getAllScheduleByRoom() {
        var listRoom = roomRepo.findAll().stream().map(p -> p.getNumber()).distinct().collect(Collectors.toList());
        List<ScheduleGetResponse> list = new ArrayList<>();
        for (String roomNumber : listRoom) {

            final ScheduleGetResponse scheduleByRoom = scheduleControllerService.getScheduleByRoom(roomNumber);
            list.add(scheduleByRoom);
        }
        return list;
    }
}
