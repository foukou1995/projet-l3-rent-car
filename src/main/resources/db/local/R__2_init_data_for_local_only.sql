-- noinspection SqlResolveForFile
--Insert initial data into Vehicle table
INSERT INTO vehicle (brand, model, year, rental_cost_per_day, available, location)
VALUES ('Toyota', 'Corolla', 2020, 4500.0, TRUE, 'Alger'),
       ('Ford', 'Fiesta', 2019, 3500.0, TRUE, 'Oran'),
       ('BMW', 'X5', 2021, 7000.0, TRUE, 'Constantine'),
       ('Renault', 'Clio', 2018, 3000.0, TRUE, 'Alger'),
       ('Peugeot', '208', 2022, 4000.0, TRUE, 'Oran');

-- Insert initial data into Customer table
INSERT INTO customer (last_name, first_name, email, password, role, number_licence, expiry_date_licence, date_birth, phone)
VALUES ('Benali', 'Ahmed', 'ahmed.benali@example.dz', 'password123', 'client', 'DZ123456', '2025-12-31', '1985-01-15', '0550123456'),
       ('Zohra', 'Fatima', 'fatima.zohra@example.dz', 'password456', 'client', 'DZ654321', '2026-11-30', '1990-04-22', '0660789456'),
       ('Boussouf', 'Mohamed', 'mohamed.boussouf@example.dz', 'password789', 'client', 'DZ789456', '2024-10-25', '1988-07-19', '0770345678'),
       ('Bouzid', 'Yasmine', 'yasmine.bouzid@example.dz', 'password012', 'client', 'DZ321654', '2027-09-15', '1992-12-05', '0540987654');


-- Insertion des données initiales dans la table RentalRecord
INSERT INTO rental_record (start_date, end_date, total_cost, vehicle_id, customer_id, status)
VALUES ('2024-05-01', '2024-05-10', 45000.0, 1, 1, 'Approuvé'),
       ('2024-06-15', '2024-06-20', 17500.0, 2, 2, 'En attente'),
       ('2024-07-01', '2024-07-05', 35000.0, 3, 3, 'Rejeté'),
       ('2024-08-01', '2024-08-07', 21000.0, 4, 4, 'Approuvé');


-- Insert initial data into License table
INSERT INTO license (customer_id, number, expiry_date)
VALUES (1, 'DZA123456', '2025-12-31'),
       (2, 'DZA654321', '2024-11-30'),
       (3, 'DZA987654', '2026-10-15'),
       (4, 'DZA456789', '2023-09-10');

-- Insert initial data into Invoice table
INSERT INTO invoice (rental_record_id, amount, issued_date)
VALUES (1, 45000.0, '2024-05-11'),
       (2, 17500.0, '2024-06-21'),
       (3, 35000.0, '2024-07-06'),
       (4, 21000.0, '2024-08-08');