CREATE DATABASE fly;
USE fly;

CREATE TABLE airlines (
code INT(11) AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
other_details VARCHAR(255) NOT NULL
);

CREATE TABLE flight_schedules (
id INT(11)  AUTO_INCREMENT PRIMARY KEY,
arrival_time DATE NOT NULL,
departure_time DATE NOT NULL,
flight_number INT(11) NOT NULL,
other_details VARCHAR(255) NOT NULL,
airline_code INT(11) NOT NULL,
FOREIGN KEY (airline_code) REFERENCES airlines(code)
);

CREATE TABLE ref_classes (
class_number INT(11)  AUTO_INCREMENT PRIMARY KEY,
class_number_description VARCHAR(255) NOT NULL
);

CREATE TABLE ref_payment_methods (
code INT(11)  AUTO_INCREMENT PRIMARY KEY,
payment_method_description VARCHAR(255) NOT NULL
);
CREATE TABLE ref_reservation_status (
code INT(11)  AUTO_INCREMENT PRIMARY KEY,
reservation_status_description VARCHAR(255) NOT NULL
);
CREATE TABLE customers (
id INT(11)  AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(255) NOT NULL,
other_details VARCHAR(255) NOT NULL
);

CREATE TABLE reservations (
id INT(11) AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(255) NOT NULL,
date_of_flight Date NOT NULL,
date_reservation_made Date NOT NULL,
e_ticker_number INT(11) NOT NULL,
other_details VARCHAR(255) NOT NULL,

customer_id INT(11)NOT NULL,
schedule_id INT(11)NOT NULL,
class_number INT(11) NOT NULL,
payment_method_code INT(11) NOT NULL,
reservation_status_code INT(11) NOT NULL,

FOREIGN KEY (customer_id) REFERENCES customers(id),
FOREIGN KEY (schedule_id) REFERENCES flight_schedules(id),
FOREIGN KEY (class_number) REFERENCES ref_classes(class_number),
FOREIGN KEY (payment_method_code) REFERENCES ref_payment_methods(code),
FOREIGN KEY (reservation_status_code) REFERENCES ref_reservation_status(code)
);