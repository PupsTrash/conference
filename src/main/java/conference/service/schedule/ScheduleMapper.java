package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleResponseDto;
import conference.db.Room;
import conference.db.Schedule;
import conference.db.Talk;
import conference.repositories.RoomRepo;
import conference.repositories.TalkRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScheduleMapper {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private TalkRepo talkRepo;

    public abstract List<ScheduleResponseDto> toResponse(List<Schedule> scheduleList);

    @Mapping(target = "title", source = "talk.title")
    @Mapping(target = "description", source = "talk.description")
    @Mapping(target = "roomNumber", source = "room.number")
    //надо ли тут добавить startAt & finishAt или они и так тут будут из-за одинаковых имен?
    public abstract ScheduleResponseDto toResponse(Schedule schedule);


    @Mapping(target = "room", source = "roomId", qualifiedByName = "fromIdToRoom")
    @Mapping(target = "talk", source = "talkId", qualifiedByName = "fromIdToTalk")
    public abstract Schedule toEntity(AddScheduleRequest addScheduleRequest);

    @Named("fromIdToRoom")
    protected Room fromIdToRoom(Long id) {
        return roomRepo.getById(id);
    }

    @Named("fromIdToTalk")
    protected Talk fromIdToTalk(Long id) {
        return talkRepo.getById(id);
    }

    @Mapping(target = "title", source = "talk.title")
    @Mapping(target = "description", source = "talk.description")
    @Mapping(target = "roomNumber", source = "room.number")
    public abstract ScheduleAddResponse toAddResponses(Schedule schedule);
}
