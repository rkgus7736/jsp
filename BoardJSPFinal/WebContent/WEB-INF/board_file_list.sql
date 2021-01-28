create table "board_file_list"(
bno number,
writer varchar2 (25 byte),
filename varchar2 (100 byte)
);
alter table board_file_list add constraint fk_file_bno foreign key(bno) 
references board(bno) on delete cascade;