package conference.service.talk;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.repositories.TalkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TalkControllerService {
    private final TalkRepo talkRepo;
    private final TalkControllerServiceMapper mapper;

    public TalkAddResponse addTalk(TalkAddRequest request) {

        return mapper.toResponse(talkRepo.save(mapper.toEntity(request)));
    }
}
