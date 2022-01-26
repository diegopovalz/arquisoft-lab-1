# Laboratorio 1 - Arquitectura de Software

Proyecto creado usando Java y MySQL

## Script SQL a correr para crear tablas

`CREATE DATABASE payments;

DROP TABLE IF EXISTS payments.payment;
DROP TABLE IF EXISTS payments.card;
DROP TABLE IF EXISTS payments.user;

CREATE TABLE payments.user (
	  id INT NOT NULL UNIQUE,
    client_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE payments.card (
    number VARCHAR(16) NOT NULL UNIQUE,
    expiration DATE NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    client_id INT NOT NULL,
    PRIMARY KEY (number),
    CONSTRAINT fk_credit_card_client FOREIGN KEY (client_id) REFERENCES user(id)
);

CREATE TABLE payments.payment (
	  id INT NOT NULL AUTO_INCREMENT,
    client_id INT NOT NULL,
    card_id VARCHAR(16) NOT NULL,
    value DECIMAL NOT NULL,
    payment_date DATE NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_payment_client FOREIGN KEY (client_id) REFERENCES user(id),
    CONSTRAINT fk_payment_card FOREIGN KEY (card_id) REFERENCES card(number)
);`
