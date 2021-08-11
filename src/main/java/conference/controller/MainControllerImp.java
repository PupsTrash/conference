package conference.controller;

import conference.controller.api.ScheduleGetResponse;
import conference.service.main.MainControllerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainControllerImp implements MainControllerApi {
    private final MainControllerService mainControllerService;

    @Override
    public List<ScheduleGetResponse> main(){
       return mainControllerService.getAllScheduleByRoom();
    }
}
