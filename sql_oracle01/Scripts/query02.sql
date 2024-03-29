/*
 * DQL : SELECT 구문
 *       데이터 베이스의 테이블에 저장된 데이터를 조회하기 위해 사용
 *       조회 결과로 Record Set 을 반환받게 된다.
 *       Record Set 에는 Record 가 0개 이상 포함되어 있다.
 */
SELECT * FROM EMPLOYEES;

/*
 * - SELECT 구문에는 FROM 절, WHERE 절, ORDER BY 절 등이 추가로 사용 된다.
 * - FROM 절에는 조회할 테이블명을 작성하게 된다.
 * - WHERE 절에는 FROM 에 명시한 테이블에서 데이터를 조회하기 위한 조건을 작성하게 된다.
 * - ORDER BY 절에는 조회 결과에 대한 정렬 기준을 작성하게 된다.
 * - SELECT 절에는 FROM 절에 명시한 테이블의 컬럼을 작성하게 된다. 이 때 작성된 컬럼의
 *   데이터들만 Record Set 으로 반환이 된다.
 */
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES;

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE LAST_NAME = 'Grant';

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME
  FROM EMPLOYEES
 WHERE LAST_NAME = 'Grant'
 ORDER BY EMPLOYEE_ID DESC;
 

/*
 * SELECT 절에 사용하는 컬럼명이 Recored Set 으로 반환 될 때 그대로 출력되지만
 * 이를 변경하고 싶으면 별칭을 부여하여 Record Set 으로 출력하는 컬럼명을 변경
 * 할 수 있다.
 */
SELECT EMPLOYEE_ID 사번
     , FIRST_NAME 이름
     , LAST_NAME 성
  FROM EMPLOYEES;
  
SELECT EMPLOYEE_ID AS 사번
     , FIRST_NAME AS 이름
     , LAST_NAME AS 성
  FROM EMPLOYEES;

SELECT EMPLOYEE_ID AS "사원 번호"
     , FIRST_NAME AS 이름
     , LAST_NAME AS 성
  FROM EMPLOYEES;
 
/*
 * SELECT 절에 컬럼명과 리터럴 값을 혼합하여 Record Set 으로 반환되는
 * 결과값을 변경 할 수 있다. 
 */
SELECT 'No. ' || EMPLOYEE_ID AS "사원 번호"
     , FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES;

/*
 * SELECT 절에 컬럼과 컬럼을 결합하여 하나의 컬럼으로 만들어 Record Set을
 * 반환할 수 있다.
 */
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
  FROM EMPLOYEES;
 
/*
 * 숫자 데이터가 저장된 컬럼에는 사칙연산을 수행한 결과의 Record Set 을
 * 반환할 수 있다.
 */
SELECT FIRST_NAME
     , LAST_NAME
     , (SALARY + 1000) / 12
  FROM EMPLOYEES;

/*
 * Record Set 의 결과가 중복된 결과로 나오는 경우 중복을 제거할 수 있다.
 */
SELECT DISTINCT DEPARTMENT_ID
  FROM EMPLOYEES;


/*
 * WHERE 절
 */
SELECT * FROM EMPLOYEES;

/*
 * WHERE 절에 사용하는 조건식(연산자)
 *     1. 비교 연산자
 *     2. 논리 연산자
 *     3. 산술 연산자
 *     4. IS NULL, IS NOT NULL
 *     5. LIKE
 *     6. IN, NOT IN
 *     7. BETWEEN ... AND, NOT BWTWEEN ... AND
 *     8. 연결 연산자 -> ||
 */

/*
 * 비교 연산자
 *     같다 : =
 *     크다 : >
 *     작다 : <
 *     크거나 같다 : >=
 *     작거나 같다 : <=
 *     다르다 : !=, <>
 */
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY <> 4000;


/*
 * 논리 연산자 : 다른 조건식의 결과로 반환된 true, false 에 대한 연산을 수행
 *     AND : 모든 결과가 true 일 때 true 를 반환
 *     OR : 하나의 결과가 true 이면 true 를 반환
 *     NOT : 반환된 결과에 대한 부정
 */
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY < 4000 AND SALARY > 2000;

SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY < 2500 OR SALARY > 20000;

SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE NOT(SALARY > 20000);


/*
 * BETWEEN : 지정한 범위에 해당하는 데이터를 조회하기 위한 연산으로 사용
 *           지정한 값을 포함하는 범위
 */
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY BETWEEN 2000 AND 4000;

SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY NOT BETWEEN 2000 AND 4000;

SELECT FIRST_NAME
     , LAST_NAME
     , HIRE_DATE
  FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN '1999-01-01' AND '1999-12-31';
 

/*
 * IN : 연속되지 않은 범위에 대한 연산으로 사용
 */
SELECT FIRST_NAME
     , LAST_NAME
     , SALARY
  FROM EMPLOYEES
 WHERE SALARY IN (2000, 3000, 4000, 5000);
 
SELECT FIRST_NAME
     , LAST_NAME
  FROM EMPLOYEES
 WHERE LAST_NAME IN ('Bell', 'Gee', 'Olson');
 

/*
 * LIKE : 문자열에 대한 패턴 검색을 하기 위해 사용
 */
SELECT FIRST_NAME
     , LAST_NAME
     , EMAIL
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE 'L%';
  
SELECT FIRST_NAME
     , LAST_NAME
     , EMAIL
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE '%p';

SELECT FIRST_NAME
     , LAST_NAME
     , EMAIL
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE 'L__';
 
SELECT FIRST_NAME
     , LAST_NAME
     , JOB_ID
  FROM EMPLOYEES
 WHERE JOB_ID LIKE '%\____' ESCAPE '\';


/*
 * IS NULL, IS NOT NULL : NULL 데이터를 찾기 위한 연산자로 사용
 */
SELECT FIRST_NAME
     , LAST_NAME
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IS NULL;
 

SELECT FIRST_NAME
     , LAST_NAME
     , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = NULL;