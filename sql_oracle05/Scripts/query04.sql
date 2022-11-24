/*
 * SYNONYM (동의어)
 * - 다른 사용자의 객체를 참조할 때 사용자명.객체명 형식으로 사용하는 것을
 * 	 좀 더 간단한 이름으로 사용할 수 있도록 다른 이름을 만드는 것
 * 
 * 비공개 동의어
 * 	- 객체에 대한 접근 권한을 부여받은 사용자가 정의한 동의어로 
 * 	  해당 사용자만 사용 가능
 * 
 * 공개 동의어
 *  - DBA가 정한 동의어로 모든 사용자가 사용 가능(DUAL이 공개 동의어로 만들어진 것)
*/


/* 관리자 계정으로 테스트 계정 생성 */
CREATE USER user1 IDENTIFIED BY user1;
CREATE USER user2 IDENTIFIED BY user2;

GRANT CONNECT, RESOURCE
    , INSERT ANY TABLE, UPDATE ANY TABLE
    , DELETE ANY TABLE, CREATE SYNONYM TO user1;
GRANT CONNECT, RESOURCE
    , INSERT ANY TABLE, UPDATE ANY TABLE
    , DELETE ANY TABLE TO user2;
   
ALTER USER user1 quota 10M ON USERS;
ALTER USER user2 quota 10M ON USERS;

/* USER1 에서 샘플용 테이블 생성 */
CREATE TABLE SAMPLE(
       ID NUMBER PRIMARY KEY
     , NAME VARCHAR2(50)
);
INSERT INTO SAMPLE VALUES(1, 'sample');
INSERT INTO SAMPLE VALUES(2, 'table');
INSERT INTO SAMPLE VALUES(3, 'data');

/* SAMPLE 테이블의 비공개 동의어 생성(CREATE SYNONYM 권한 필요함) */
CREATE SYNONYM SAM FOR SAMPLE;

/* 동의어로 테이블 조회 */
SELECT * FROM SAM;

/* USER2 에서 USER1 의 테이블 조회 */
SELECT * FROM USER1.SAMPLE; /* 권한이 없어서 안됨. */
SELECT * FROM USER1.SAM; /* 권한이 없어서 안됨. */

/*
 * USER1 계정에서 다른 계정이 테이블을 조회 할 수 있도록 권한을 부여
 * 실제 테이블명으로 권한을 부여하거나 동의어를 사용하여 권한을 부여하면 됨.
 * (두 가지 중 하나만 적용해도 됨.)
 */
GRANT SELECT ON SAMPLE TO USER2;
GRANT SELECT ON SAM TO USER2;

/* 권한 제거가 필요한 경우 아래의 명령어 사용 */
REVOKE SELECT ON SAMPLE FROM USER2;

/* USER2 에서 다시 USER1 의 테이블 조회 */
SELECT * FROM USER1.SAMPLE; /* 조회 됨 */
SELECT * FROM USER1.SAM; /* 조회 됨 */





/* 공개 동의어 테스트를 위한 샘플 테이블 생성(USER1 에서 생성할 것) */
CREATE TABLE PUBLIC_SAMPLE(
       ID NUMBER PRIMARY KEY
     , NAME VARCHAR2(50)
);
INSERT INTO PUBLIC_SAMPLE VALUES(1, 'sample');
INSERT INTO PUBLIC_SAMPLE VALUES(2, 'table');
INSERT INTO PUBLIC_SAMPLE VALUES(3, 'public');

/* 공개 동의어는 관리자 계정에서 작업해야 함 */
CREATE PUBLIC SYNONYM PSAM FOR USER1.PUBLIC_SAMPLE;

/* USER2 에서 공개 동의어로 USER1 의 PUBLIC_SAMPLE 테이블에 접근 */
SELECT * FROM PSAM; /* SELECT 권한이 없어서 안됨. */

/* USER1 에서 USER2 에게 SELECT 권한을 부여 */
GRANT SELECT ON PUBLIC_SAMPLE TO USER2;

/* 권한이 부여 된 후에는 공개 동의어로 접근 가능 */
SELECT * FROM PSAM; /* 더 이상 USER1 과 같은 사용자계정 스키마가 필요하지 않음. */


/* 동의어 생성 정보 조회 */
SELECT * FROM ALL_SYNONYMS WHERE TABLE_OWNER = 'USER1';

SELECT * FROM USER_TABLES;