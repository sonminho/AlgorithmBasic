drop table goodsinfo;
create table goodsinfo(
code char(5) not null,
 name varchar2(30) not null,
 price number not null,
 maker varchar2(20),
 primary key(code));
 
 insert into goodsinfo(code, name, price, maker)
 values ('10001', '������tv', 350000, 'LG');
 
 insert into goodsinfo(code, name, price, maker)
 values ('10002', 'DVD �÷��̾�', 150000, 'LG');
 
 insert into goodsinfo(code, name, price, maker)
 values ('10003', '������ ī�޶�', 250000, '�Ｚ');
 
 insert into goodsinfo(code, name, price, maker)
 values ('10004', '���ڻ���', 50000, '���̸���');
 
 insert into goodsinfo(code, name, price, maker)
 values ('10005', '������ ������', 1350000, '�Ｚ');
 
 select * from goodsinfo;
 
 commit