INSERT INTO public.course(id, name)
	VALUES (1, 'Math'),
           (2, 'Informatics'),
           (3, 'Biology'),
           (4,'Literature');

           INSERT INTO public.person(id, role, last_name, first_name, phone, email, course_id)
	VALUES (1, 'STUDENT','Leonov','Leon','0963459203','0963459203@gmail.com',1),
	       (2, 'STUDENT','Makarova','Marina','0917159203','0917159203@gmail.com',1),
	       (3, 'STUDENT','Markov','Mark','0967159203','0967159203@gmail.com',2),
	       (4, 'STUDENT','Andreev','Andrey','0963459333','0963459333@gmail.com',4),
	       (5, 'STUDENT','Alekseev','Aleksey','0963459444','0963459444@gmail.com',2),
	       (6, 'STUDENT','Aleksandrov','Alex','0963459555','0963459555@gmail.com',2),
	       (7, 'STUDENT','Buzova','Liza','0963459004','0963459004@gmail.com',2),
	       (8, 'STUDENT','Nazarenko','Nazar','0963459999','0963459999@gmail.com',1),
	       (9, 'STUDENT','Azarova','Lina','0963459977','0963459977@gmail.com',3);

INSERT INTO public.person(id, role, last_name, first_name, phone, email, course_id)
	VALUES (10, 'TEACHER','Altov','Alex','0953459999','0953459999@gmail.com',1),
	       (11, 'TEACHER','Mohov','Evgen','0953459993','0953459993@gmail.com',2),
           (12, 'TEACHER','Ilster','Vlad','0353459993','0353459993@gmail.com',3),
	       (13, 'TEACHER','Baranov','Ilia','0353450993','0353450993@gmail.com',4);

SELECT setval((SELECT pg_get_serial_sequence('public.course', 'id')), (SELECT max(id) FROM public.course));
SELECT setval((SELECT pg_get_serial_sequence('public.person', 'id')), (SELECT max(id) FROM public.person));





