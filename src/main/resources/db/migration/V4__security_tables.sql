CREATE SEQUENCE role_seq INCREMENT 1 START 1;

create table PUBLIC.role (
    id      int8   default nextval('role_seq') not null,
    name   varchar(255),
    hkey varchar(255),
    created_at timestamp with time zone default current_timestamp,

    primary key (id)
);

CREATE SEQUENCE user_seq INCREMENT 1 START 1;

create table PUBLIC.user (
    id      int8           default nextval('user_seq') not null,
    username   varchar(16) unique,
    password   varchar(16),
    created_at timestamp with time zone default current_timestamp,

    primary key (id)
);

CREATE SEQUENCE user_role_seq INCREMENT 1 START 1;

create table PUBLIC.user_roles (
    id      int8           default nextval('user_role_seq') not null,
    user_id   int8 constraint user_roles_user_id_fk references PUBLIC.user,
    role_id   int8 constraint user_roles_role_id_fk references PUBLIC.role,
    created_at timestamp with time zone default current_timestamp,
    updated_at timestamp with time zone default current_timestamp,

    primary key (id)
);

insert into PUBLIC.role(name, hkey) VALUES ('ROLE_ADMIN', 'ADMIN'), ('ROLE_SPEAKER', 'SPEAKER'), ('ROLE_LISTENER', 'LISTENER');