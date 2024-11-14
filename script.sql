create table users
(
    id          bigint auto_increment
        primary key,
    openid      varchar(255)                        null,
    nick_name   varchar(255)                        null,
    avatar      varchar(500)                        null,
    experience  double    default 0                 null,
    create_time timestamp default CURRENT_TIMESTAMP not null,
    列_name     int       default 0                 null comment 'type'
);

create table checks
(
    id                 int auto_increment
        primary key,
    user_id            bigint           not null,
    check_in_time      datetime         null,
    check_out_time     datetime         null,
    check_in_location  varchar(255)     null,
    check_out_location varchar(255)     null,
    experience         double default 0 null,
    round_number       int              null,
    constraint checks_ibfk_1
        foreign key (user_id) references users (id)
);

create index user_id
    on checks (user_id);


