-- drop schema if exists userschema cascade;
--
-- create schema userschema;

drop  table if exists users;
create table users (
    id  bigserial not null,
    email varchar(150) not null,
    first_name varchar(75) not null,
    last_name varchar(75) not null,
    login varchar(40),
    password varchar(255),
    sex_type varchar(255) not null,
    telephone_number int8,
    primary key (id));

alter table if exists users
    add constraint email_fk unique (email);

alter table if exists users
    add constraint login_fk unique (login);

-- alter table users set schema userschema;