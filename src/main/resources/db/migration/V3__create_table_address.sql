create table address(
    id bigint not null auto_increment,
    street varchar(100) not null,
    houseNumber bigint not null,
    neighborhood varchar(50) not null,
    city varchar(50) not null,
    state varchar(50) not null,
    country varchar(50) not null,
    primary key(id)
);

insert into address values(1,'Rua_Nova',840,'Jd_Estela','Piratininga','São_Paulo','Brasil');