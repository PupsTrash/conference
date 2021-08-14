package conference.controller;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Talk controller", description = "Common logic with talk.")
@RequestMapping("/talk")
public interface TalkControllerApi {


    @GetMapping
    List<TalkAddResponse> getAllTalk();

    @PostMapping
    TalkAddResponse addTalk(@RequestBody TalkAddRequest request);

    @PutMapping
    TalkAddResponse editTalk(@RequestParam String title,
                             @RequestParam String description,
                             @RequestBody TalkAddRequest newRequest);

    @DeleteMapping
    void deleteTalk(@RequestBody TalkAddRequest request);


}
