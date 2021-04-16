-- public.client definition

-- Drop table

-- DROP TABLE public.client;

CREATE TABLE public.client (
	reference int8 NOT NULL,
	email varchar(255) NULL,
	nom varchar(255) NULL,
	numero_tel varchar(255) NULL,
	prenom varchar(255) NULL,
	CONSTRAINT client_pkey PRIMARY KEY (reference)
);


-- public.livre definition

-- Drop table

-- DROP TABLE public.livre;

CREATE TABLE public.livre (
	reference int8 NOT NULL,
	auteur varchar(255) NULL,
	commande_en_cours bool NULL,
	genre varchar(255) NULL,
	nombre_demandes int4 NULL,
	quantite int4 NULL,
	titre varchar(255) NULL,
	en_preparation bool NULL,
	CONSTRAINT livre_pkey PRIMARY KEY (reference)
);


-- public.reservation definition

-- Drop table

-- DROP TABLE public.reservation;

CREATE TABLE public.reservation (
	reference int8 NOT NULL,
	date_retrait date NULL,
	client_reference int8 NULL,
	date_reservation timestamp(0) NOT NULL,
	en_preparation bool NULL,
	CONSTRAINT reservation_pkey PRIMARY KEY (reference),
	CONSTRAINT fkmvi9m3n4tdvawu0am9fqdvltf FOREIGN KEY (client_reference) REFERENCES client(reference)
);


-- public.reservation_livres definition

-- Drop table

-- DROP TABLE public.reservation_livres;

CREATE TABLE public.reservation_livres (
	reservation_reference int8 NOT NULL,
	livres_reference int8 NOT NULL,
	CONSTRAINT fkek2bnc7kjkhugkjdum9o3md0o FOREIGN KEY (reservation_reference) REFERENCES reservation(reference),
	CONSTRAINT fkqdkvrbecl0x957xcx4uxdv9f FOREIGN KEY (livres_reference) REFERENCES livre(reference)
);
