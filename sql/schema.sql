drop database if exists growup;
create database growup default character set 'utf8' default collate 'utf8_general_ci';
use growup;

create table u_privacy_status (
	id int not null primary key auto_increment,
	status char(25) not null
);

create table u_auth (
	id bigint not null primary key,
	login varchar(100) not null,
	password varchar(32) not null
	status int not null,
	
	CONSTRAINT fk_status FOREIGN KEY(status) REFERENCES u_privacy_status(id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table admin_auth (
	id bigint not null,
	login varchar(100),
	password varchar(32)	
);

create table t_assignment (
	id bigint not null primary key,
	user_id bigint not null primary key,
	category int not null,
	time_start timestamp not null,
	time_end timestamp not null,
	title varchar(255) not null,
	description varchar(4096),
	FOREIGN KEY 't_user'('user_id') REFERENCES u_auth('id') ON DELETE CASCADE ON UPDATE CASCADE
);

 create table t_daytime (
	id bigint not null primary key,
	user_id bigint not null,
	daytime bigint not null default 8 * 60 * 60 * 1000,
	FOREIGN KEY 't_user'('user_id') REFERENCES u_auth('id') ON DELETE CASCADE ON UPDATE CASCADE
);

create table t_user_category (
	id bigint not null primary key,
	user_id bigint not null,
	title varchar(100) not null,
	importance int not null,
	color varchar(7) default "#000000",
	FOREIGN KEY 't_user'('user_id') REFERENCES u_auth('id') ON DELETE CASCADE ON UPDATE CASCADE
);
	
