/************************************************************************************************
* Create Database schema
* Author: felipe@dvdsp.com.br
* Last update date: March 16 of 2018 - 11:20
************************************************************************************************/
CREATE DATABASE techChallengeDb;

Use techChallengeDb;

CREATE TABLE Customer (
	id Integer PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(128),
    name VARCHAR(128),
    address VARCHAR(128),
    creation VARCHAR(128),
    password VARCHAR(128)
);

CREATE TABLE Products (
	productId Integer PRIMARY KEY AUTO_INCREMENT,
    restaurantID INTEGER,
    name VARCHAR(128),
    description VARCHAR(128),
    price NUMERIC(6,2)

);

CREATE TABLE Restaurant (
	restaurantID Integer PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128),
    description VARCHAR(128),
    address VARCHAR(128),
	longitude NUMERIC(8,6),
	lagitude NUMERIC(8,6)
    
);


CREATE TABLE FoodOrder (
	orderId Integer PRIMARY KEY AUTO_INCREMENT,
    orderDate VARCHAR(128),
    customerId INTEGER,
    deliveryAddress VARCHAR(128),
	contact VARCHAR(128),
	restaurantId INTEGER,
    total NUMERIC(6,2),
    status VARCHAR(128),
    lastUpdate VARCHAR(128)

);

CREATE TABLE FoodOrderItem (
	orderItemId Integer PRIMARY KEY AUTO_INCREMENT,
    orderId Integer ,
    productId INTEGER,
    price NUMERIC(6,2),
    quantity INTEGER,
    total NUMERIC(6,2)

);

