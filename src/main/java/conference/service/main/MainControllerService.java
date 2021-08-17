package conference.service.main;

import conference.controller.api.ScheduleGetResponse;

import java.util.List;

/**
 * main method`s Main Service for Main controller
 */
public interface MainControllerService {

    /**
     * @return List ScheduleGetResponse by room with order by startAt (start schedule)
     */
    List<ScheduleGetResponse> getAllScheduleByRoom();
}
