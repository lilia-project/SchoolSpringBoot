create TABLE IF NOT EXISTS public.course
   (
       id serial NOT NULL,
       name text NOT NULL,
       PRIMARY KEY (id)
   );