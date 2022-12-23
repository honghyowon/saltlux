-- INSERT 구문
-- TABLE안에 데이터를 삽입하기 위한 SQL구문(DML)

USE sqldb;

-- DDL을 이용해서 TABLE을 하나 생성해 보자
-- DDL은 기본적으로 TRANSACTION을 적용할 수 없음

CREATE TABLE testtbl1 (
	id			INT,
    username	CHAR(3),
    age			INT
);

-- 가장 일반적인 데이터 삽입 INSERT 구문
INSERT INTO testtbl1
VALUES(1, '홍길동', 20);

-- 이렇게도 할 수 있음
INSERT INTO testtbl1(id, age)
VALUES(2, 30);

INSERT INTO testtbl1(username, age, id)
VALUES('최길동', 40, 3);

-- 이번에는 table을 약간 색다르게 만들어 보자
-- auto_increment 자동 생성 : 기본적으로 1부터 시작해서 1씩 증가
-- 시작값과 증가되는 값을 변경할 수 있음
CREATE TABLE testtbl2(
	id			INT AUTO_INCREMENT PRIMARY KEY,
    userName	CHAR(3),
    age			INT    
);

INSERT INTO testtbl2
VALUES (NULL, '홍길동', 20);

INSERT INTO testtbl2
VALUES (NULL, '최길동', 30);

-- 여기까지 INSERT --------------------------------

-- 수정 UPDATE
UPDATE testtbl2
SET userName = '홍길동'
WHERE age = 30;

UPDATE testtbl2
SET userName = '없음';

-- 삭제 DELETE (DROP 아님)
START TRANSACTION;

DELETE
FROM testtbl2
WHERE age = 30;



ROLLBACK;


-- 삭제 관련 3가지
-- DELETE (테이블에서 row를 삭제) - transaction log를 기록
							  -- 시간이 오래 걸림
-- DROP (테이블 자체를 삭제)
-- TRUNCATE (테이블에서 row를 삭제) -- transaction log
								-- 냅다 지움. 속도가 빠름
commit;
SELECT * FROM testtbl1;
SELECT * FROM testtbl2;

-- ---------------------------------------------------------------

-- SQL 형변환

SELECT *
FROM buytbl;

-- buytbl에서
SELECT AVG(amount) AS '평균 구매 갯수'
FROM buytbl;

-- 실수를 정수로 변환해보자 (반올림)
SELECT CAST(AVG(amount) AS UNSIGNED INTEGER) AS '평균 구매 갯수'
FROM buytbl;

-- 다양한 구분자로 되어 있는 날짜를 날짜형식으로 바꿔보자
-- 문자열에 입력되어 있는 날짜를 날짜형식으로 바꿈
SELECT CAST('2022/12/22' AS DATE);


-- 
SELECT num, price*amount
FROM buytbl;

-- concat을 이용해서 문자열을 이어줌
SELECT num,
	   CONCAT('price', '*', 'amount'),
       price*amount
FROM buytbl;

SELECT num,
	   CONCAT(CAST(price AS CHAR(5)), '*', CAST(amount AS CHAR(4))) AS '단가*수량',
       price*amount AS '구매액'
FROM buytbl;


-- MySQL(SQL)은 묵시형 형 변환이 특이함
-- 이걸 다 외우긴 힘들고, 살펴보고 아 이상하구나 라는 건 기억하는게 좋을 것 같음

SELECT '100' + '200';
SELECT 'Hello' + 'World';

SELECT CONCAT('Hello', 'World');
SELECT CONCAT(100, '200');

SELECT 1 > '2hoho';		-- 0은 false, 1은 true

SELECT 0 = 'Hello';		-- 1

-- -----------------------------------------------------------------

-- 기본연산에 대해 알아보았음..=> +

-- 그 다음에는 제공되는 함수들에 대해 알아보자
-- 굉장히 많은 함수들이 MySQL에 의해 제공됨
-- 너무 많아서 외우는 건 불가, 외울 필요도 없음
-- but, 기본함수는 알아두자

