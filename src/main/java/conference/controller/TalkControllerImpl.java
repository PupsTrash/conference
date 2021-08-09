package conference.controller;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.service.talk.TalkControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TalkControllerImpl implements TalkControllerApi {
    private final TalkControllerService service;

    @Override
    public TalkAddResponse addTalk(@RequestBody TalkAddRequest request) {
        return service.addTalk(request);
    }
}
