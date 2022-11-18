/*
 * 집합 연산자
 *     - 2 개 이상의 Record Set 결과를 하나의 Record Set 결과로 만드는 연산자
 *     - UNION, UNION ALL, INTERSECT, MINUS 연산자가 있다.
 * 
 * UNION ALL
 *     - 모든 Record Set 의 결과를 합쳐서 하나의 Record Set 으로 만든다.
 *     - 합집합(중복허용)
 * 
 * UNION
 *     - 모든 Record Set 의 결과를 합쳐서 하나의 Record Set 으로 만든다.
 *       단, 중복된 결과는 하나만 반영 한다.
 *     - 합집합(중복불허)
 * 
 * INTERSECT
 *     - 모든 Record Set 의 결과를 합칠 때 중복 Record 에 대해서만 하나의
 *       Record Set 으로 합친다.
 *     - 교집합
 * 
 * MINUS
 *     - A, B Record Set 의 결과를 합칠 때 A와 B 에 중복된 Record 와 B Record Set
 *       을 제외한 Record 들만 모아서 하나의 Record Set 으로 합친다.
 *     - 차집합
 */
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 10
UNION
SELECT *
  FROM EMPLOYEES
 WHERE MANAGER_ID = 101;

SELECT DEPARTMENT_ID
     , MANAGER_ID
  FROM DEPARTMENTS
MINUS
SELECT DISTINCT DEPARTMENT_ID
     , MANAGER_ID
  FROM EMPLOYEES;


/*
 * GROUPING SETS
 *     - GROUP BY 로 집계한 여러 Record Set 결과를 하나의 Record Set 으로
 *       합칠 때 사용
 */
SELECT DEPARTMENT_ID
     , JOB_ID
     , COUNT(*) AS 인원수
     , ROUND(AVG(SALARY), 2) AS 평균급여
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NOT NULL
 GROUP BY GROUPING SETS(DEPARTMENT_ID, JOB_ID, (DEPARTMENT_ID, JOB_ID))
 ORDER BY 1, 2;
 