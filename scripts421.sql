ALTER TABLE student
    ADD CONSTRAINT age_student_constrains CHECK ( age > 16 );

ALTER TABLE student
    ALTER COLUMN age SET DEFAULT 20;

ALTER TABLE student
    ALTER COLUMN name SET NOT NULL;

ALTER TABLE student
    ADD CONSTRAINT name_student_unique UNIQUE (name);

ALTER TABLE faculty
    ADD CONSTRAINT faculty_name_color_unique UNIQUE (name,color);

UPDATE student
SET age=20
WHERE AGE=0;
