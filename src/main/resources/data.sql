insert into public.course(id, name)
	VALUES (1, 'Math'),
           (2, 'Informatics'),
           (3, 'Biology'),
           (4,'Literature');

insert into public.person(id, role, last_name, first_name, phone, email, course_id)
	VALUES (1, 'STUDENT','Leonov','Leon','0963459203','0963459203@gmail.com',1),
	       (2, 'STUDENT','Makarova','Marina','0917159203','0917159203@gmail.com',1),
	       (3, 'STUDENT','Markov','Mark','0967159203','0967159203@gmail.com',2),
	       (4, 'STUDENT','Andreev','Andrey','0963459333','0963459333@gmail.com',4),
	       (5, 'STUDENT','Alekseev','Aleksey','0963459444','0963459444@gmail.com',2),
	       (6, 'STUDENT','Aleksandrov','Alex','0963459555','0963459555@gmail.com',2),
	       (7, 'STUDENT','Buzova','Liza','0963459004','0963459004@gmail.com',2),
	       (8, 'STUDENT','Nazarenko','Nazar','0963459999','0963459999@gmail.com',1),
	       (9, 'STUDENT','Azarova','Lina','0963459977','0963459977@gmail.com',3);

insert into public.person(id, role, last_name, first_name, phone, email, course_id)
	VALUES (10, 'TEACHER','Altov','Alex','0953459999','0953459999@gmail.com',1),
	       (11, 'TEACHER','Mohov','Evgen','0953459993','0953459993@gmail.com',2),
           (12, 'TEACHER','Ilster','Vlad','0353459993','0353459993@gmail.com',3),
	       (13, 'TEACHER','Baranov','Ilia','0353450993','0353450993@gmail.com',4);

select setval((select pg_get_serial_sequence('public.course', 'id')), (select max(id) from public.course));
select setval((select pg_get_serial_sequence('public.person', 'id')), (select max(id) from public.person));
select setval((select pg_get_serial_sequence('public.users', 'id')), (select max(id) from public.users));
select setval((select pg_get_serial_sequence('public.role', 'id')), (select max(id) from public.role));

-- passwords  u:u, t:t, a:a
insert into users(id, username, password, email) values
(1, 'u', '$2a$10$rBGCVyN9gdG1bxY9bZYG/eWmKAo8M.dPBawJC3G6OoEow1jNxGnbK', 'vasjavasilich@gmail.com'),
(2, 't', '$2a$10$PrpZ0GgvlLLII36T24uQteqFnozK.KV/SknOrXYqheTltdkM2ssXi', 'vasjavasilich@gmail.com'),
(3, 'a', '$2a$10$EEC5emV5e3UYo/yvznWkKeGc02oKmigRPx8EU2W6sm3Xam2ngtKLK', 'vasjavasilich@gmail.com');

insert into role(id, name) values
(1, 'ROLE_STUDENT'),
(2, 'ROLE_TEACHER'),
(3, 'ROLE_ADMIN');

insert into user_role(user_id, role_id) values
(1, 1), -- u : student role
(2, 2), -- t : teacher role
(3, 3); -- a : admin role




