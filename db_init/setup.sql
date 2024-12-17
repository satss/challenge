CREATE DATABASE IF NOT EXISTS challenge;

use challenge;

create table  if not exists authors (
  id  int unsigned auto_increment primary key,
  first_name varchar(20) not null,
  last_name varchar(20) not null,
  created_at timestamp default CURRENT_TIMESTAMP not null,
  updated_at timestamp default CURRENT_TIMESTAMP not null
);
create table if not exists quotes (
   id  int unsigned auto_increment primary key,
   quote varchar(200) not null,
   author_id  int unsigned not null,
   created_at timestamp default CURRENT_TIMESTAMP not null,
   updated_at timestamp default CURRENT_TIMESTAMP not null

);