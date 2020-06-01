--liquibase formatted sql
--changeset uaguilar
create table test1
(
	id int auto_increment,
	name varchar(255) not null,
	constraint test1_pk
		primary key (id)
);
--rollback drop table test1;