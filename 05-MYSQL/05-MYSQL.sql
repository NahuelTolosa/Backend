create database if not exists prueba;

use prueba;

 
create table categories (
	id_category int auto_increment not null,
    category varchar(40) not null,
    constraint pk_id_category primary key (id_category)
);

insert into categories ( category ) values
( "Harina" ),
( " Lácteos" );



create table items (
	id_item int auto_increment not null,
    item_name varchar(40) not null,
    category int not null,
    stock int unsigned not null,
    constraint pk_id_item primary key (id_item),
    constraint fk_category foreign key (category) references categories(id_category)
);

insert into items ( item_name, category, stock ) values
( "Fideos", 1, 20 ),
( "Leche", 2, 30 ),
( "Crema", 2, 30 );


select * from items;


delete from items where (id_item = 1);


update items
set stock = 45 where id_item = 2;


