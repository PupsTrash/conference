CREATE SEQUENCE TEST_SEQ INCREMENT 1 START 1;

create table PUBLIC.TEST (
    id      int8           default nextval('PUBLIC.TEST_SEQ') not null,
    value   varchar(255),

    primary key (id)
)