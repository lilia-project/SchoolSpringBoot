create TABLE IF NOT EXISTS public.course
   (
       id serial NOT NULL,
       name text NOT NULL,
       PRIMARY KEY (id)
   );
create TABLE IF NOT EXISTS public.person
   (
       id serial NOT NULL,
       role text NOT NULL,
       last_name text NOT NULL,
       first_name text,
       phone text,
       email text,
       course_id integer,
       PRIMARY KEY (id),
       CONSTRAINT f_course_id FOREIGN KEY (course_id)
       REFERENCES public.course (id) MATCH SIMPLE
   );
