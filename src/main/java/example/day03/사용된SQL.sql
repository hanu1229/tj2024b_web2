drop database if exists springweb;
create database springweb;
use springWeb;

create table user(
	id int unsigned auto_increment,
    name varchar(100),
    age int,
    constraint primary key(id)
);