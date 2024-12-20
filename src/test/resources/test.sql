CREATE DATABASE IF NOT EXISTS challenge;

use challenge;

create table if not exists quotes (
                                      id  int unsigned auto_increment primary key,
                                      quote varchar(1000) not null,
    author_user_name  varchar(255) not null
    );





