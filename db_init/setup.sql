CREATE DATABASE IF NOT EXISTS challenge;

use challenge;

create table if not exists quotes (
                                      id  int unsigned auto_increment primary key,
                                      quote varchar(100) not null,
                                      author_id  int unsigned not null,
                                      author_user_name  varchar(20) not null
);



create table if not exists authors
(
    id               int unsigned auto_increment
        primary key,
    password  varchar(255) not null,
    user_name            varchar(255) not null,
    policy_name   ENUM('WRITER', 'READER') not null
);



