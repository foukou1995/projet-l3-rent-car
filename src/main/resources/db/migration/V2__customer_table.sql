-- noinspection SqlResolveForFile

-- Table Customer
CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          last_name VARCHAR(255),
                          first_name VARCHAR(255),
                          email VARCHAR(255),
                          password VARCHAR(255) NOT NULL,
                          role VARCHAR(10) NOT NULL CHECK (role IN ('admin', 'client')),
                          number_licence VARCHAR(255),
                          expiry_date_licence DATE,
                          date_birth DATE NOT NULL,
                          phone VARCHAR(20)
);