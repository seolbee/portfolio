drop table DIARY_USER;

create table DIARY_USER (
	idx number(38, 0) not null primary key,
	id varchar2(50) not null,
	pass varchar2(50) not null,
	name varchar2(50) not null,
	birth Date not null
);

create table DIARY_BOARD(
	idx number(38, 0) not null primary key,
	user_idx number(38, 0) not null,
	content CLOB not null,
	writeDate Date not null
);

create table DIARY_TODO(
	idx number(38, 0) not null primary key,
	user_idx number(38, 0) not null,
	todo CLOB not null,
	todoDate Date not null
);