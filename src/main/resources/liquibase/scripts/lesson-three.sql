-- liquibase formatted sql

-- changeset korobeynikova:1

CREATE INDEX faculty_name_index ON faculty(name);

-- changeset korobeynikova:2

CREATE INDEX faculty_color_index ON faculty(color);

-- changeset korobeynikova:3

CREATE INDEX student_name_index ON student(name);