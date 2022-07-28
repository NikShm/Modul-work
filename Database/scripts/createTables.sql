--database freshbeauty
-- create database FreshBeauty;

DROP TABLE IF EXISTS brand, product, person;
DROP TYPE IF EXISTS category, userRole;

CREATE TYPE category AS ENUM ('PERFUMERY', 'MAKEUP', 'HAIR', 'FACE', 'BODY_AND_BATH', 'FOR_MEN');

CREATE TYPE userRole AS ENUM ('CUSTOMER', 'ADMIN');

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
    price NUMERIC NOT NULL CHECK(price>0),
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
    login VARCHAR(128) NOT NULL,
    password VARCHAR(32) NOT NULL,
    createdAt timestamp default now()
);