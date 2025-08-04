create table customer (
    id serial primary key,
    name varchar(100) not null,
    email varchar(100) not null,
    mobile_number varchar(20) not null,
    created_at timestamp,
    created_by integer,
    updated_at timestamp,
    updated_by integer
);

create table account (
    id serial primary key,
    customer_id integer not null references customer(id),
    type varchar(100) not null,
    branch_address varchar(200) not null,
    created_at timestamp,
    created_by integer,
    updated_at timestamp,
    updated_by integer
);