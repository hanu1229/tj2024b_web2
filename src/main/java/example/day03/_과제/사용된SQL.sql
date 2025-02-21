drop database if exists boardservice_mapper;
create database boardservice_mapper;
use boardservice_mapper;

create table day03board (
	bno int unsigned auto_increment,
    title varchar(255),
    content text,
    constraint primary key(bno)
);

select * from day03board;