create database auction;
use auction;

CREATE TABLE tbl_user_profile(
	id INT IDENTITY,
	full_name VARCHAR(255) NOT NULL,
	contact VARCHAR(255),
	username VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);


SP_HELP tbl_user_profile;


INSERT INTO tbl_user_profile(full_name, contact, username, password) 
VALUES('Gaurab Shrestha', '9861211775', 'admin', 'admin');

SELECT * FROM tbl_user_profile;

--query to login 
SELECT * FROM tbl_user_profile WHERE username='admin' AND password = 'admin';