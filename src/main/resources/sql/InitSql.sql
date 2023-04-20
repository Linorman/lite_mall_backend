create database user_info;
create database goods_info;
create database visit_order_info;
use user_info;

CREATE TABLE IF NOT EXISTS `user_info` (
 `id` INTEGER NOT NULL,
 `username` VARCHAR(255) NOT NULL,
 `password` VARCHAR(255) NOT NULL,
 `image_url` VARCHAR(255) NOT NULL,
 `phone_number` VARCHAR(255) NOT NULL,
 `account` INTEGER NOT NULL,
 `is_logined` JSON NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB;

use goods_info;
CREATE TABLE IF NOT EXISTS `goods_info`(
                                          `id` INTEGER NOT NULL,
                                          `goods_name` VARCHAR(255) NOT NULL,
                                          `goods_price` DOUBLE PRECISION NOT NULL,
                                          `message` VARCHAR(255) NOT NULL,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB;

