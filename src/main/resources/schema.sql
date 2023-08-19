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

create TABLE IF NOT EXISTS users (
    id serial  NOT NULL,
    username text NOT NULL,
    password text NOT NULL,
    email text,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS role (
    id serial  NOT NULL,
    name text NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

create TABLE IF NOT EXISTS user_role (
    user_id integer  NOT NULL,
    role_id integer  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id)
);