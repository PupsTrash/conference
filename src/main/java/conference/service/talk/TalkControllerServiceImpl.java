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

    public List<TalkAddResponse> getAllTalk(){
        return mapper.toResponse(talkRepo.findAll());
    }

    public TalkAddResponse editTalk(String title, String description, TalkAddRequest newRequest){
        final TalkEntity entity = talkRepo.findByTitleAndDescription(title, description);
        entity.setDescription(newRequest.getDescription());
        entity.setTitle(newRequest.getTitle());
        return mapper.toResponse(talkRepo.save(entity));
    }

    public void deleteTalk(TalkAddRequest request){
        talkRepo.delete(talkRepo.findByTitleAndDescription(request.getTitle(), request.getDescription()));
    }
}
