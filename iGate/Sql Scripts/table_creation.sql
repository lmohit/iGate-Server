CREATE database iGate;

USE iGate;

CREATE TABLE visitors
(
	ID varchar(50),
    photo BLOB,
    name varchar(50),
    email varchar(100),
    purpose varchar(1000),
    address varchar(1000),
    meeting_flat_no varchar(50),
    visiting_time timestamp,
    phone_number varchar(14),
    PRIMARY KEY MY_KEY (ID)
);

ALTER TABLE visitors ADD COLUMN phone_number varchar(14);

ALTER TABLE visitors MODIFY photo varchar(100);