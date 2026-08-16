CREATE TABLE tb_customers(
    id uuid primary key ,
    firstname VARCHAR(90) not null,
    lastname varchar(90) not null,
    document varchar(14) unique not null,
    phone varchar(30) not null,
    email varchar(255) unique not null,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);