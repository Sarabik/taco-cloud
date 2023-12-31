create table if not exists Taco_Order (
id serial primary key,
delivery_Name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_City varchar(50) not null,
delivery_State varchar(10) not null,
delivery_Zip varchar(10) not null,
cc_number varchar(16) not null,
cc_expiration varchar(5) not null,
cc_cvv varchar(3) not null,
placed_at timestamp not null);

create table if not exists Taco (
id serial primary key,
name varchar(50) not null,
taco_order bigint not null references Taco_Order(id),
created_at timestamp not null
);

create table if not exists Ingredient (
id varchar(4) primary key,
name varchar(25) not null,
type varchar(10) not null
);

create table if not exists Ingredient_Ref (
id serial primary key,
ingredient varchar(4) not null references Ingredient(id),
taco bigint not null references Taco(id)
);

