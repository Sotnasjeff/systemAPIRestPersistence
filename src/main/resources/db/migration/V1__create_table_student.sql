create table student(
    id bigint not null auto_increment,
    name varchar(100) not null,
    age int not null,
    cpf varchar(10) not null,
    status varchar(20) not null,
    address_id bigint not null,
    course_id bigint not null,
    primary key(id),
    foreign key(address_id) references address(id),
    foreign key(course_id) references course(id)
);

