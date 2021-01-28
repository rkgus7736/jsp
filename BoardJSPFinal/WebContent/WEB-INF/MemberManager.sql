create table qna(
	qno number primary key,
	title varchar2 (100 byte),
	content varchar2 (4000 byte),
	wdate date default sysdate,
	writer varchar2 (25 byte),
	status number default 0, -- 안읽음 : 0, 읽음 : 1, 답변완료 : 2
	response varchar2 (4000 byte)
);

create sequence qno_seq start with 1;