drop database if exists springweb;
create database springweb;
use springweb;
-- ----------------------- day05 ------------------------------------- --
-- 학생 테이블
--DROP TABLE if EXISTS student_score;
--DROP TABLE if EXISTS student;
--
--CREATE TABLE student (
--    sno INT AUTO_INCREMENT,              -- 학생 번호 (자동 증가)
--    name VARCHAR(50) NOT NULL,           -- 이름
--    kor INT NOT NULL,                    -- 국어 점수
--    math INT NOT NULL,                    -- 수학 점수
--    CONSTRAINT  PRIMARY KEY (sno)  -- 기본키 제약 조건 추가
--);

-- 성적 기록 테이블 (트랜잭션 실습용)
--CREATE TABLE student_score (
--    score_id INT AUTO_INCREMENT,          -- 성적 ID (자동 증가)
--    sno INT NOT NULL,                     -- 학생 번호 (외래키)
--    subject VARCHAR(20) NOT NULL,         -- 과목명 ('국어' 또는 '수학')
--    score INT NOT NULL,                   -- 점수
--    CONSTRAINT  PRIMARY KEY (score_id),  -- 기본키 제약 조건 추가
--    CONSTRAINT  FOREIGN KEY (sno) REFERENCES student(sno)  -- 외래키 제약 조건 추가
--);

-- ---------------------- ------ ------------------------------------- --

-- ----------------------- day05 ------------------------------------- --

-- ----------------------- day07 ------------------------------------- --
--drop database if exists task_db;
--create database task_db;
--use task_db;
--
--create table task (
--	number int unsigned auto_increment,
--    name varchar(30) not null,
--    phone varchar(13) not null,
--    constraint primary key(number)
--);
-- ----------------------- day07 ------------------------------------- --

-- ----------------------- day08 ------------------------------------- --
drop database if exists springweb;
create database springweb;
use springweb;

create table productsample(
	id int auto_increment ,
    name varchar(20) ,
    price int ,
    comment longtext ,
    constraint primary key ( id )
);
-- ----------------------- day08 ------------------------------------- --

-- ------------------------------- web ------------------------------- --

DROP TABLE if EXISTS member;
CREATE TABLE member (
    -- 회원 번호 (기본키)
    mno   INT UNSIGNED AUTO_INCREMENT,
    -- 회원 아이디
    mid   VARCHAR(50) NOT NULL UNIQUE,
    -- 비밀번호
    mpwd  VARCHAR(255) NOT NULL,
    -- 회원 이름
    mname VARCHAR(100) NOT NULL,
    -- 프로필 이미지 URL
    mimg  VARCHAR(255) DEFAULT NULL,
    CONSTRAINT PRIMARY KEY(mno)
);

-- ------------------------------- web ------------------------------- --

-- ------------------------------- day11._과제 ------------------------------- --

DROP TABLE IF EXISTS day11products;
CREATE TABLE day11products (
    -- 상품ID (자동 증가)
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    -- 상품명
    product_name VARCHAR(255) NOT NULL,
    -- 재고 수량
    stock_quantity INT NOT NULL
);

-- ------------------------------- day11._과제 ------------------------------- --

-- ------------------------------- day13 ------------------------------- --
DROP TABLE if EXISTS day13users;
CREATE TABLE day13users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    money INT UNSIGNED DEFAULT 0
);
-- ------------------------------- day13 ------------------------------- --