package conference;

import conference.controller.api.ScheduleResponseDto;
import conference.db.Room;
import conference.db.Schedule;
import conference.db.Talk;
import conference.service.schedule.ScheduleMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ScheduleControllerMapperTest.Config.class})
public class ScheduleControllerMapperTest {

    @Autowired
    private ScheduleMapper mapperTest;

    @Test
    public void scheduleMapperSingleDtoTest() {

        var title = "Title";
        var startAt = LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.MIDNIGHT);
        var finishAt = LocalDateTime.of(LocalDate.of(2022, 2, 2), LocalTime.MIDNIGHT);
        var talkDescription = "Description";
        var talkRoomNumber = "122a";

        var schedule = buildSchedule(buildTalk(title,talkDescription), talkRoomNumber, startAt, finishAt);
        var expected = buildScheduleResponseDto(title, startAt, finishAt, talkDescription, talkRoomNumber);

        Assertions.assertEquals(expected, mapperTest.toResponse(schedule));
    }

    private ScheduleResponseDto buildScheduleResponseDto(String title, LocalDateTime startAt, LocalDateTime finishAt, String talkDescription, String talkRoomNumber) {
        return new ScheduleResponseDto(startAt, finishAt, title, talkDescription, talkRoomNumber);
    }

    private Schedule buildSchedule(Talk talk, String roomNumber, LocalDateTime startAt, LocalDateTime finishAt) {

        var schedule = new Schedule();
        var room = new Room();

        room.setNumber(roomNumber);

        schedule.setTalk(talk);
        schedule.setRoom(room);
        schedule.setStartAt(startAt);
        schedule.setFinishAt(finishAt);

        return schedule;
    }

    private Talk buildTalk(String title, String talkDescription) {

        var talk = new Talk();
        talk.setTitle(title);
        talk.setDescription(talkDescription);

        return talk;
    }

    @TestConfiguration
    static class Config {

        @Bean("mapperTest")
        public ScheduleMapper getMapper() {
            return Mappers.getMapper(ScheduleMapper.class);
        }
    }
}
