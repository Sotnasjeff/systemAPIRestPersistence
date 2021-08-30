create table course(
    id bigint not null auto_increment,
    name varchar(20) not null,
    category varchar(50) not null,
    primary key(id)
);

insert into curso values(1, 'Desenvolvimento', 'Tecnologia');