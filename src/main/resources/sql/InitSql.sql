create database user_info;
create database goods_info;
create database visit_order_info;
create database online_user_info;
use user_info;
create table user_info
(
    id           bigint auto_increment
        primary key,
    username     varchar(255) not null,
    password     varchar(255) not null,
    image_url    varchar(255) null,
    phone_number varchar(255) not null,
    account      int          not null,
    is_logined   int          not null
);

use goods_info;
create table goods_info
(
    id          bigint auto_increment
        primary key,
    goods_name  varchar(255) not null,
    goods_price double       not null,
    message     varchar(255) not null
);

use visit_order_info;
create table visit_num_info
(
    id        bigint auto_increment
        primary key,
    visit_num int default 0 not null
);

use online_user_info;
create table order_num_info
(
    id        bigint auto_increment
        primary key,
    order_num int default 0 not null
);

