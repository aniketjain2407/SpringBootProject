create table farmerfranchise (
		id int not null auto_increment,
		district varchar(255),
		franchise varchar(255),
		product varchar(255),
		quantity int,
		state varchar(255)
);

create table user (
		id int not null auto_increment,
		name varchar(255),
		phoneno varchar(255),
		password varchar(255),
		user_type int default 3
);

create table course(
	id int not null auto_increment,
	field varchar(255),
	name varchar(255),
	min_marks int,
	max_marks int,
	price int,
	is_active BIT,
	discount float(10),
	tax float(10)
);