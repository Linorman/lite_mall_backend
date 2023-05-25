create database user_info;
create database goods_info;
create database visit_order_info;
create database online_user_num_info;
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
drop table goods_info;
create table goods_info
(
    id          bigint auto_increment
        primary key,
    goods_name  varchar(255) not null,
    goods_price double       not null,
    message     varchar(255) not null,
    file_path   varchar(1023) not null
);
insert into goods_info (goods_name, goods_price, message, file_path) values ('iphone', 10000, 'iphone', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1681805071.89555963.png');
insert into goods_info (goods_name, goods_price, message, file_path) values ('huawei', 5000, 'huawei', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1670745532.85539028.png');
insert into goods_info (goods_name, goods_price, message, file_path) values ('塞尔达传说-王国之泪', 3000, '任地狱最新大作', 'https://baike.baidu.com/pic/%E5%A1%9E%E5%B0%94%E8%BE%BE%E4%BC%A0%E8%AF%B4%EF%BC%9A%E7%8E%8B%E5%9B%BD%E4%B9%8B%E6%B3%AA/61984963/1/63d0f703918fa0ec08fac37aa2c14eee3d6d55fb6d37?fr=lemma&fromModule=lemma_top-image&ct=single#aid=1&pic=63d0f703918fa0ec08fac37aa2c14eee3d6d55fb6d37');

use visit_order_info;
create table visit_num_info
(
    id        bigint auto_increment
        primary key,
    visit_num int default 0 not null
);

create table order_num_info
(
    id        bigint auto_increment
        primary key,
    order_num int default 0 not null
);
use online_user_num_info;
create table online_user_num_info
    (
        id        bigint auto_increment
            primary key,
        online_user_num int default 0 not null
);


