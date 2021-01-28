--게시판 테이블(BOARD)
create table board(
    bno number primary key,
    title varchar2(150 byte),
    bdate date default sysdate,
    bcount number default 0,
    writer varchar2(25 byte),
    content varchar2(500 byte),
    blike number default 0,
    bhate number default 0,
    constraint fk_writer foreign key(writer) references member(id)
);
alter table board add constraint fk_writer foreign key(writer) references member(id);
--댓글
create table board_comment(
    cno number primary key,
    bno number,
    content varchar2(1500 byte),
    cdate date default sysdate,
    writer varchar2(25 byte),
    blike number default 0,
    bhate number default 0,
    constraint fk_comment_writer foreign key(writer) references member(id),
    constraint fk_comment_bno foreign key(bno) references board(bno)
);
--게시판 시퀸스
create sequence bno_seq start with 1 NOMAXVALUE;
--댓글 시퀸스
create sequence cno_seq start with 1 NOMAXVALUE;


--게시판 글목록
select * from board;
select sysdate from dual;
alter session set time_zone = 'Asia/Seoul';


select * from board_comment;

--게시글 목록
select b.*, nvl(c.comment_count,0) 
from board b, (select bno, count(*) as comment_count from board_comment group by bno) c
where b.bno = c.bno(+);
--게시글별 댓글 개수
select bno, count(*) from board_comment group by bno;

--board 테이블의 writer,title이 null인걸 삭제
delete from board where writer is null or title is null;

--페이징 : 많은 데이터들 중 순서대로 원하는 양만큼 원하는 일부분을 조회

--Step.1 정렬 : 정렬 기준(날짜 또는 글번호) desc-최신글부터 정렬
select b.*, nvl(c.comment_count,0) 
from board b, (select bno, count(*) as comment_count from board_comment group by bno) c
where b.bno = c.bno(+) order by b.bno desc; 

--Step.2 처음부터 게시글 7개만 조회
--서브쿼리 할 때 정렬 먼저하고 데이터를 추출해야함 
select rownum,bno,title,bdate,bcount,writer,content,blike,bhate 
from (select b.*, nvl(c.comment_count,0) as comment_count
from board b, (select bno, count(*) as comment_count from board_comment group by bno) c
where b.bno = c.bno(+) order by b.bno desc) where rownum <=7 ; 

--Step.3 1페이지 : 1~7번까지, 2페이지 : 8~14번까지, 3페이지 : 15~21번까지
--위 결과를 토대로 2페이지에 해당하는 글 목록을 조회

--에러 1 - 이런 경우에는 rownum이 1부터 시작인데 조회가 되야 증가, 
--지금처럼 조건이 거짓이면 조회가 안되기에 rownum이 증가를 안함
select rownum as rn,bno,title,bdate,bcount,writer,content,blike,bhate
from (select b.*, nvl(c.comment_count,0) as comment_count
from board b, (select bno, count(*) as comment_count from board_comment group by bno) c
where b.bno = c.bno(+) order by b.bno desc) where rownum >=8 and rownum <=14; 

--3-1번째 
-- rownum의 별칭을 정해주고 괄호로 닫아줘야함
--페이지번호 : n, 페이지당 보여줄 글목록 개수 : x
--시작 글 번호 : (n-1) * x + 1 -> (자바 코드와 연계할때 필요한 공식)
--마지막 글 번호 : n * x
select * from (select rownum as rn,bno,title,bdate,bcount,writer,content,blike,bhate
from (select b.*, nvl(c.comment_count,0) as comment_count
from board b, (select bno, count(*) as comment_count from board_comment group by bno) c
where b.bno = c.bno(+) order by b.bno desc)) where rn between 8 and 14; 

--3-2번째 (후에 좀 더 편함)
--페이지 번호를 구해서 where절을 간단하게 ceil:올림처리 - pagenum이 소수점으로 처리되서 사용  
select * from (select ceil(rownum / 7) as pagenum,
bno,title,bdate,bcount,writer,content,blike,bhate 
from (select b.*, nvl(c.comment_count,0) as comment_count
from board b, (select bno, count(*) as comment_count 
from board_comment group by bno) c
where b.bno = c.bno(+) order by b.bno desc)) where pagenum=2; 

--좋아요 클릭하면 좋아요를 많이 받은 순서대로 출력
select * from (select ceil(rownum / 10) as likenum,
bno,title,bdate,bcount,writer,content,blike,bhate 
from (select b.*, nvl(b.like_count,0) as b.like_count 
from board b, (select bno, count(*) as b.like_count 
from board_blike group by bno) b
where b.blike = c.blike(+) order by b.bno desc where likenum=10;

create table board_file_list(
bno number,
writer varchar2(25 byte),
filename varchar2(100 byte)
);