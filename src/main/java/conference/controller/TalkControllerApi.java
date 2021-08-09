package conference.controller;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Talk controller", description = "Common logic with talk.")
@RequestMapping("/talk")
public interface TalkControllerApi {

    @PostMapping
    TalkAddResponse addTalk(@RequestBody TalkAddRequest request);

}
