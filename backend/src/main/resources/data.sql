INSERT INTO roles (id, role_name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_TEACHER'),
       (3, 'ROLE_TUTOR'),
       (4, 'ROLE_RECEPTION'),
       (5, 'ROLE_STUDENT'),
       (6, 'ROLE_ENTRANT');
INSERT INTO users (firstname, lastname, patronymic, email, user_password, birthday, phone, telegram, role_id)
VALUES
    ('John', 'Doe', 'Smith', 'johndoe@example.com', '$2a$10$QUoIBFYtMK92NFKkwjdSFexA7l9DNOHwxFM5RHFsx2DE8uCvAUC8W', '1990-01-01', '1234567890', '@johndoe', 1),
    ('Jane', 'Smith', 'Doe', 'janesmith@example.com', '$2a$10$a/vDCAy2121lCK1xfDXfWuSV4.4sH7DDj7AMIu1nPj4OwkgUBhdgm', '1992-02-02', '0987654321', '@janesmith', 2),
    ('Michael', 'Johnson', 'Brown', 'michaeljohnson@example.com', '$2a$10$wyGIHpBcunI7CvMGIeiKMOwOg8ZM6QTvaFPzUvZcIm39VrLECvhYu', '1985-03-03', '9876543210', '@michaeljohnson', 2),
    ('Emily', 'Williams', 'Davis', 'emilywilliams@example.com', '$2a$10$TU3i7bfUQ6tEXSpcgwQojuuvwGMZVN2lFNhsM0Oj9QLZbw9XinOz2', '1988-04-04', '0123456789', '@emilywilliams', 3),
    ('David', 'Miller', 'Anderson', 'davidmiller@example.com', '$2a$10$ndEDQo.P4mhy48TLpvKZ.uCm4scAR/vJJlGBMbGtZQ/vVQNJFi9wW', '1995-05-05', '5678901234', '@davidmiller', 3),
    ('Sarah', 'Jones', 'Taylor', 'sarahjones@example.com', '$2a$10$Y7BHYu9mJOmMaaDNrOdrqejzHOxmBtelnZIB6KdK.zgILjufNqRPO', '1993-06-06', '4321098765', '@sarahjones', 3),
    ('Matthew', 'Brown', 'Wilson', 'matthewbrown@example.com', '$2a$10$KD0jKcydaLV.00KDngClGeKJPGGwvIEyxag7QxkQZuaIC3SzWohUe', '1987-07-07', '8901234567', '@matthewbrown', 4),
    ('Olivia', 'Davis', 'Johnson', 'oliviadavis@example.com', '$2a$10$ZGyBdJjCpBdQOXujOHt.1ePGtRvs0inBgnM7.uxB4R5RD75ZfrukW', '1991-08-08', '3456789012', '@oliviadavis', 4),
    ('Daniel', 'Taylor', 'Miller', 'danieltaylor@example.com', '$2a$10$LbpH1FIjFFJ9.pPNHI1YxOPXUW8os1ZOZXPip79ftAmFcQcwdpvyC', '1989-09-09', '6789012345', '@danieltaylor', 5),
    ('Sophia', 'Anderson', 'Jones', 'sophiaanderson@example.com', '$2a$10$1HN.vx.Wc8QCfXKBsdwDzenEjl023tLBPlipF1o9/FVfGDvEabKGy', '1994-10-10', '9012345678', '@sophiaanderson', 5),
    ('Alex', 'Wilson', 'Johnson', 'alexwilson@example.com', '$2a$10$KY/fjL5uJFFoOeMIoPIS/uq7WBDQZlujiLpowX6KbCRGzRryDphVO', '1996-11-11', '1234567890', '@alexwilson', 5),
    ('Emma', 'Taylor', 'Brown', 'emmataylor@example.com', '$2a$10$RSAAFuXG2.cybOTzcvLPrOHPqjkoZeoypMCTNTJapBnVdMGyqFb2.', '1997-12-12', '0987654321', '@emmataylor', 5),
    ('Christopher', 'Davis', 'Miller', 'christopherdavis@example.com', '$2a$10$xfxFFeWIYrzOvaWwDztwteVs/SenMOunkAr/AM3T5u1dY5V2xV24K', '1988-01-13', '9876543210', '@christopherdavis', 5),
    ('Ava', 'Anderson', 'Smith', 'avaanderson@example.com', '$2a$10$ww03gD5j94K9LbitMK3H3uOqshNuYRmUqC53vnX.9m6MOSiQDFENS', '1993-02-14', '0123456789', '@avaanderson', 5),
    ('Andrew', 'Miller', 'Jones', 'andrewmiller@example.com', '$2a$10$oCbSTsZJSJYqwgfrjMAuuuuOCHsKwRlBo/Y4Oh0DZ03tzP0j899my', '1991-03-15', '5678901234', '@andrewmiller', 5),
    ('Mia', 'Jones', 'Davis', 'miajones@example.com', '$2a$10$W.DGqit3IsK49g4Lc5Ry9OYJxvC8m2bDKhn1Qt1bMIvXeg2./I1qO', '1995-04-16', '4321098765', '@miajones', 5),
    ('William', 'Smith', 'Taylor', 'williamsmith@example.com', '$2a$10$mOh1C0x2LiKsIIRc7T9.R.n9s./mVsAAn7FM3yEKySYJB6aBCKVnS', '1987-05-17', '8901234567', '@williamsmith', 6),
    ('Sofia', 'Johnson', 'Wilson', 'sofiajohnson@example.com', '$2a$10$4TzIzCcFj0loj3Lh.9X4Gefsruvuzw1HXLrhW46PFuRNuvRP/mtWu', '1992-06-18', '3456789012', '@sofiajohnson', 6),
    ('James', 'Brown', 'Anderson', 'jamesbrown@example.com', '$2a$10$qFhNEHYasRdCwnbt8LaCzuohPMtFrMK9.UhmOeSgKN/8.lej8IOua', '1990-07-19', '6789012345', '@jamesbrown', 6),
    ('Charlotte', 'Davis', 'Miller', 'charlottedavis@example.com', '$2a$10$tIr.vduvafedN.tB8U1sc.4kYualYZ87uB0LXIbTHBNscKsSvQAFa', '1994-08-20', '9012345678', '@charlottedavis', 6);

INSERT INTO Application (user_id, head_name, division, position, seniority, achievements, letter)
VALUES (1, 'Иванов Иван Иванович', 'Отдел продаж', 'Менеджер по продажам', '2 года',
        'Получил золотую медаль на олимпиаде по математике',
        'Уважаемые члены приемной комиссии, я с большим энтузиазмом подаю заявку на поступление в ваш университет. Я уверен, что благодаря своим навыкам и опыту работы в отделе продаж, смогу стать ценным активом для вашего корпоративного университета.'),
       (2, 'Петров Петр Петрович', 'Отдел маркетинга', 'Маркетолог', '3 года',
        'Разработал успешную рекламную кампанию для компании',
        'Уважаемые члены приемной комиссии, я хочу присоединиться к вашему университету и расширить свои знания в области маркетинга. Мой опыт работы в отделе маркетинга позволил мне разработать успешные стратегии и достичь значительных результатов.'),
       (3, 'Сидоров Алексей Владимирович', 'Отдел разработки', 'Программист', '5 лет',
        'Участник международной конференции по разработке ПО',
        'Уважаемые члены приемной комиссии, я хочу пройти обучение в вашем университете и улучшить свои навыки программирования. Мой опыт работы в отделе разработки и участие в международных конференциях подтверждают мою преданность этой области.'),
       (4, 'Козлова Екатерина Сергеевна', 'Финансовый отдел', 'Бухгалтер', '4 года',
        'Получила сертификат профессионального бухгалтера',
        'Уважаемые члены приемной комиссии, я очень заинтересована в обучении в вашем университете и расширении своих знаний в области финансов. Мой опыт работы в финансовом отделе и получение сертификата профессионального бухгалтера делают меня подходящим кандидатом для вашего университета.'),
       (5, 'Васильев Андрей Николаевич', 'HR-отдел', 'HR-менеджер', '3 года',
        'Организовал успешную программу по привлечению и подбору талантливых сотрудников',
        'Уважаемые члены приемной комиссии, я хочу стать студентом вашего университета и расширить свои знания в области управления персоналом. Мой опыт работы в HR-отделе позволил мне разработать эффективные методики подбора и оценки сотрудников.'),
       (6, 'Григорьева Ольга Александровна', 'Отдел PR', 'PR-специалист', '2 года',
        'Организовала успешные пресс-конференции и медийные акции',
        'Уважаемые члены приемной комиссии, я хочу стать студентом вашего университета и расширить свои знания в области управления персоналом. Мой опыт работы в PR-отделе позволил мне разработать эффективные методики подбора и оценки сотрудников.');
INSERT INTO courses (id, course_name, description)
VALUES (1, 'Математика', 'Курс по математике для начинающих'),
       (2, 'Английский язык', 'Интенсивный курс английского языка'),
       (3, 'Физика', 'Основы физики и законы природы'),
       (4, 'История', 'Курс истории развития человечества'),
       (5, 'Химия', 'Углубленное изучение основ химии'),
       (6, 'Литература', 'Классическая литература и её анализ'),
       (7, 'Биология', 'Строение организмов и экосистемы'),
       (8, 'Экономика', 'Основы экономической теории и практики'),
       (9, 'Психология', 'Введение в основы психологии'),
       (10, 'География', 'Изучение географических регионов и наук');
INSERT INTO groups (id, group_curator)
VALUES (1, 4),
       (2, 5),
       (3, 6),
       (4, 5),
       (5, 4),
       (6, 4),
       (7, 5),
       (8, 6),
       (9, 4),
       (10, 5);

INSERT INTO students_groups (user_id, group_id)
VALUES (9, 1),
       (10, 1),
       (9, 2),
       (10, 3);
--        (11, 2),
--        (12, 2),
--        (13, 3),
--        (14, 3),
--        (15, 4),
--        (16, 4);
-- Пример 1
INSERT INTO groups_courses_teachers (id, groups_id, course_id, teacher_id)
VALUES (1, 1, 1, 2);

-- Пример 2
INSERT INTO groups_courses_teachers (id, groups_id, course_id, teacher_id)
VALUES (2, 2, 2, 2);

-- Пример 3
INSERT INTO groups_courses_teachers (id, groups_id, course_id, teacher_id)
VALUES (3, 3, 3, 3);

-- Пример 4
INSERT INTO groups_courses_teachers (id, groups_id, course_id, teacher_id)
VALUES (4, 4, 4, 3);

INSERT INTO news (id, title, date, text)
VALUES (1, 'Заголовок статьи 1', '2023-10-20', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in blandit ante. Vestibulum dolor nisi, imperdiet in dictum eu, tincidunt sed purus. Sed turpis metus, dictum eget mi in, pellentesque lacinia augue. Fusce lacus ex, faucibus nec odio vel, tempor suscipit est. Aenean bibendum est ut nisl euismod, at sollicitudin nisi interdum. Nunc ac maximus arcu, at consequat odio. Cras lacinia libero sit amet blandit porttitor'),
(2, 'Заголовок статьи 2', '2023-10-21', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in blandit ante. Vestibulum dolor nisi, imperdiet in dictum eu, tincidunt sed purus. Sed turpis metus, dictum eget mi in, pellentesque lacinia augue. Fusce lacus ex, faucibus nec odio vel, tempor suscipit est. Aenean bibendum est ut nisl euismod, at sollicitudin nisi interdum. Nunc ac maximus arcu, at consequat odio. Cras lacinia libero sit amet blandit porttitor'),
(3, 'Заголовок статьи 3', '2023-10-22', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in blandit ante. Vestibulum dolor nisi, imperdiet in dictum eu, tincidunt sed purus. Sed turpis metus, dictum eget mi in, pellentesque lacinia augue. Fusce lacus ex, faucibus nec odio vel, tempor suscipit est. Aenean bibendum est ut nisl euismod, at sollicitudin nisi interdum. Nunc ac maximus arcu, at consequat odio. Cras lacinia libero sit amet blandit porttitor');
