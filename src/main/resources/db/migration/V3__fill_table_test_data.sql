insert into PUBLIC.talk (title, description)
values ('checkinfo',
        'somedescription'
       );

insert into PUBLIC.room (number) values ( 5 );

insert into PUBLIC.schedule (room_id, talk_id, start_at, finish_at) values ( 1, 1,  PARSEDATETIME('07 08 2021 12:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz'),
                                                          PARSEDATETIME('07 08 2021 13:05 GMT+05:00', 'dd MM yyyy HH:mm zzzz') );

