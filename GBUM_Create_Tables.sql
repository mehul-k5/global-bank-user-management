DROP TABLE IF EXISTS GBUM.transaction_details;
DROP TABLE IF EXISTS GBUM.loan_details;
DROP TABLE IF EXISTS GBUM.account_master;
DROP TABLE IF EXISTS GBUM.User;
DROP TABLE IF EXISTS GBUM.customer_master;
DROP TABLE IF EXISTS GBUM.branch_master;

CREATE TABLE GBUM.branch_master(
branch_id varchar(6) NOT NULL PRIMARY KEY,
branch_name varchar(30) NOT NULL,
branch_city varchar(30) NOT NULL
);

CREATE TABLE GBUM.customer_master(
customer_number varchar(6) NOT NULL PRIMARY KEY,
firstname varchar(30) NOT NULL,
middlename varchar(30),
lastname varchar(30) NOT NULL,
customer_city varchar(15) NOT NULL,
customer_contact_no varchar(10) NOT NULL,
occupation varchar(20) NOT NULL,
customer_date_of_birth date NOT NULL
);

CREATE TABLE GBUM.loan_details(
customer_number varchar(6) NOT NULL,
branch_id varchar(6) NOT NULL,
loan_amount int NOT NULL,
CONSTRAINT FK_customer_master_loan_details FOREIGN KEY (customer_number)
REFERENCES GBUM.customer_master(customer_number),
CONSTRAINT FK_branch_master_loan_details FOREIGN KEY (branch_id)
REFERENCES GBUM.branch_master(branch_id),
CONSTRAINT PK_loan_details PRIMARY KEY (customer_number, branch_id)
);

CREATE TABLE GBUM.account_master(
account_number varchar(6) NOT NULL PRIMARY KEY,
customer_number varchar(6),
branch_id varchar(6),
opening_balance int NOT NULL,
account_opening_date date NOT NULL,
account_type varchar(10) NOT NULL,
account_status varchar(10) NOT NULL,
FOREIGN KEY (customer_number) REFERENCES GBUM.customer_master(customer_number),
FOREIGN KEY (branch_id) REFERENCES GBUM.branch_master(branch_id)
);

CREATE TABLE GBUM.transaction_details(
transaction_number varchar(6) NOT NULL PRIMARY KEY,
account_number varchar(6),
date_of_transaction date NOT NULL,
medium_of_transaction varchar(20) NOT NULL,
transaction_type varchar(20) NOT NULL,
transaction_amount int NOT NULL,
FOREIGN KEY (account_number) REFERENCES GBUM.account_master(account_number)
);

create table GBUM.User(
user_id varchar(6),
password varchar(10),
FOREIGN KEY (user_id) REFERENCES GBUM.customer_master(customer_number)
);