-- bookTBL 생성
-- code 숫자 4자리 pk
-- title 문자 50
-- writer 문자 20
-- price 숫자 8자리
create table bookTBL(
	code number(4) PRIMARY KEY,
	title nvarchar2(50) not null,
	writer nvarchar2(20) not null,
	price number(8) not null
);

select * from booktbl;

insert into bookTBL Values(1001, '이것이 자바다', '신용균', 28000);
insert into bookTBL Values(1002, '자바의 신', '강신용', 29000);
insert into bookTBL Values(1003, '자바 1000제', '김용만', 27000);
insert into bookTBL Values(1004, '오라클로 배우는 DataBase 입문', '김진수', 32000);

