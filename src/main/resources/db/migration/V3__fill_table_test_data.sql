insert into PUBLIC.talk (title, description)
values ('checkinfo', 'somedescription');

insert into PUBLIC.room (number)
values (5);

insert into PUBLIC.schedule (room_id, talk_id, start_at, finish_at)
values (1, 1,
        PARSEDATETIME('07 08 2021 15:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'),
        PARSEDATETIME('07 08 2021 16:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'));

insert into PUBLIC.talk (title, description)
values ('checkinfo2', 'somedescription2');

insert into PUBLIC.room (number)
values (5);

insert into PUBLIC.schedule (room_id, talk_id, start_at, finish_at)
values (2, 2,
        PARSEDATETIME('07 08 2021 12:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'),
        PARSEDATETIME('07 08 2021 13:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'));

insert into PUBLIC.talk (title, description)
values ('checkinfo3', 'somedescription3');

insert into PUBLIC.room (number)
values (2);

insert into PUBLIC.schedule (room_id, talk_id, start_at, finish_at)
values (3, 3,
        PARSEDATETIME('07 08 2021 15:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'),
        PARSEDATETIME('07 08 2021 16:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'));
