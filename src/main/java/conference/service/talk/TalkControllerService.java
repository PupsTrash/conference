package conference.service.talk;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;

import java.util.List;

/**
 * main method`s Talk Service for Talk controller
 */
public interface TalkControllerService {

    TalkAddResponse addTalk(TalkAddRequest request);

    List<TalkAddResponse> getAllTalk();

    TalkAddResponse editTalk(TalkAddRequest request);

    void deleteTalk(TalkAddRequest request);
}
