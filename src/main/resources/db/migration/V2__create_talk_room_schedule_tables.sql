CREATE SEQUENCE TALK_SEQ START 1 INCREMENT 1;
create table if not exists PUBLIC.TALK
(
    id          int8      default nextval('TALK_SEQ') not null,
    title       varchar(255),
    description text,
    start_at    date                                  not null,
    finish_at   date                                  not null,
    created_at  timestamp default current_timestamp,

    primary key (id)
);

CREATE SEQUENCE ROOM_SEQ START 1 INCREMENT 1;
create table if not exists PUBLIC.Room
(
    id         int8      default nextval('ROOM_SEQ') not null,
    number     int,
    created_at timestamp default current_timestamp,

    primary key (id)
);

CREATE SEQUENCE SCHEDULE_SEQ START 1 INCREMENT 1;
create table if not exists PUBLIC.Schedule
(
    id         int8      default nextval('SCHEDULE_SEQ') not null,
    talk_id    int8,
    room_id    int8,
    created_at timestamp default current_timestamp,

    foreign key (talk_id) references  TALK (id),
    foreign key (room_id) references Room (id),
    primary key (id)
)