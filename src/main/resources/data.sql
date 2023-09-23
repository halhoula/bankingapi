-- Insert initial data into Customer table
INSERT INTO customer (id, name, surname, balance) VALUES (NEXTVAL('customer_seq'), 'Amina', 'HALHOUL',100.00);
INSERT INTO customer (id, name, surname, balance) VALUES (NEXTVAL('customer_seq'), 'name', 'surname',0.00);

INSERT INTO account (id, balance, customer_id) VALUES (NEXTVAL('account_seq'), 100.00, 1);
INSERT INTO account (id, balance, customer_id) VALUES (NEXTVAL('account_seq'), 300.00, 2);

INSERT INTO transaction (id, amount, type, account_id) VALUES (NEXTVAL('transaction_seq'), 200.00, 'CREDIT', 1);
INSERT INTO transaction (id, amount, type, account_id) VALUES (NEXTVAL('transaction_seq'), 100.00, 'DEBIT', 1);
INSERT INTO transaction (id, amount, type, account_id) VALUES (NEXTVAL('transaction_seq'), 300.00, 'CREDIT', 2);
