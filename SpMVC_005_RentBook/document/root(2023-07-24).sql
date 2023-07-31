-- RentBook root 접속
CREATE DATABASE rentBookDB;
USE rentBookDb;
CREATE TABLE tbl_books (
	B_CODE	VARCHAR(13)	NOT NULL	PRIMARY KEY,
	B_NAME	VARCHAR(125)	NOT NULL,	
	B_AUTHER	VARCHAR(125)	NOT NULL,	
	B_COMP	VARCHAR(125),		
	B_YEAR	INT	NOT NULL,	
	B_IPRICE	INT,		
	B_RPRICE	INT	NOT NULL	
);
DESC tbl_books;
DROP TABLE tbl_books;
SHOW TABLES;
DESC tbl_books;

INSERT INTO tbl_books(
	B_CODE,B_NAME,B_AUTHER,B_COMP,B_YEAR,B_IPRICE,B_RPRICE
) VALUES (
	'001','자바야 놀자','야놀자','놀자출판',2010,20000,2000
);
SELECT * FROM tbl_books;
USE rentbookDB;
CREATE TABLE tbl_members (
	M_CODE	VARCHAR(6)	NOT NULL	PRIMARY KEY,
	M_NAME	VARCHAR(125)	NOT NULL,	
	M_TEL	VARCHAR(15)	NOT NULL,	
	M_ADDR	VARCHAR(125)		
);

CREATE TABLE tbl_rent_book (
	RENT_SEQ	BIGINT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	RENT_DATE	VARCHAR(10)	NOT NULL,	
	RENT_RETURN_DATE	VARCHAR(10)	NOT NULL,	
	RENT_BCODE	VARCHAR(13)	NOT NULL,	
	RENT_MCODE	VARCHAR(6)	NOT NULL,	
	RENT_RETURN_YN	VARCHAR(1),		
	RENT_POINT	INT,		
	RENT_PRICE	INT		
);
SELECT COUNT(*) FROM tbl_books;
SELECT * FROM tbl_books LIMIT 10;

SELECT COUNT(*) FROM tbl_members;

SELECT * FROM tbl_rent_book R
LEFT JOIN tbl_members M
	ON R.rent_mcode = M.m_code
LEFT JOIN tbl_books B
	ON R.rent_bcode = B.b_code;

DESC tbl_books;    

-- 전체 데이터 중에서 5페이지에서 10개를 보고 싶다    
-- 전체 데이터 중에서 1페이지에서 10개 : 0 ~ 9번까지 보여주기
-- 1페이지 일경우 시작값 1이 될려면 (Page - 1) * 10 

-- 전체 데이터 중에서 2페이지에서 10개 : 10 ~ 19번까지
-- 2페이지 일경우 시작값이 10이 되려면 (Page - 1) * 10

-- 전체 데이터 중에서 3페이지에서 10개 : 20 ~ 29번까지
-- 3페이지 일경우 시작값이 20이 되려면 (Page - 1) * 10


-- 처음 시작에서 10개를 건너뛰고 : OFFSET 1
-- 그위치부터 10개를 SELECT 하라
SELECT * FROM tbl_books
ORDER BY B_CODE
LIMIT 10 OFFSET 1;

SELECT COUNT(*) FROM tbl_books
WHERE 
b_name LIKE CONCAT('%', '부자', '%') OR
b_name LIKE CONCAT('%', '행복', '%') OR
b_name LIKE CONCAT('%', '부동산', '%'); 





