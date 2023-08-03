INSERT INTO public.course(id, name)
	VALUES (1, 'Math'),
           (2, 'Informatics'),
           (3, 'Biology'),
           (4,'Literature');

SELECT setval((SELECT pg_get_serial_sequence('public.course', 'id')), (SELECT max(id) FROM public.course));