-- 가장 많이 사용되는 함수는 문자열 관련 함수들 !
-- LENGTH는 문자열의 길이가 아니라, 해당 문자열을 저장하는 바이트 수
SELECT LENGTH('abcde'); -- 5/영어는 1글자 저장하는데 1바이트가 필요
SELECT LENGTH('홍길동'); -- 9/한글은 1글자 저장하는데 3바이트 필요


-- CHAR_LENGTH가 문자열의 길이를 알아내는 함수
SELECT CHAR_LENGTH('abcde');
SELECT CHAR_LENGTH('홍길동');

SELECT CONCAT('Hello', 'World');
SELECT CONCAT_WS('-', 'Hello', 'World', 'hahaha');


-- 기준문자열에서 찾고자하는 문자열을 찾아서 그 시작위치를 알려줌
SELECT INSTR('이것은 소리없는 아우성!','소학');

-- 숫자를 소수점 아래 자리수까지 표현하는 방법
-- 뒤에 숫자만큼 소수점 나옴
-- 콤마도 찍어줌
SELECT FORMAT(12345678.123456789, 6);

--  나머지 문자열 관련된 많은 함수들은 문제를 풀면서 알아보자
SELECT ROUND(3.141592);

-- 현재 날짜 CURDATE
SELECT CURDATE();

-- 현재 날짜,시분초까지 나옴
SELECT NOW();
-- 현재 YEAR
SELECT YEAR(CURDATE());
SELECT ADDDATE('2022-12-22', INTERVAL 2 MONTH);

-- ---------JOIN---------------
SELECT *
FROM usertbl;

SELECT *
FROM buytbl;

SELECT usertbl.userID, name
FROM usertbl
	 INNER JOIN buytbl
     ON usertbl.userID = buytbl.userID;
-- 테이블 이름을 축약할 수 있음
SELECT usertbl.userID, name
FROM usertbl U
	 INNER JOIN buytbl B
     ON U.userID = B.userID;
     
-- 물품을 한번이라도 구매한 기록이 있는 회원들에게 감사의 안내문 보내기
-- 물품을 한번이라도 구매한 사람의 이름과 주소를 출력하시오
-- JOIN을 이용한 방식
SELECT DISTINCT name, addr, amount
FROM usertbl U
	 INNER JOIN buytbl B
     ON U.userID = B.userID;
WHERE amount>=1;

-- subQury 이용
SELECT U.userID, U.name, U.addr
FROM usertbl U
WHERE EXISTS(
	SELECT *
    FROM buytbl B
    WHERE U.userid = B.userid);

-- ----------------------------------------------------------------
-- 1. 학생을 기준으로 학생이름, 지역, 가입한 동아리, 동아리방을 출력하시오
-- stdName, addr, clubName, roomNo    
SELECT S.stdName, S.addr, SC.clubName, C.roomNo
FROM stdtbl S
	INNER JOIN stdclubtbl SC
	ON S.stdName = SC.stdName
    INNER JOIN clubtbl c
    ON SC.clubName = C.clubname;
    
-- 전체 회원의 구매기록을 조회하시오
-- 단, 구매 기록이 없는 회원도 출력되어야 함
-- OUTER JOIN을 이용하면 편함
SELECT *
FROM usertbl U
	 LEFT OUTER JOIN buytbl
     ON U.userid = B.userid

-- 한번도 구매한 적 없는 회원의 이름과 주소를 출력하시오
SELECT *
FROM usertbl U
	 LEFT OUTER JOIN buytbl B
     ON U.userid = B.userid
WHERE B.prodName IS NULL;

-- UNION에 대해 알아보자
-- 전체 결과 집합 구조는 위쪽에 있는 결과 집합의 구조를 따라감
-- 위쪽과 아래쪽 결과집합의 컬럼수와 데이터타입이 같아야함
-- UNION(중복배제), UNION ALL(무조건 붙음)
(SELECT name, height, addr
FROM usertbl
WHERE height > 180)
UNION
(SELECT userid, price
FROM buytbl
WHERE price > 500);

-- 모든 사용자를 조회하는데 전화가 없는 사람을 제외하고 출력하시오
SELECT name, CONCAT_WS('-', mobile1, mobile2)
FROM usertbl
WHERE mobile1 IS NOT NULL;

