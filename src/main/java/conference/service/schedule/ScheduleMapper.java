package conference.service.schedule;

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
    public abstract ScheduleResponseDto toResponse(Schedule schedule);
}
