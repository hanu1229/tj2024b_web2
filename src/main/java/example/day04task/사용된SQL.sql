drop database if exists day04board;
create database day04board;
use day04board;

create table board(
	bno int unsigned auto_increment,
    title varchar(30),
    content text,
    constraint primary key(bno)
);

select * from board;