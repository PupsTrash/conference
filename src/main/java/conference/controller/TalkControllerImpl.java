package conference.controller;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import conference.service.talk.TalkControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/talk")
@RestController
@RequiredArgsConstructor
public class TalkControllerImpl {
    private final TalkControllerService service;

    @PostMapping
    public TalkAddResponse addTalk(@RequestBody TalkAddRequest request) {
        return service.addTalk(request);
    }
}
