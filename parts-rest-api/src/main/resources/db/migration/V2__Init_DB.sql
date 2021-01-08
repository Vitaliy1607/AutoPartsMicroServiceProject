drop table if exists parts;

create table parts(
    id  bigserial not null,
    condition varchar(25) not null,
    part_name varchar(50) not null,
    price DECIMAL(7,2) DEFAULT 0 not null,
    primary key (id));


