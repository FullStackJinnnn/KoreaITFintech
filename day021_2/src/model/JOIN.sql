SELECT BID,TITLE,WRITER,NAME
FROM BOARD
INNER JOIN MEMBER ON BOARD.WRITER=MEMBER.MID;

SELECT BID,TITLE,WRITER,NAME
FROM BOARD
INNER JOIN MEMBER ON BOARD.WRITER=MEMBER.MID
ORDER BY BID DESC;

SELECT BID,TITLE,WRITER,NAME
FROM BOARD
INNER JOIN MEMBER ON BOARD.WRITER=MEMBER.MID
WHERE BID=11;