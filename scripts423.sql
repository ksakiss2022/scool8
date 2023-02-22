
SELECT student.name, student.age, faculty.name
FROM faculty
         RIGHT JOIN student ON student.faculty_id = faculty.id;


SELECT avatar.data, student.id, student.name, student.age
FROM avatar
         INNER JOIN student ON avatar.student_id = student.id;