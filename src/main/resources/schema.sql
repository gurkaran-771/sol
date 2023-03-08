create table if not exists clothes (
    id IDENTITY,
    name VARCHAR(30),
    price NUMBER,
    year_of_creation INT,
    brand VARCHAR(30)
);