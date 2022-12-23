-- 새로운 테이블을 하나 만들어서
-- 아래에서 가져온 데이터를 입력할거에요

-- 테이블부터 만들자
CREATE TABLE indexTBL (
	first_name	VARCHAR(14),
    last_name 	VARCHAR(16),
    hire_date	DATE
);

INSERT INTO indexTBL 
	SELECT first_name, last_name, hire_date
	FROM employees.employees
	LIMIT 500;

-- 들어갔는지 확인해 보자
SELECT *
FROM indexTBL;

-- 데이터가 들어갔고, 아직 index는 설정 안 함

-- 특정 사람을 검색해 보자
-- first_name이 Mary인 사람을 찾아서
-- 이름과 성, 입사일을 출력하세요

SELECT first_name, last_name, hire_date
FROM indexTBL
WHERE first_name = "Mary";

DROP TABLE indexTBL;

-- index를 생성해 보자
CREATE INDEX idx_indexTBL_firstname
ON indexTBL(first_name);

