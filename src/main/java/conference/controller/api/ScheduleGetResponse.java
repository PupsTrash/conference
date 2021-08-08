package conference.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ScheduleGetResponse {
    private List<ScheduleResponseDto> scheduleList;
}
