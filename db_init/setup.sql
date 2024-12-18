CREATE DATABASE IF NOT EXISTS challenge;

use challenge;

create table if not exists quotes (
   id  int unsigned auto_increment primary key,
   quote varchar(200) not null,
   author_id  int unsigned not null,
   author_user_name  varchar(20) not null
);

create table if not exists polices
(
    id int unsigned auto_increment
        primary key,
    name ENUM('QUOTES.ROLE_WRITE', 'QUOTES.ROLE_READ') not null
);



create table if not exists authors
(
    id               int unsigned auto_increment
        primary key,
    user_name            varchar(20) not null,
    first_name       varchar(20)  not null,
    last_name        varchar(20)  not null,
    policy_id   int unsigned default  1 not null
);



INSERT INTO authors VALUES (1, "light_yagami@89", "Light", "Yagami", 1);
INSERT INTO authors VALUES (2, "light_yagami@89", "Light", "Yagami", 2);

INSERT INTO authors VALUES (3, "ken_1234", "Ken", "Takakura", 2);