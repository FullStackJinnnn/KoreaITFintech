
CREATE TABLE COMMEND(
	COMMENDNUM INT PRIMARY KEY,
	BOARDNUM INT,
	MEMBERNUM INT,
	FOREIGN KEY (BOARDNUM) REFERENCES BOARD(BOARDNUM)
);