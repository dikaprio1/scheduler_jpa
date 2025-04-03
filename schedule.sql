-- auto-generated definition
create table schedule
(
    id          bigint auto_increment
        primary key,
    create_at   datetime(6)  null,
    modified_at datetime(6)  null,
    contents    longtext     null,
    title       varchar(255) not null,
    user_id     bigint       null,
    constraint FKa50n59y1j4a6qwa42p8jiguds
        foreign key (user_id) references user (id)
);

-- auto-generated definition
create table user
(
    create_at   datetime(6)  null,
    id          bigint auto_increment
        primary key,
    modified_at datetime(6)  null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    user_name   varchar(255) not null,
    constraint UKob8kqyqqgmefl0aco34akdtpe
        unique (email)
);



