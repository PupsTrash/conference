insert into PUBLIC.user (username, password)
values ('admin', '1'),
       ('spk', '2'),
       ('lis', '3');
insert into PUBLIC.user_roles(user_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3);