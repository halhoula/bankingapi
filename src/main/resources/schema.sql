-- Create Customer table
CREATE TABLE customer (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    balance DOUBLE
);

-- Create Account table
CREATE TABLE account (
    id INT PRIMARY KEY,
    balance DOUBLE,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- Create Transaction table
CREATE TABLE transaction (
    id INT PRIMARY KEY,
    amount DOUBLE,
    type VARCHAR(50),
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(id)
);

CREATE SEQUENCE account_seq
  START WITH 1
  INCREMENT BY 1;

CREATE SEQUENCE customer_seq
  START WITH 1
  INCREMENT BY 1;

CREATE SEQUENCE transaction_seq
  START WITH 1
  INCREMENT BY 1;