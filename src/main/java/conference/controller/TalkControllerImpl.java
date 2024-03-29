package conference.controller;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.service.talk.TalkControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TalkControllerImpl implements TalkControllerApi {
    private final TalkControllerService service;


    @Override
    public List<TalkAddResponse> getAllTalk() {
        return service.getAllTalk();
    }

    @Override
    public TalkAddResponse addTalk(TalkAddRequest request) {
        return service.addTalk(request);
    }

    @Override
    public TalkAddResponse editTalk(TalkAddRequest request) {
        return service.editTalk(request);
    }

    @Override
    public void deleteTalk(TalkAddRequest request) {
        service.deleteTalk(request);
    }
}
