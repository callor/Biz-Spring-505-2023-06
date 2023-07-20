-- mycarDB root 로 접속
USE mycarDB;
CREATE TABLE tbl_users (
	username	VARCHAR(15)		PRIMARY KEY,
	password	VARCHAR(255)	NOT NULL,	
	u_name	VARCHAR(20)	NOT NULL,	
	u_nickname	VARCHAR(20),		
	u_tel	VARCHAR(15),		
	u_role	VARCHAR(15)	NOT NULL	
);

DROP TABLE tbl_carmanager;
SHOW TABLES;
DROP TABLE tbl_users;
SHOW TABLES;


