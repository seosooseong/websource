--오라클에서 생성
create table productTBL(
		num number,
		category varchar2(20),
		name varchar2(50),
		content varchar2(3000),
		psize varchar2(10),
		color varchar2(20),
		amount number,
		price number,
		redate date
);
--데이트 사용못함



alter table productTBL add constraint pk_productTBL primary key(num);
create sequence prod_seq;

select * from productTBL;


ALTER TABLE productTBL MODIFY (redate DEFAULT SYSDATE);