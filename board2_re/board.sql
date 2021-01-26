select*from board; 

create table board(
			bno NUMBER(8), --글번호
			name NVARCHAR2(10) not null, --작성자
			password VARCHAR2(15) not null, --비번
			title NVARCHAR2 (50) not null, --제목
			content NVARCHAR2(1000) not null, --내용
			attach NVARCHAR2(100), --파일첨부
			re_ref NUMBER(8) not null, --답글 작성시 참조 되는 번호
			re_lev NUMBER(8) not null, --답글 레벨
			re_seq NUMBER(8) not null, --답글 순서
			readcount NUMBER(8) default 0, --조회수
			regdate DATE DEFAULT sysdate); --작성 날짜
			
alter table board add CONSTRAINT pk_board primary key(bno);

CREATE SEQUENCE board_seq;


--댓글

--더미 데이터 (페이지 나누기)
insert into board(bno,name,password,title,content,re_ref,re_lev,re_seq)
(select board_seq.nextval,name,password,title,content,board_seq.currval,re_lev,re_seq from board);

select count(*) from board;

select*from board order by bno desc;

select*from board where bno=(select max(bno) from board);

--가장 최신글의 댓글 달기 
--re_ref (그룹번호 : 원본글의 re_ref번호 )
--re_lev (원본글의 댓글인지 or 댓글의 댓글인지 구분 - 원본글의 re_lev +1 )
--re_seq (댓글의 순서 - - 원본글의 re_seq +1)
--건들여서 댓글로 처리.

insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)
values(board_seq.nextval,'hong','1111','댓글연습','댓글연습중',null,2058,1,1);



--댓글 작업하는 방법
--1. 기존 댓글의 re_seq 값 변경하기       원본글 기준   원본글은 0이니깐 0보다 큰거 
update board set re_seq = re_seq+1 where re_ref=2058 and re_seq > 0;

--2. 댓글 삽입
--두번째 댓글
insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)
values(board_seq.nextval,'kim','1111','댓글연습2','댓글연습중2',null,2058,1,1);

--3. 댓글 가져오기
--원본글과 댓글 가져오기
select bno,name,title,re_ref,re_lev,re_seq from board where re_ref=2058 order by re_seq;



-- 댓글의 댓글(답글) 달기 (원본글의 re_ref,re_seq,re_lev)
--1. 기존 댓글의 re_seq 값 변경하기(+1)   
--													     	    원본글 re_seq보다 큰거 
update board set re_seq = re_seq+1 where re_ref=2058 and re_seq > 1;

--2. 댓글 삽입
insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq)
values(board_seq.nextval,'seo','1111','Re:댓글연습','댓글연습중2',null,2058,2,2);

--3. 댓글 가져오기
select bno,name,title,re_ref,re_lev,re_seq from board where re_ref=2058 order by re_seq;




