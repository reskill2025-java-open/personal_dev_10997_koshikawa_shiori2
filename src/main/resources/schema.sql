drop table if exists accounts;
drop table if exists kakeibo cascade;
drop table if exists categories;
drop table if exists incom;

create table accounts(
id serial primary key,
	name text,
	password text	
);


create table kakeibo(
	id serial primary key,
	user_id int,
	Date date,
	category_id int,
	title text,
	detail text,
	price int
);

create table incom(
	id serial primary key,
	user_id int,
	Date date,
	title text,
	detail text,
	price int
);

create table categories(
	id serial primary key,
	name text	
);

create view kakeibo_with_category as
select
    k.id,
    k.user_id,
    k.date,
    k.category_id,
    c.name as category_name,
    k.title,
    k.detail,
    k.price
from
    kakeibo k
    left join categories c on k.category_id = c.id;



