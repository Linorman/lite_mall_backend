drop database if exists user_info;
drop database if exists goods_info;
drop database if exists visit_order_info;
drop database if exists online_user_info;
create database user_info;
create database goods_info;
create database visit_order_info;
create database online_user_info;
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
    message     varchar(255) not null,
    file_path  varchar(1023) not null
);


use visit_order_info;
create table visit_num_info
(
    id        int auto_increment
        primary key,
    visit_num int default 0 not null
);

create table order_num_info
(
    id        int auto_increment
        primary key,
    order_num int default 0 not null
);

use online_user_info;
create table online_user_num_info
(
    id           int auto_increment
        primary key,
    online_user_num int default 0 not null
);



