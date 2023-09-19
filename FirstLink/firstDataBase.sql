create table store_location(
	store_id INTEGER not null auto_increment,
	adress VARCHAR(255),
	opening_hour TIME,
	closing_hour TIME,
	phone_number VARCHAR(20),
	contact VARCHAR(255),
	country VARCHAR(100),
	primary key (store_id)
);


create table employee(
	employee_id INTEGER not null auto_increment,
	job_title VARCHAR(255) not null,
	salary FLOAT,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	age INTEGER,
	store_id INTEGER,
	join_date DATE,
	primary key (employee_id)
);

create table product(
	product_id INTEGER not null auto_increment,
	name VARCHAR(255),
	quantity INTEGER,
	price DOUBLE,
	price_currency VARCHAR(50),
	warranty BOOL,
	store_id INTEGER,
	primary key (product_id),
	constraint foreign key (store_id)
	references store_location (store_id)
	on delete cascade on update cascade	
);

create table SalesDocument(
	order_id INTEGER not null auto_increment,
	primary key (order_id)
);

create table sale(
	sale_id INTEGER not null auto_increment,
	employee_id INTEGER,
	purchase_date datetime,
	store_id INTEGER,
	purchase_quantity INTEGER,
	product_id INTEGER,
	total_price DOUBLE,
	order_id INTEGER,
	primary key (sale_id),
	constraint foreign key (employee_id)
	references employee (employee_id)
	on delete cascade on update cascade,
	constraint foreign key (store_id)
	references store_location (store_id)
	on delete cascade on update cascade,
	constraint foreign key (product_id)
	references product (product_id)
	on delete cascade on update cascade,
	constraint foreign key (order_id)
	references SalesDocument (order_id)
	on delete cascade on update cascade
);






insert into store_location (adress, opening_hour, closing_hour, phone_number, contact, country) values ('str. Fericirii', '10:00:00', '22:00:00', '0234567890', 'support@magazin.com', 'Romania');
insert into store_location (adress, opening_hour, closing_hour, phone_number, contact, country) values ('bld. Eroilor', '08:00:00', '22:00:00', '0237845690', 'support@magazin.com', 'Romania');
insert into store_location (adress, opening_hour, closing_hour, phone_number, contact, country) values ('bld. 21 Decembrie', '08:00:00', '21:00:00', '0278345690', 'support@magazin.com', 'Romania');
insert into store_location (adress, opening_hour, closing_hour, phone_number, contact, country) values ('str. Observator', '09:00:00', '20:00:00', '0892345670', 'support@magazin.com', 'Romania');
insert into store_location (adress, opening_hour, closing_hour, phone_number, contact, country) values ('str. Baritiu', '08:00:00', '22:00:00', '0237894560', 'support@magazin.com', 'Romania');


insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Monica', 'Pop', 56,3,'Cashier', 2000, '2021-07-13');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ( 'Viorel', 'Popa', 60,3,'Janitor', 1500, '2013-09-23');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Ion', 'Ionescu', 40,3,'Cashier', 2000, '2015-11-24');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ( 'Vasile', 'Voiculescu', 30,3,'Store manager', 3000,'2020-08-11');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ( 'Simona', 'Popescu', 25,4,'Cashier', 2000, '2022-03-02');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Ana', 'Iancu', 31,4,'Store manager', 3000, '2019-09-11');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Maria', 'Manescu', 43,5,'Cashier', 2000, '2015-03-06');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Ioana', 'Parvulescu', 38,5,'Assistant store manager', 2500, '2021-05-26');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Ovidiu', 'Oiescu', 41,1,'Store manager', 3000, '2020-07-14');
insert into employee (first_name, last_name, age, store_id, job_title, salary, join_date) 
values ('Marian', 'Haimairepede', 36,2,'Stock clerk', 2100,'2023-05-25');


