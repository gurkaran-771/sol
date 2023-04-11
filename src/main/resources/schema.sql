CREATE TABLE IF NOT EXISTS clothe (
    id IDENTITY,
    name VARCHAR(30) NOT NULL,
    year_of_creation VARCHAR(30) NOT NULL,
    price NUMBER NOT NULL,
    brand VARCHAR(30) NOT NULL
);