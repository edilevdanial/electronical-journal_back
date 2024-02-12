CREATE TABLE IF NOT EXISTS person
(
    id              BIGSERIAL    NOT NULL PRIMARY KEY,
    first_name      VARCHAR(200) NOT NULL,
    last_name       VARCHAR(200) NOT NULL,
    patronymic_name VARCHAR(200),
    phone_number    VARCHAR(40)  NOT NULL,
    email           VARCHAR(254) NOT NULL,
    password        TEXT         NOT NULL,
    type            VARCHAR(20)  NOT NULL,
    token           TEXT         NOT NULL,
    is_active       BOOLEAN      NOT NULL
);

CREATE TABLE IF NOT EXISTS course
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS group_
(
    id         BIGSERIAL    NOT NULL PRIMARY KEY,
    name       VARCHAR(200) NOT NULL,
    teacher_id BIGSERIAL    NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES person (id)
);

CREATE TABLE IF NOT EXISTS lesson
(
    id          BIGSERIAL    NOT NULL PRIMARY KEY,
    course_id   BIGSERIAL    NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id),
    group_id    BIGSERIAL    NOT NULL,
    FOREIGN KEY (group_id) REFERENCES group_ (id),
    name        VARCHAR(200) NOT NULL,
    link        TEXT         NOT NULL,
    description TEXT         NOT NULL
);


CREATE TABLE IF NOT EXISTS homework
(
    id          BIGSERIAL PRIMARY KEY NOT NULL,
    lesson_id   BIGSERIAL             NOT NULL,
    FOREIGN KEY (lesson_id) REFERENCES lesson (id),
    teacher_id  BIGSERIAL             NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES person (id),
    course_id   BIGSERIAL             NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id),
    group_id    BIGSERIAL             NOT NULL,
    FOREIGN KEY (group_id) REFERENCES group_ (id),
    name        VARCHAR(200)          NOT NULL,
    type        VARCHAR(5)            NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS homework_test
(
    homework_id BIGSERIAL    NOT NULL,
    FOREIGN KEY (homework_id) REFERENCES homework (id),
    name        VARCHAR(200) NOT NULL,
    problems    TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS seminar
(
    id         BIGSERIAL   NOT NULL PRIMARY KEY,
    group_id   BIGSERIAL   NOT NULL,
    FOREIGN KEY (group_id) REFERENCES group_ (id),
    course_id  BIGSERIAL   NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id),
    teacher_id BIGSERIAL   NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES person (id),
    week_day   VARCHAR(50) NOT NULL,
    start_time VARCHAR(50),
    end_time   VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS course_teacher_relation
(
    course_id  BIGSERIAL NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id),
    teacher_id BIGSERIAL NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES person (id)
);

CREATE TABLE IF NOT EXISTS vacancy
(
    id              BIGSERIAL    NOT NULL PRIMARY KEY,
    company_name    VARCHAR(200) NOT NULL,
    position        VARCHAR(200) NOT NULL,
    salary          BIGSERIAL    NOT NULL,
    experience_age  BIGSERIAL    NOT NULL,
    graphic_work    VARCHAR(200) NOT NULL,
    type_busy       VARCHAR(200) NOT NULL,
    company_address VARCHAR(200) NOT NULL,
    link            TEXT,
    description     TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS grades
(
    id    BIGINT NOT NULL PRIMARY KEY,
    grade BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS submission
(
    id          BIGSERIAL NOT NULL PRIMARY KEY,
    student_id  BIGSERIAL NOT NULL,
    FOREIGN KEY (student_id) REFERENCES person (id),
    homework_id BIGSERIAL NOT NULL,
    FOREIGN KEY (homework_id) REFERENCES homework (id),
    grade_id    BIGSERIAL,
    FOREIGN KEY (grade_id) REFERENCES grades (id)
);

CREATE TABLE IF NOT EXISTS news
(
    id          BIGSERIAL    NOT NULL PRIMARY KEY,
    preview     VARCHAR(200) NOT NULL,
    name        VARCHAR(200) NOT NULL,
    description TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS homework_material
(
    homework_id BIGSERIAL NOT NULL,
    FOREIGN KEY (homework_id) REFERENCES homework (id),
    link        TEXT      NOT NULL
);

CREATE TABLE IF NOT EXISTS submission_material
(
    submission_id BIGSERIAL NOT NULL,
    FOREIGN KEY (submission_id) REFERENCES submission (id),
    link          TEXT      NOT NULL
);

CREATE TABLE IF NOT EXISTS submission_test
(
    submission_id BIGSERIAL NOT NULL,
    FOREIGN KEY (submission_id) REFERENCES submission (id),
    solution      TEXT      NOT NULL
);

CREATE TABLE IF NOT EXISTS student_group_relation
(
    student_id BIGSERIAL NOT NULL,
    FOREIGN KEY (student_id) REFERENCES person (id),
    group_id   BIGSERIAL NOT NULL,
    FOREIGN KEY (group_id) REFERENCES group_ (id)
);

CREATE TABLE IF NOT EXISTS curator_group_relation
(
    id         BIGSERIAL NOT NULL PRIMARY KEY,
    teacher_id BIGSERIAL NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES person (id),
    group_id   BIGSERIAL NOT NULL,
    FOREIGN KEY (group_id) REFERENCES group_ (id)
);

CREATE TABLE IF NOT EXISTS group_course_teacher_relation
(
    group_id   BIGSERIAL NOT NULL,
    FOREIGN KEY (group_id) REFERENCES group_ (id),
    teacher_id BIGSERIAL NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES person (id),
    course_id  BIGSERIAL NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE IF NOT EXISTS roles
(
    id   BIGINT      not null PRIMARY KEY,
    name varchar(50) NOT NULL
);
-- DROP TABLE group_list
-- CREATE SEQUENCE clients_id_seq START WITH 3 INCREMENT 1;
