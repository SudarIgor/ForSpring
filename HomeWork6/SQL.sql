DROP TABLE IF EXISTS client;
CREATE TABLE clients
(
    id      bigserial PRIMARY KEY,
    name    VARCHAR(255));
INSERT INTO clients (name) VALUES
                               ('Anna'),
                               ('Natalia'),
                               ('Bob'),
                               ('Jon');


DROP TABLE  IF EXISTS products;
CREATE TABLE products
(
    id      bigserial PRIMARY KEY,
    title   VARCHAR(255),
    price   DECIMAL (15,2));
INSERT INTO products (title, price) VALUES
                                        ('Bread', 47),
                                        ('Butter', 290),
                                        ('Cheese', 300),
                                        ('Milk', 60),
                                        ('Sausage', 480),
                                        ('Salad', 90),
                                        ('Cupcake', 35),
                                        ('Loaf', 55);

DROP TABLE IF EXISTS orders ;
CREATE TABLE orders
(
    client_id       bigint,
    product_id      bigint,
    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

INSERT INTO orders (client_id, product_id) VALUES
                                               (1,1),
                                               (1,3),
                                               (1,5),
                                               (1,6),
                                               (1,7),
                                               (2,2),
                                               (2,7),
                                               (3,4),
                                               (3,8),
                                               (3,3),
                                               (4,1),
                                               (4,6),
                                               (4,7),
                                               (4,8);
