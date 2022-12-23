
-- 가장 먼저, 사용할 DB를 지정한다
-- USE DB 이름
USE employees;

-- SQL은 대소문자를 구분하지 않음
-- 하지만 가독성(Readability)을 위해 
-- 키워드는 대문자, 사용자 정의어는 소문자로 사용

--  DB 조회
SHOW DATABASES;

-- 테이블의 상태 조회
SHOW TABLE STATUS;

-- 특정 테이블 명세를 조회 (내림차순)
DESC departments;
DESC employees;

-- SELECT 구문
-- 데이터를 추출하기 위해 사용하는 구문
-- SELECT 컬럼명들
SELECT  first_name, last_name, birth_date
FROM employees;
-- 이거 실행하면 결과집합이 리턴됨
-- resultset, 결과레코드집합, Result Grid

-- 만약 결과집합의 컬럼명을 바꾸고자 한다면
-- Alias를 이용하면 됨
SELECT first_name AS '나의 이름',
	   last_name  AS 성,
       birth_date AS 생년월일
FROM employees;

-- 그러면 항상 모든 데이터를 가져오는 건가요?
-- 만약 조건절이 없으면 당연히 모든 데이터를 가져옴
-- 만약 원하는 조건이 있다면 조건절을 이용해야 함

-- 이거하기 전에, 데이터셋을 하나 만들어야 함
-- 테이블 생성하고, 데이터도 INSERT 했음(한글 처리 조심)

-- 이름이 김경호인 사람의 정보를 출력하세요
SELECT *
FROM usertbl
WHERE NAME = '김경호';

SELECT userID, name
FROM usertbl
WHERE (birthYear >=1972) and HEIGHT >=182 ;

SELECT userID, name
FROM usertbl
WHERE (HEIGHT >= 180) AND (HEIGHT <= 183)  ;

-- 이상 이하 between and
SELECT userID, name
FROM usertbl
WHERE HEIGHT BETWEEN 180 AND 183  ;

-- 지역이 경남, 전남, 전북 사람의 이름,지역을 출력해주세요
SELECT name, addr
FROM usertbl
WHERE addr IN ('경남', '전남', '전북'); 

SELECT name, addr
FROM usertbl
WHERE (addr = '경남') OR (addr = '전남') OR (addr ='전북'); 

-- 패턴 매칭
-- 김씨성 이름/키 조회
-- 와일드카드 문자 ( % , _ )
-- % : 0개 이상의 문자열
-- 자바% : 자바 로 시작하는 모둔 문자열
-- 자바, 자바1, 자바어려워요
-- %자바% : 자바라는 글자가 들어있는 모든 문자열
-- _ : 1개 문자열
-- 자바_ : 자바킹, 자바왕 

SELECT name, height
FROM usertbl
WHERE name LIKE '김%';

-- 김경호보다 키가 크거나 같은 사람의 이름,키 출력
SELECT name, height
FROM usertbl
WHERE height >= 177; 

-- 서브쿼리 이용하기
SELECT name, height
FROM usertbl
WHERE height >= (SELECT height
				 FROM usertbl
				 WHERE name = '김경호'); 
                 
-- 지역이 '경남'인 사람의 키보다 크거나 같은 사람의 이름/키 조회하기
SELECT name, height
FROM usertbl
WHERE height >= ANY (SELECT height
			     FROM usertbl
                 WHERE addr = '경남');

-- 먼저 가입한 순서대로 회원의 이름, 가입일을 출력
SELECT name, mDate
FROM usertbl
ORDER BY mDate ASC;

-- 회원의 이름, 가입일, 키를 출력
-- 키 순서대로 , 오름차순
SELECT name, mDate, height
FROM usertbl
ORDER BY height DESC, mdate ASC;

-- DISTINCT 중복 제거
-- 회원들의 거주지역이 어디인지 출력하시오
SELECT DISTINCT addr
FROM usertbl;

--
-- 회원가입이 오래된 사람들 3명을 출력하시오
SELECT *
FROM usertbl
ORDER BY mdate ASC 
LIMIT 3;


-- 테이블 복사하는 가장 간단한 방법
CREATE TABLE usertbl2(
	SELECT *
    FROM usertbl
);
-- 쉽고 간편하게 복사할 순 있지만..
-- 제약사항은 포함 안 됨(Primary key, Foreign key...)alter

-- 여기까지가 기본 SQL SELECT 구문.

-- Grouping이 나옴

-- 구매테이블에서 사용자가 구매한 물품의 갯수를 출력하세요
-- 각각의 사용자별로 제품 상관없이 모두 몇개를 지금까지 구매했는지 구해보자
SELECT userID, SUM(amount) AS '총 구매 개수'
FROM buytbl
GROUP BY userID;

-- 각 사용자별 구매액의 총합을 구하고, 구매액이 큰 순서로 출력하시오
SELECT userID, SUM(price*amount) AS total
FROM buytbl
GROUP BY userID
ORDER BY total DESC;

-- 우리 사이트에서 한 사람이 구매한 평균갯수를 구하시오
SELECT avg(amount) AS average
FROM buytbl;

-- usertbl에서 가장 큰 키, 가장 작은 키의 회원이름/키 출력하시오
SELECT MAX(HEIGHT) as max, MIN(HEIGHT) as max
FROM usertbl;
GROUP BY height;

MIN(HEIGHT) as min

-- usertble에서 휴대폰이 있는 사용자의 수를 출력하시오
SELECT COUNT(userID)
FROM usertbl;

-- HAVING은 그룹에 대한 조건
-- 사용자별 총 구매금액이 1,000 이상인 사용자의 ID와 구매금액을 출력하시오 
SELECT userID, SUM(price*amount) AS total
FROM buytbl
GROUP BY userID
HAVING total >= 1000;

-- 기본적인 SQL구문 순서
-- select
-- from
-- where
-- group by
-- having
-- order by


SELECT *
FROM buytbl;



SELECT *
FROM usertbl; 


commit;