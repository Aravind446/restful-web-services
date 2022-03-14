insert into course(id, name, created_date, last_updated_date)values(10001, 'JPA in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10002, 'JPA in 100 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10003, 'JPA in 200 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10004, 'Dummy1', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10005, 'Dummy2', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10006, 'Dummy3', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10007, 'Dummy4', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)values(10008, 'Dummy5', sysdate(), sysdate());





insert into student(id, name,passport_id) values (20001,'Shiva', 40001);
insert into student(id, name,passport_id) values (20002,'Aravind',40002);
insert into student(id, name,passport_id) values (20003,'Varun',40003);

insert into passport(id,number)  values (40001, 'E123456');
insert into passport(id, number) values (40002, 'N123456');
insert into passport(id, number) values ( 40003,'H123456');

insert into review(id,rating,description, course_id) values (40001,'Great',10001);
insert into review(id,rating,description, course_id) values (40002,'Wonderful',10001);
insert into review (id,rating,description, course_id) values (40003, 'Awsome',10003);

insert into student_course(student_id,course_id) values (20001,10001);
insert into student_course(student_id,course_id) values (20002,10001);
insert into student_course(student_id,course_id) values (20003,10001);
insert into student_course(student_id,course_id) values (20001,10003);