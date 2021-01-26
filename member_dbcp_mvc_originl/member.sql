select * from member1;


--member 이미 있어서 member1로 생성
create table member1(
		userid varchar2(15) primary key,
		password varchar2(20) not null,
		name nvarchar2(10) not null,
		gender varchar2(2) not null,
		email varchar2(50) not null
);
		


insert into member1 values ('hong123', 'hong123', '홍길동', '남', 'hong123@naver.com');
insert into member1 values ('tjtntjd', 's880205', '서수성', '남', 'tjtntjd@naver.com');