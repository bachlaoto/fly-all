USE fly;
SELECT *
FROM airlines;
INSERT INTO `fly`.`airlines` (`name`, `other_details`)
VALUES ('Airline 1', 'Airline details 1');
INSERT INTO `fly`.`airlines` (`name`, `other_details`)
VALUES ('Airline 2', 'Airline details 2');
INSERT INTO `fly`.`airlines` (`name`, `other_details`)
VALUES ('Airline 3', 'Airline details 3');
INSERT INTO `fly`.`airlines` (`name`, `other_details`)
VALUES ('Airline 4', 'Airline details 4');
INSERT INTO `fly`.`airlines` (`name`, `other_details`)
VALUES ('Airline 5', 'Airline details 5');
SELECT *
FROM flight_schedules;
INSERT INTO `fly`.`flight_schedules` (`arrival_time`,
                                      `departure_time`,
                                      `flight_number`,
                                      `other_details`,
                                      `airline_code`)
VALUES ('2018-08-01T09:00:00', '2018-08-01T07:00:00', '111', 'Details flight schedules', '1');
INSERT INTO `fly`.`flight_schedules` (`arrival_time`,
                                      `departure_time`,
                                      `flight_number`,
                                      `other_details`,
                                      `airline_code`)
VALUES ('2018-08-02T09:00:00', '2018-08-02T07:00:00', '222', 'Details flight schedules', '2');
INSERT INTO `fly`.`flight_schedules` (`arrival_time`,
                                      `departure_time`,
                                      `flight_number`,
                                      `other_details`,
                                      `airline_code`)
VALUES ('2018-08-03T09:00:00', '2018-08-03T07:00:00', '333', 'Details flight schedules', '3');
INSERT INTO `fly`.`flight_schedules` (`arrival_time`,
                                      `departure_time`,
                                      `flight_number`,
                                      `other_details`,
                                      `airline_code`)
VALUES ('2018-08-04T09:00:00', '2018-08-04T07:00:00', '444', 'Details flight schedules', '4');
INSERT INTO `fly`.`flight_schedules` (`arrival_time`,
                                      `departure_time`,
                                      `flight_number`,
                                      `other_details`,
                                      `airline_code`)
VALUES ('2018-08-05T09:00:00', '2018-08-04T07:00:00', '555', 'Details flight schedules', '5');
SELECT *
FROM customers;
INSERT INTO `fly`.`customers` (`customer_name`, `other_details`)
VALUES ('cCustomers Name 1', 'Customers details 1');
INSERT INTO `fly`.`customers` (`customer_name`, `other_details`)
VALUES ('cCustomers Name 2', 'Customers details 2');
INSERT INTO `fly`.`customers` (`customer_name`, `other_details`)
VALUES ('cCustomers Name 3', 'Customers details 3');
INSERT INTO `fly`.`customers` (`customer_name`, `other_details`)
VALUES ('cCustomers Name 4', 'Customers details 4');
INSERT INTO `fly`.`customers` (`customer_name`, `other_details`)
VALUES ('cCustomers Name 5', 'Customers details 5');
SELECT *
FROM ref_classes;
INSERT INTO `fly`.`ref_classes` (`class_number_description`)
VALUES ('Class numbe rdescription 1');
INSERT INTO `fly`.`ref_classes` (`class_number_description`)
VALUES ('Class numbe rdescription 2');
INSERT INTO `fly`.`ref_classes` (`class_number_description`)
VALUES ('Class numbe rdescription 3');
INSERT INTO `fly`.`ref_classes` (`class_number_description`)
VALUES ('Class numbe rdescription 4');
INSERT INTO `fly`.`ref_classes` (`class_number_description`)
VALUES ('Class numbe rdescription 5');
SELECT *
FROM ref_payment_methods;
INSERT INTO `fly`.`ref_payment_methods` (`payment_method_description`)
VALUES ('Ref payment methods 1');
INSERT INTO `fly`.`ref_payment_methods` (`payment_method_description`)
VALUES ('Ref payment methods 2');
INSERT INTO `fly`.`ref_payment_methods` (`payment_method_description`)
VALUES ('Ref payment methods 3');
INSERT INTO `fly`.`ref_payment_methods` (`payment_method_description`)
VALUES ('Ref payment methods 4');
INSERT INTO `fly`.`ref_payment_methods` (`payment_method_description`)
VALUES ('Ref payment methods 5');
SELECT *
FROM ref_reservation_status;
INSERT INTO `fly`.`ref_reservation_status` (`reservation_status_description`)
VALUES ('Ref Reservation Status 1');
INSERT INTO `fly`.`ref_reservation_status` (`reservation_status_description`)
VALUES ('Ref Reservation Status 2');
INSERT INTO `fly`.`ref_reservation_status` (`reservation_status_description`)
VALUES ('Ref Reservation Status 3');
INSERT INTO `fly`.`ref_reservation_status` (`reservation_status_description`)
VALUES ('Ref Reservation Status 4');
INSERT INTO `fly`.`ref_reservation_status` (`reservation_status_description`)
VALUES ('Ref Reservation Status 5');
SELECT *
FROM reservations;
INSERT INTO `fly`.`reservations` (`customer_name`,
                                  `date_of_flight`,
                                  `date_reservation_made`,
                                  `e_ticker_number`,
                                  `other_details`,
                                  `customer_id`,
                                  `schedule_id`,
                                  `class_number`,
                                  `payment_method_code`,
                                  `reservation_status_code`)
