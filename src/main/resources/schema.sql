drop table if exists accounts;
drop table if exists records;
drop table if exists categories;

create table accounts(
id serial primary key,
	name text,
	password text	
);


create table records(
	id serial primary key,
	user_id int,
	Date date,
	category_id int,
	title text,
	detail text,
	price int
);

create table categories(
	id serial primary key,
	name text	
);

