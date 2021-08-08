package conference.service.talk;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.db.Talk;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TalkControllerServiceMapper {

    public abstract Talk toEntity(TalkAddRequest request);
    public abstract TalkAddResponse toResponse(Talk entity);
}
