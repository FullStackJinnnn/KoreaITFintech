CREATE TABLE DOGFOOD(
	BID INT PRIMARY KEY,
	TITLE VARCHAR(80) NOT NULL,
	PRICE VARCHAR(80) NOT NULL
);

INSERT INTO DOGFOOD (BID, TITLE, PRICE) VALUES ((SELECT COALESCE(MAX(BID), 10) + 1 FROM DOGFOOD), '상품명', '가격');
SELECT * FROM DOGFOOD;
--alter SYSTEM set PROCESSES=300 SCOPE=SPFILE;
DROP TABLE DOGFOOD;


SELECT * FROM DOGFOOD ORDER BY BID ASC;