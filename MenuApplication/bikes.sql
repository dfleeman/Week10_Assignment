create database if not exists bikes;
use bikes;
drop table if exists bikes;


create table bikes (
	id int(10) not null auto_increment,
	year int (4) not null,
	make varchar(25) not null,
	model varchar(25) not null,
	engine_size int(10) not null,
	primary key(id)
);