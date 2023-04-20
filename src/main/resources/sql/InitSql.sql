create database user_info;
create database goods_info;
create database visit_order_info;
use user_info;
create table user_info
(
    id           int auto_increment
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
    id          int auto_increment
        primary key,
    goods_name  varchar(255) not null,
    goods_price double       not null,
    message     varchar(255) not null
);



