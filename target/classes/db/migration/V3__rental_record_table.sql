-- noinspection SqlResolveForFile

-- Table RentalRecord
CREATE TABLE rental_record
(
    id          SERIAL PRIMARY KEY,
    start_date  DATE,
    end_date    DATE,
    total_cost  FLOAT,
    vehicle_id  INT,
    customer_id INT,
    status      VARCHAR(10) NOT NULL CHECK (status IN ('Approuvé', 'En attente', 'Rejeté')),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);