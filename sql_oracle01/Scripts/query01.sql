-- 한 줄 주석

/*
 * 블럭 주석
 */

-- 연결 후 조회 테스트
SELECT 'Hello' FROM DUAL;

/*
 * 관리자 계정 sys, system 을 제외한 일반 계정(개발자가 사용할 계정)을
 * 만들고 확인하기
 *     1. 관리자 계정으로 Oracle 에 접속
 *     2. 새로운 계정 생성
 *     3. 생성한 계정에 권한 부여
 *     4. 계정 확인
 *     5. 새로 만든 계정으로 접속 시도
 */
-- CREATE USER 계정명 IDENTIFIED BY 계정암호;
CREATE USER dev01 IDENTIFIED BY dev01;

-- GRANT 역할1, 역할2, ... TO 계정명;
-- GRANT RESOURCE, DBA TO dev01;
GRANT RESOURCE, CONNECT, INSERT ANY TABLE, UPDATE ANY TABLE
    , DELETE ANY TABLE, CREATE VIEW, CREATE SESSION TO dev01;

-- 사용자 테이블 스페이스(임시 저장 공간) 지정
ALTER USER dev01 quota 10M ON USERS;

-- 계정 생성 확인을 위한 조회(소문자로 생성해도 대문자로 찾아야 함)
SELECT USERNAME FROM ALL_USERS WHERE USERNAME = 'DEV01';

-- 패스워드 변경
ALTER USER dev01 IDENTIFIED BY dev01;

-- 계정 삭제
DROP USER dev01;


