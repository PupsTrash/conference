package conference;

import conference.controller.api.AddScheduleRequest;
import conference.db.ScheduleEntity;
import conference.validation.constraints.caseVerification.OverlapTimeCheckImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

public class ScheduleEntityValidatorOverlapTest {

    private final OverlapTimeCheckImpl validator = new OverlapTimeCheckImpl();

    public static Stream<Arguments> invalidSources() {
        var invalidStart1 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(12, 1));
        var invalidFinish1 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(13, 0));

        var invalidStart2 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(12, 1));
        var invalidFinish2 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(12, 30));

        var invalidStart3 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(11, 1));
        var invalidFinish3 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(13, 30));

        var invalidStart4 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(12, 1));
        var invalidFinish4 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(13, 30));

        return Stream.of(
                Arguments.of(invalidStart1, invalidFinish1),
                Arguments.of(invalidStart2, invalidFinish2),
                Arguments.of(invalidStart3, invalidFinish3),
                Arguments.of(invalidStart4, invalidFinish4)
        );
    }

    public static Stream<Arguments> validSources() {
        var validStart1 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(11, 1));
        var validFinish1 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(11, 59));

        var validStart2 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(13, 1));
        var validFinish2 = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(14, 30));

        return Stream.of(
                Arguments.of(validStart1, validFinish1),
                Arguments.of(validStart2, validFinish2)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "invalidSources")
    public void invalidDatesTest(LocalDateTime start, LocalDateTime finish) {
        var item = new ScheduleEntity();
        var request = new AddScheduleRequest();

        item.setStartAt(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(12, 0)));
        item.setFinishAt(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(13, 0)));

        request.setStartAt(start);
        request.setFinishAt(finish);

        Assertions.assertEquals(false, validator.isValidTime(request, List.of(item)));
    }

    @ParameterizedTest
    @MethodSource(value = "validSources")
    public void validDatesTest(LocalDateTime start, LocalDateTime finish) {
        var item = new ScheduleEntity();
        var request = new AddScheduleRequest();

        item.setStartAt(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(12, 0)));
        item.setFinishAt(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(13, 0)));

        request.setStartAt(start);
        request.setFinishAt(finish);

        Assertions.assertEquals(true, validator.isValidTime(request, List.of(item)));
    }
}
