CREATE DATABASE IF NOT EXISTS airlinemanagementsystem;
USE airlinemanagementsystem;

CREATE TABLE IF NOT EXISTS login (
    username VARCHAR(80) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS passenger (
    name VARCHAR(120) NOT NULL,
    nationality VARCHAR(80) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    address VARCHAR(255) NOT NULL,
    aadhar VARCHAR(30) PRIMARY KEY,
    gender VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS flight (
    f_code VARCHAR(30) PRIMARY KEY,
    f_name VARCHAR(120) NOT NULL,
    source VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservation (
    PNR VARCHAR(30) PRIMARY KEY,
    ticket VARCHAR(30) NOT NULL UNIQUE,
    aadhar VARCHAR(30) NOT NULL,
    name VARCHAR(120) NOT NULL,
    nationality VARCHAR(80) NOT NULL,
    flightname VARCHAR(120) NOT NULL,
    flightcode VARCHAR(30) NOT NULL,
    src VARCHAR(100) NOT NULL,
    des VARCHAR(100) NOT NULL,
    ddate VARCHAR(30) NOT NULL,
    CONSTRAINT fk_reservation_passenger FOREIGN KEY (aadhar) REFERENCES passenger(aadhar)
);

CREATE TABLE IF NOT EXISTS cancel (
    PNR VARCHAR(30) PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    cancellationno VARCHAR(30) NOT NULL,
    fcode VARCHAR(30) NOT NULL,
    ddate VARCHAR(30) NOT NULL
);

INSERT INTO login (username, password) VALUES ('admin', 'admin123')
ON DUPLICATE KEY UPDATE username = username;

INSERT INTO flight (f_code, f_name, source, destination) VALUES
    ('AI-101', 'Air India Express', 'Delhi', 'Mumbai'),
    ('AI-202', 'Air India Express', 'Mumbai', 'Bengaluru'),
    ('AI-303', 'Air India Express', 'Kolkata', 'Delhi')
ON DUPLICATE KEY UPDATE f_code = f_code;
