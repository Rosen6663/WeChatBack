create table Counters
(
    id        int auto_increment
        primary key,
    count     int       default 1                 not null,
    createdAt timestamp default CURRENT_TIMESTAMP not null,
    updatedAt timestamp default CURRENT_TIMESTAMP not null
);

create table users
(
    id          bigint auto_increment
        primary key,
    openid      varchar(255)                        null,
    nick_name   varchar(255)                        null,
    avatar      varchar(500)                        null,
    experience  double    default 0                 null,
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create table checks
(
    id                 int auto_increment
        primary key,
    user_id            bigint       not null,
    check_in_time      timestamp    null,
    check_out_time     timestamp    null,
    check_in_location  varchar(255) null,
    check_out_location varchar(255) null,
    round_number       int          null,
    constraint checks_ibfk_1
        foreign key (user_id) references users (id)
);

create index user_id
    on checks (user_id);


