show databases ;


use Employee;

create table EmployeeInfo
(
    id int ,
    name varchar(24),
    city varchar(24)

);


insert into EmployeeInfo (id, name, city) values (3,"Pooja","Delhi");


select * from EmployeeInfo;