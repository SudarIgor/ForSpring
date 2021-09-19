DROP TABLE  IF EXISTS products;
CREATE TABLE products
(
    id      bigserial PRIMARY KEY,
    title   VARCHAR(255),
    price   DECIMAL (15,2));

INSERT INTO products (title, price)
values ('Cola', 45),
       ('Fanta', 50),
       ('ise cream', 66);