package conference.service.talk;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.db.TalkEntity;
import conference.repositories.TalkRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TalkControllerServiceImpl implements TalkControllerService {
    private final TalkRepo talkRepo;
    private final TalkControllerServiceMapper mapper;


    public TalkAddResponse addTalk(TalkAddRequest request) {
        return mapper.toResponse(talkRepo.save(mapper.toEntity(request)));
    }

    public List<TalkAddResponse> getAllTalk() {
        return mapper.toResponse(talkRepo.findAll());
    }

    public TalkAddResponse editTalk(TalkAddRequest request) {
        final TalkEntity entity = talkRepo.findById(request.getId()).orElseThrow();
        entity.setDescription(request.getDescription());
        entity.setTitle(request.getTitle());
        return mapper.toResponse(talkRepo.save(entity));
    }

    public void deleteTalk(TalkAddRequest request) {
        talkRepo.delete(talkRepo.findById(request.getId()).orElseThrow());
    }
}
