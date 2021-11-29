CREATE TABLE IF NOT EXISTS public.accomodation
(
    id integer NOT NULL,
    type character varying(32) COLLATE pg_catalog."default" NOT NULL,
    bed_type character varying(32) COLLATE pg_catalog."default" NOT NULL,
    max_guests integer NOT NULL,
    description character varying(512) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT accomodation_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.room_fare
(
    id integer NOT NULL,
    value double precision,
    season character varying(32) COLLATE pg_catalog."default",
    CONSTRAINT room_fare_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS public.accomodation_fare_relations
(
    id integer NOT NULL DEFAULT nextval('accomodation_fare_relations_id_seq'::regclass),
    id_accomodation integer,
    id_room_fare integer,
    CONSTRAINT accomodation_fare_relations_id_accomodation_fkey FOREIGN KEY (id_accomodation)
        REFERENCES public.accomodation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT accomodation_fare_relations_id_room_fare_fkey FOREIGN KEY (id_room_fare)
        REFERENCES public.room_fare (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);