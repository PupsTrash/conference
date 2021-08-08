CREATE SEQUENCE talk_seq start with 1 increment by 1 ;
create table PUBLIC.talk
(
    id          int8      default nextval('talk_seq') not null,
    title       varchar(255),
    description varchar(1000),
    start_at    timestamp with time zone,
    finish_at   timestamp with time zone,
    created_at  timestamp with time zone default current_timestamp,

    primary key (id)
);

CREATE SEQUENCE room_seq start with 1 increment by 1 ;
create table PUBLIC.room
(
    id         int8      default nextval('room_seq') not null,
    number     int,
    created_at timestamp with time zone default current_timestamp,

    primary key (id)
);

CREATE SEQUENCE schedule_seq start with 1 increment by 1 ;
create table PUBLIC.schedule
(
    id         int8      default nextval('schedule_seq') not null,
    talk_id    int8,
    room_id    int8,
    created_at timestamp with time zone default current_timestamp,

    foreign key (talk_id) references talk(id),
    foreign key (room_id) references room(id),
    primary key (id)
)