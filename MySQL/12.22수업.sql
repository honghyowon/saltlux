
USE sqldb;

-- transaction 
START TRANSACTION;

SELECT *
FROM usertbl;

DELETE
FROM usertbl;

ROLLBACK;

-- COMMIT(작업한 SQL구문을 정말로 적용),
-- ROLLBACK(Transaction으로 설정된 작업을 무시)
COMMIT;
