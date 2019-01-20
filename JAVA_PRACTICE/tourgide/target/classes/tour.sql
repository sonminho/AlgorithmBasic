drop table tourguide;
create table tourguide(
	tour_no number(3) not null primary key,
	tour_name varchar2(60),
	city varchar2(30),
	area varchar2(40),
	content varchar2(3000),
	location varchar2(350),
	home_page varchar2(200),
	reg_date date default sysdate,
	update_date date default sysdate
);

DROP SEQUENCE TOUR_NO_SEQ;
CREATE SEQUENCE TOUR_NO_SEQ
INCREMENT BY 1
START WITH 1;

select * from tourguide order by tour_no;

select * from tourguide where tour_no = 1;

select count(*) from tourguide

select * from tourguide where tour_name like '%멀티%'

select distinct city from TOURGUIDE;

select tour_no, tour_name, city, area, content, location, home_page  
from (select row_number() over (order by tour_no) 
as seq, tour_no, tour_name, city, area, content, location, home_page)
from tourguide;