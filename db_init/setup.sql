CREATE DATABASE IF NOT EXISTS challenge;

use challenge;

create table if not exists quotes (
                                      id  int unsigned auto_increment primary key,
                                      quote varchar(1000) not null,
                                      author_user_name  varchar(255) not null
);



create table if not exists authors
(
    id               int unsigned auto_increment
        primary key,
    user_name          varchar(255) unique not null,
    password  varchar(255) not null,
    policy_name   ENUM('WRITER', 'READER') not null
);


insert into authors values (1,"Janina@89","{bcrypt}$2a$12$5c5GeSlhoZ0LZst4on2V3.BRQa05DpS9Mg.stBAjqkoPWkuko2s3.", 'WRITER');
insert into authors values (2,"Icemachina3","{bcrypt}$2a$12$HvJcsC7wUocb.DVnWYjL3eTNnFi0z.u8jkFlDXkhbH7DJdlpyYQgi", 'READER');



