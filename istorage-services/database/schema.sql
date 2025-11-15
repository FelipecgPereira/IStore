create database iStoreProducts;

create table products (
 id bigserial not null primary key,
 name varchar(100) not null,
 unit_price decimal(16,2) not null
);

create database iStoreClients;

create table customers (
 id bigserial not null primary key,
 name varchar(150) not null,
 tax_id char(11) not null,
 street varchar(100),
 number varchar(10),
 neighborhood varchar(100),
 email varchar(150),
 phone varchar(20)
);

create database iStoreOrders;

create table orders (
 id bigserial not null primary key,
 customer_id bigint not null references customers (id),
 order_date timestamp not null default now(),
 payment_key text,
 notes text,
 status varchar(20) check (
  status in ('PLACED', 'PAID', 'INVOICED', 'SHIPPED', 'PAYMENT_ERROR', 'PREPARING_SHIPMENT')
 ),
 total decimal(16,2) not null,
 tracking_code varchar(255),
 invoice_url text
);

create table order_items (
 id bigserial not null primary key,
 order_id bigint not null references orders (id),
 product_id bigint not null references products (id),
 quantity int not null,
 unit_price decimal(16,2) not null
);
