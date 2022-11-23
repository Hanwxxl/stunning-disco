/*
 * 가계부 작성을 위한 테이블을 생성하고 데이터를 추가 하세요.
 *
 * 가계부 테이블에는 ID, 입금/출금구분, 금액, 날짜, 지출구분, 비고 정보가 저장될 수 있도록 합니다.
 *   - ID 는 레코드를 식별하기 위한 식별 값으로 사용합니다.
 *   - 입금/출금구분은 입금의 경우 'I', 출금의 경우 'O' 로 사용합니다.
 *   - 지출구분은 식비, 교통비, 통신비, 물품구입비 등 정해진 항목안에서 사용할 수 있게 합니다.
 *     정해진 항목안에서 사용할 수 있도록 지출구분 테이블을 별도로 만들어 참조할 수 있게 합니다.
 *   - 비고에는 지출구분으로 작성할 수 없는 좀 더 상세한 내용을 작성하기 위해 사용합니다.
 */
CREATE TABLE 가계부(
       ID       NUMBER  CONSTRAINT 가계부_ID_PK       PRIMARY KEY
     , 입출구분 CHAR(1) CONSTRAINT 가계부_입출구분_CK CHECK(입출구분 IN ('I', 'O'))
     , 금액     NUMBER  DEFAULT(0)
     , 날짜     DATE    DEFAULT(SYSDATE)
     , 지출구분 CHAR(5) CONSTRAINT 가계부_지출구분_FK REFERENCES 지출구분(CODE)
     , 비고     VARCHAR2(100 CHAR)
);

/*
 * 지출구분 테이블에는 CODE, 항목 정보가 저장될 수 있도록 합니다.
 *   - CODE 는 지출항목에 대응할 수 있는 5자리 영문자값으로 사용합니다.
 *   - 항목에는 식비, 교통비, 통신비 등 정해진 값을 작성합니다.
 */
CREATE TABLE 지출구분(
       CODE CHAR(5)           CONSTRAINT 지출구분_CODE_PK PRIMARY KEY
     , 항목 VARCHAR2(50 CHAR) CONSTRAINT 지출구분_항목_NN NOT NULL
);
INSERT INTO 지출구분 VALUES('0000A', '급여');
INSERT INTO 지출구분 VALUES('0000B', '교통비');
INSERT INTO 지출구분 VALUES('0000C', '통신비');
INSERT INTO 지출구분 VALUES('0000D', '식비');
INSERT INTO 지출구분 VALUES('0000E', '물품구입비');

/*
 * 최근 1년간의(월마다 최소 5개 데이터를 뽑아서.) 지출내역을 참고하여 데이터를 추가해 봄니다.
 */
INSERT INTO 가계부 VALUES(1, 'O', 12000, TO_DATE('20220101'), '0000D', NULL);
INSERT INTO 가계부 VALUES(2, 'I', 2500000, TO_DATE('20220115'), '0000A', NULL);
INSERT INTO 가계부 VALUES(3, 'O', 75000, TO_DATE('20220120'), '0000B', NULL);
INSERT INTO 가계부 VALUES(4, 'O', 55000, TO_DATE('20220120'), '0000C', NULL);
INSERT INTO 가계부 VALUES(5, 'O', 5500, TO_DATE('20220121'), '0000E', '종이컵(소) 30개');

SELECT * FROM 가계부;