package conference.service.talk;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.db.TalkEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TalkControllerServiceMapper {

    public abstract TalkEntity toEntity(TalkAddRequest request);
    public abstract TalkAddResponse toResponse(TalkEntity entity);
}
