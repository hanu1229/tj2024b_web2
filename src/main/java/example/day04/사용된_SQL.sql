drop database if exists db_student;
create database db_student;
use db_student;

create table students(
	sno int unsigned auto_increment,
    name varchar(30),
    kor int unsigned,
    math int unsigned,
    constraint primary key(sno)
);

select * from students;