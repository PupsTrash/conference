package conference.controller;

import conference.controller.api.ScheduleGetResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * main controller for all user. don't need authorization
 */
@Tag(name = "main controller")
@RequestMapping("/main")
public interface MainControllerApi {

    /**
     * @return schedule list grouped by room with ordering by startAt
     */
    @GetMapping
    List<ScheduleGetResponse> main();
}
