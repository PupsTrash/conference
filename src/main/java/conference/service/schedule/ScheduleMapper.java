package conference.service.schedule;

import conference.controller.api.AddScheduleRequest;
import conference.controller.api.ScheduleAddResponse;
import conference.controller.api.ScheduleResponseDto;
import conference.db.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ScheduleMapper {

    public abstract List<ScheduleResponseDto> toResponse(List<Schedule> scheduleList);

    @Mapping(target = "title", source = "talk.title")
    @Mapping(target = "description", source = "talk.description")
    @Mapping(target = "roomNumber", source = "room.number")
    //надо ли тут добавить startAt & finishAt или они и так тут будут из-за одинаковых имен?
    public abstract ScheduleResponseDto toResponse(Schedule schedule);


    @Mapping(target = "room.id", source = "roomId")
    @Mapping(target = "talk.id", source = "talkId")
    public abstract Schedule toEntity(AddScheduleRequest addScheduleRequest);

    @Mapping(target = "title", source = "talk.title")
    @Mapping(target = "description", source = "talk.description")
    @Mapping(target = "roomNumber", source = "room.number")
    public abstract ScheduleAddResponse toAddResponses(Schedule schedule);
}