VALUES ('Customer Name 1',
        '2018-08-01T09:00:00',
        '2018-08-01T07:00:00',
        '1',
        'Other details 1',
        '1',
        '1',
        '1',
        '1',
        '1');
INSERT INTO `fly`.`reservations` (`customer_name`,
                                  `date_of_flight`,
                                  `date_reservation_made`,
                                  `e_ticker_number`,
                                  `other_details`,
                                  `customer_id`,
                                  `schedule_id`,
                                  `class_number`,
                                  `payment_method_code`,
                                  `reservation_status_code`)
VALUES ('Customer Name 2',
        '2018-08-02T09:00:00',
        '2018-08-02T07:00:00',
        '2',
        'Other details 2',
        '2',
        '2',
        '2',
        '2',
        '2');
INSERT INTO `fly`.`reservations` (`customer_name`,
                                  `date_of_flight`,
                                  `date_reservation_made`,
                                  `e_ticker_number`,
                                  `other_details`,
                                  `customer_id`,
                                  `schedule_id`,
                                  `class_number`,
                                  `payment_method_code`,
                                  `reservation_status_code`)
VALUES ('Customer Name 3',
        '2018-08-03T09:00:00',
        '2018-08-03T07:00:00',
        '3',
        'Other details 3',
        '3',
        '3',
        '3',
        '3',
        '3');
INSERT INTO `fly`.`reservations` (`customer_name`,
                                  `date_of_flight`,
                                  `date_reservation_made`,
                                  `e_ticker_number`,
                                  `other_details`,
                                  `customer_id`,
                                  `schedule_id`,
                                  `class_number`,
                                  `payment_method_code`,
                                  `reservation_status_code`)
VALUES ('Customer Name 4',
        '2018-08-04T09:00:00',
        '2018-08-04T07:00:00',
        '4',
        'Other details 4',
        '4',
        '4',
        '4',
        '4',
        '4');
INSERT INTO `fly`.`reservations` (`customer_name`,
                                  `date_of_flight`,
                                  `date_reservation_made`,
                                  `e_ticker_number`,
                                  `other_details`,
                                  `customer_id`,
                                  `schedule_id`,
                                  `class_number`,
                                  `payment_method_code`,
                                  `reservation_status_code`)
VALUES ('Customer Name 5',
        '2018-08-05T09:00:00',
        '2018-08-05T07:00:00',
        '5',
        'Other details 5',
        '5',
        '5',
        '5',
        '5',
        '5');
