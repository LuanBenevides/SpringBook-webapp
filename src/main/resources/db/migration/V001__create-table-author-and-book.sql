create table author(
	id int not null primary key,
    name varchar(255) not null
);

create table book(
	id int not null auto_increment primary key,
    name varchar(255) not null,
    author_id int not null,
    foreign key (author_id) references author(id)
);