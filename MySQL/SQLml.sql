
-- 각 사용자별 구매액의 총합을 구하고, 구매액이 큰 순서로 출력하시오
SELECT userID, SUM(price*amount) AS total
FROM buytbl
GROUP BY userID
ORDER BY total DESC;

-- 우리 사이트에서 한 사람이 구매한 평균갯수를 구하시오
SELECT avg(amount) AS average
FROM buytbl;

-- 1. 30번 부서의 직무 별 급여의 평균을 파악하고자 합니다.
SELECT job as '직무',ROUND(avg(SAL), -2) AS '급여 평균'
FROM emp
GROUP BY job;

-- 2. 근무 중인 직원이 4명 이상인 부서의 정보를 출력
-- 출력 컬럼 명: "부서명", "직원 수"
SELECT D.dname AS '부서명', COUNT(D.dname) AS '직원수'
FROM emp E
	 INNER JOIN dept D
     ON D.deptno = E.deptno
GROUP BY dname
HAVING COUNT(dname>=4);

-- 3. 직무 별(job) 급여의 합을 출력하고 마지막에 누적 집계도 출력합니다.
-- 누적 집계를 출력하는 행의 급여의 합은 총합계를 출력합니다.
-- 또한 금액에는 천단위마다 콤마(,)를 출력합니다.
-- 출력 컬럼 명: "직무명", "급여의 합"

SELECT job as '직무',SUM(SAL) AS '급여의 합'
FROM emp
GROUP BY job;

