INSERT INTO airplane.air_company (id, company_type, founded_at, name) VALUES (1, 'AirCompany', '1926-04-26', 'United_AirLines');
INSERT INTO airplane.air_plane (id, created_at, flight_distance, fuel_capacity, name, number_of_flight, serial_number, type_of_air_plane, air_company_id) VALUES (1, '1990-10-10', 3400, 10707, 'Boeing 737', 315, 'SERIAL135', 'Passenger', 1);
INSERT INTO airplane.flight (id, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, flight_status, started_at, air_company_id, air_plane_id) VALUES (1, '0010-10-10 10:00:00', 'Toronto', 'Berlin', 3500, '2021-03-06 12:12:00', '2021-03-07 16:33:39.810998', 'ACTIVE', '2021-03-07 16:48:24.913422', 1, 1);
INSERT INTO airplane.flight (id, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, flight_status, started_at, air_company_id, air_plane_id) VALUES (2, '2021-03-06 12:10:00', 'Amsterdam', 'Chicago', 1700, '2021-03-06 21:40:00', '2021-03-06 10:10:00', 'ACTIVE', '2021-03-07 16:48:29.859184', 1, 1);
INSERT INTO airplane.flight (id, delay_started_at, departure_country, destination_country, distance, ended_at, estimated_flight_time, flight_status, started_at, air_company_id, air_plane_id) VALUES (3, '2021-03-08 18:10:00', 'Lviv', 'Odessa', 900, '2021-03-08 18:10:00', '2021-03-08 18:10:00', 'PENDING', '2021-03-08 12:10:00', 1, 1);