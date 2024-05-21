DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id serial PRIMARY KEY,
    name VARCHAR(255) ,
    description VARCHAR(255) ,
    price DECIMAL(10, 2)
);



