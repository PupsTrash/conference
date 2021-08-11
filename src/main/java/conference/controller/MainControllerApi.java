package conference.controller;

import conference.controller.api.ScheduleGetResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/main")
public interface MainControllerApi {
    @GetMapping
    List<ScheduleGetResponse> main();
}
