drop table member cascade constraint;

--아이디 - 25글자, 암호 - 50글자, 이름 - 10글자, 나이 - 숫자
create table member(
	id varchar2(25 byte) primary key,
	pass varchar2(50 byte) not null,
	name varchar2(30 byte),
	age number
);

alter table member add grade number default 1;

select * from nls_database_parameters where parameter like '%CHARACTERSET%';

select * from member;
delete from member;
insert into member values('A0001', '123456', '홍길동',33,1);

--회원 등급 나타내는 테이블 GRADE_LIST
-- BRONZE - 1, SILVER - 2, GOLD - 3, VIP - 4, VVIP - 5 MASTER -> 0  
create table grade_list(
	grade_no number primary key,
	grade_name varchar2(10 byte)
);
insert into GRADE_LIST values(1, 'BRONZE');
insert into GRADE_LIST values(2, 'SILVER');
insert into GRADE_LIST values(3, 'GOLD');
insert into GRADE_LIST values(4, 'VIP');
insert into GRADE_LIST values(5, 'VVIP');
insert into GRADE_LIST values(0, 'MASTER');

select * from grade_list;

select id, name, pass, age, grade_name from MEMBER, grade_list where grade_no = grade;



--------------------------------------------------------
--  파일이 생성됨 - 금요일-1월-08-2021   
--------------------------------------------------------

--------------------------------------------------------
--  파일이 생성됨 - 금요일-1월-08-2021   
--------------------------------------------------------
REM INSERTING into BOARD
SET DEFINE OFF;
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (2,'TEST',to_date('21/01/05','RR/MM/DD'),0,'admin','내용이다',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (0,'zzzzzzzzzzzzzzzzzzz',to_date('21/01/06','RR/MM/DD'),16,'admin','zzzzzzzzzzzzzzzzzzz',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (22,'바보',to_date('21/01/06','RR/MM/DD'),1,'admin','멍청이',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (23,'바보',to_date('21/01/06','RR/MM/DD'),2,'admin','멍청이',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (24,'바보',to_date('21/01/06','RR/MM/DD'),1,'admin','ㅁ',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (25,'fghfgh',to_date('21/01/06','RR/MM/DD'),33,'admin','gfgggg',20,151);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (26,null,to_date('21/01/06','RR/MM/DD'),0,null,null,0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (27,null,to_date('21/01/06','RR/MM/DD'),0,null,null,0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (38,'asd',to_date('21/01/06','RR/MM/DD'),1,'admin','619645
',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (39,'asdasd',to_date('21/01/06','RR/MM/DD'),0,'admin','1456632',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (40,'abc',to_date('21/01/06','RR/MM/DD'),1,'admin','.',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (41,'룰루룰루루',to_date('21/01/06','RR/MM/DD'),2,'admin','야호',2,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (42,'왜안됭',to_date('21/01/06','RR/MM/DD'),3,'admin','?',17,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (90,'cbvcvb',to_date('21/01/07','RR/MM/DD'),0,'admin','we235wte',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (91,'13',to_date('21/01/07','RR/MM/DD'),0,'123456','14',0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (92,null,to_date('21/01/08','RR/MM/DD'),0,null,null,0,0);
Insert into BOARD (BNO,TITLE,BDATE,BCOUNT,WRITER,CONTENT,BLIKE,BHATE) values (93,'gsdfg',to_date('21/01/08','RR/MM/DD'),0,'admin','sdfgsdfg',0,0);
REM INSERTING into MEMBER
SET DEFINE OFF;
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('admin','1234','홍길동',12,0);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('A0001','1234','김길동',25,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Z1773','123456','강병헌',49,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Z6298','123456','김동수',55,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Q3297','123456','김시우',62,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('T4369','123456','김준래',47,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('Q8675','123456','박셩우',34,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('A6252','123456','박병상',55,5);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('M2454','123456','박정현',27,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('C3101','123456','서민우',56,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('123456','123456','박성용',123456,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('P3478','123456','이원구',43,4);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('W4354','123456','정성수',50,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('L4082','123456','정희우',46,4);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('B7249','123456','조성수',26,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('S3150','123456','주지우',31,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('T6388','123456','최승수',51,2);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('S6278','123456','한상오',31,2);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('W4392','123456','이지원',39,4);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('S2298','123456','김희연',65,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('F1193','123456','노소정',33,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('E6882','123456','손지해',28,3);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('I5201','123456','정다혜',41,2);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('I9870','123456','장세이',23,5);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('L3517','123456','차영연',51,2);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('O1546','123456','장희은',35,5);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('T6396','123456','남혜미',52,2);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('K6985','123456','유민주',49,1);
Insert into MEMBER (ID,PASS,NAME,AGE,GRADE) values ('N1462','123456','원소은',51,3);

commit;