insert into product (store_id, name, quantity, price, price_currency, warranty ) values (3, 'Laptop HP', 20, 2000, 'RON', 1);
insert into product (store_id, name, quantity, price, price_currency, warranty ) values (3, 'Monitor Lenovo', 10, 1535, 'RON', 0);
insert into product (store_id, name, quantity, price, price_currency, warranty ) values (5, 'Tastatura', 5, 60, 'RON', 1);
insert into product (store_id, name, quantity, price, price_currency, warranty ) values (3, 'Casti wireless', 7, 100, 'EUR', 1);
insert into product (store_id, name, quantity, price, price_currency, warranty ) values (5,'Mouse', 5, 35, 'RON', 0);

insert into SalesDocument values (1);
insert into SalesDocument values (2);
insert into SalesDocument values (3);

insert into sale (employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id) values (3, '2023-09-12 12:00:00', 3, 1, 2, 1);
insert into sale (employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id) values (7, '2023-09-11 09:30:00', 5,3,1,1);
insert into sale (employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id) values (5, '2023-09-05 10:20:30', 4, 5,6,2);

create trigger false_purchase
after
insert
	on
	sale
for each row 
	begin 
		if new.purchase_quantity > (
	select
		quantity
	from
		product
	inner join INSERTED i on
		product.product_id = i.product_id
	where
		product.product_id = new.product_id) then 
		update
	sale
set
	new.purchase_quantity = (
	select
		quantity
	from
		product
	inner join INSERTED i on
		product.product_id = i.product_id
	where
		product.product_id = new.product_id);
end if;
end;

 
update sale inner join product on sale.product_id = product.product_id
set  sale.purchase_quantity = product.quantity
where sale.purchase_quantity > product.quantity;

create trigger stock_level
after update on product
for each row 
when (i.quantity < d.quantity)
	insert into sale (employee_id, purchase_date, store_id, product_id, purchase_quantity)
	values (1, getdate(), 1, i.product_id, d.quantity - i.quantity);

create trigger tr_quantity
on product after update 
as 
if ( update ( quantity ) )
begin
	update sale 
	set purchase_quantity = quantity
	
end

create trigger tr_insert on product FOR update
AS
insert
	into
	sale(employee_id, purchase_date, store_id, product_id, purchase_quantity, order_id)
select
	1,
	getdate(),
	1,
	1,
	1,
	1
from
	INSERTED;
	GO





/*the products which have been purchased*/
select product.product_id as ID, product.name as Item, store_location.adress as Adress, sale.purchase_date as Purchased
from ((product inner join store_location on product.store_id = store_location.store_id) inner join sale on product.product_id  = sale.product_id ) 
where product.store_id = 3 AND product.quantity >= 4
order by sale.purchase_date;

/*the sales an what products they contain*/
select product.product_id as ID, product.category as Item, store_location.adress as Adress, sale.purchase_date as Purchased
from ((product inner join store_location on product.store_id = store_location.store_id) right join sale on product.sale_id  = sale.sale_id ) 
where product.store_id = 3
order by sale.purchase_date; 

/*all the products and when they were purchased (if they were)*/
select product.product_id as ID, product.category as Item, store_location.adress as Adress, sale.purchase_date as Purchased
from ((product inner join store_location on product.store_id = store_location.store_id) left join sale on product.sale_id  = sale.sale_id ) 
where product.quantity  > 3
order by sale.purchase_date;

/*retrieves the first 3 employees that have the last name ending in -escu*/
select first_name, last_name
from employee 
where last_name like '%escu'
order by first_name, last_name
limit 3 offset 2;

/*prints how many employees are on each position, but not janitors, in shop 3 */
select employee.job_title as Job, count(employee.employee_id) as NoEmployees
from employee
where employee.job_title != 'Janitor' and employee.store_id = 3
group by employee.job_title 
order by employee.job_title;

/*selects all the employees that are above the age of 40 and counts them by position*/
select employee.job_title as Job, count(employee.employee_id) as NoEmployees
from employee 
where employee.age >= 40
group by employee.job_title
order by employee.job_title;