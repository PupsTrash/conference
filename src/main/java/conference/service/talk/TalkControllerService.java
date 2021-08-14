package conference.service.talk;

import conference.controller.api.TalkAddRequest;
import conference.controller.api.TalkAddResponse;

import java.util.List;
/**
 * main method`s Talk Service for Talk controller
 */
public interface TalkControllerService {
    /**
     * add new talk
     */
    TalkAddResponse addTalk(TalkAddRequest request);


    List<TalkAddResponse> getAllTalk();

    /**
     *
     * @param title - title old talk
     * @param description - description old tal
     * @param newRequest - new data for talk
     */
    TalkAddResponse editTalk(String title, String description, TalkAddRequest newRequest);

    public void deleteTalk(TalkAddRequest request);
}
