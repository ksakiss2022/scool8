select *
from faculty;

select *
from student;

select *
from student
where age<19 and age>15;

select student.name
from student;

select *
from student
where name LIKE '%о%';

select *
from student
where id<12;

select*
from student
order by  age;