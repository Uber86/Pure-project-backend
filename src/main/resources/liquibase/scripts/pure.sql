-- liquibase formatted sql

-- changeset oss:1
CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255), NOT NULL,
    birthday DATE,
    sex VARCHAR(20),
);

-- changeset oss:1
CREATE TABLE profiles(
    id BIGSERIAL PRIMARY KEY,
    bio VARCHAR(350),


);

