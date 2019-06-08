CREATE TABLE customers
(
  customer_id SERIAL PRIMARY KEY NOT NULL,
  last_name VARCHAR NOT NULL,
  area VARCHAR NOT NULL,
  discount INT NOT NULL
);
CREATE UNIQUE INDEX customer_id_uidx ON customers (customer_id);

INSERT INTO customers (last_name, area, discount) VALUES ('Ivanov', 'Nizhegorodskiy',15);
INSERT INTO customers (last_name, area, discount) VALUES ('Petrov', 'Sormovskiy',10);
INSERT INTO customers (last_name, area, discount) VALUES ('Sidorov', 'Sovetskiy',30);
INSERT INTO customers (last_name, area, discount) VALUES ('Malinin', 'Leninskiy',5);
INSERT INTO customers (last_name, area, discount) VALUES ('Kozlovskiy', 'Sovetskiy',31);
INSERT INTO customers (last_name, area, discount) VALUES ('Artemyev', 'Sormovskiy',32);


