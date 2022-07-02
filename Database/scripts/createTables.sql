CREATE TYPE category AS ENUM ('perfumery', 'makeup', 'hair', 'face', 'body and bath', 'for men');

CREATE TYPE userRole AS ENUM ('customer', 'admin');

CREATE TABLE brand
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    createdAt timestamp default now()
);

CREATE TABLE product
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    description TEXT,
    brandId INTEGER REFERENCES brand(id) NOT NULL,
    price MONEY NOT NULL,
    category category NOT NULL,
    color CHAR(7) NOT NULL,
    volume VARCHAR(8),
    photoPath VARCHAR(512) NOT NULL,
    createdAt timestamp default now()
);

CREATE TABLE person
(
    id SERIAL PRIMARY KEY,
    role userRole NOT NULL,
    firstName VARCHAR(128) NOT NULL,
    lastName VARCHAR(128) NOT NULL,
    phone VARCHAR(16),
    email VARCHAR(128),
    login VARCHAR(128) NOT NULL,
    password VARCHAR(32) NOT NULL,
    createdAt timestamp default now()
);