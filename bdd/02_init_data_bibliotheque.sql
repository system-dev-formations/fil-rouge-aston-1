INSERT INTO public.client (reference,email,nom,numero_tel,prenom) VALUES
	 (1,'toto@client.fr','toto','0123456789','toto'),
	 (2,'tata@client.fr','tata','0987654321','tata'),
	 (3,'titi@client.fr','titi','0159478236','titi'),
	 (4,'tutu@client.fr','tutu','0236478159','tutu'),
	 (5,'tete@client.fr','tete','0874159236','tete');

INSERT INTO public.livre (reference,auteur,commande_en_cours,genre,nombre_demandes,quantite,titre,en_preparation) VALUES
	 (4,'auteur3',false,'genre1',0,12,'titre4',false),
	 (6,'auteur1',false,'genre1',0,7,'titre2',false),
	 (8,'auteur1',false,'genre1',0,12,'titre4',false),
	 (11,'auteur1',false,'genre1',0,9,'titre7',false),
	 (12,'auteur4',false,'genre3',2,0,'titre2',false),
	 (13,'auteur4',false,'genre3',0,0,'titre3',false),
	 (1,'auteur1',false,'genre1',17,15,'titre1',false),
	 (7,'auteur1',false,'genre1',20,10,'titre3',false),
	 (9,'auteur1',false,'genre1',9,8,'titre5',false),
	 (10,'auteur1',false,'genre1',12,11,'titre6',false);
INSERT INTO public.livre (reference,auteur,commande_en_cours,genre,nombre_demandes,quantite,titre,en_preparation) VALUES
	 (2,'auteur1',false,'genre1',11,10,'titre2',false),
	 (3,'auteur2',false,'genre2',21,20,'titre3',false),
	 (5,'auteur4',false,'genre3',13,0,'titre1',false),
	 (14,'auteur4',false,'genre3',7,0,'titre4',false),
	 (15,'auteur4',false,'genre3',4,0,'titre5',false),
	 (16,'auteur4',false,'genre3',1,0,'titre6',false);

INSERT INTO public.reservation (reference,date_retrait,client_reference,date_reservation,en_preparation) VALUES
	 (2,NULL,1,'2021-04-12 20:00:00',false),
	 (8,NULL,5,'2021-04-15 13:00:00',false),
	 (11,NULL,1,'2021-04-14 20:00:00',false),
	 (1,NULL,1,'2021-04-14 08:00:00',false),
	 (13,NULL,2,'2021-04-14 12:00:00',false),
	 (4,NULL,3,'2021-04-14 11:00:00',false),
	 (5,NULL,4,'2021-04-14 11:30:00',false),
	 (7,NULL,5,'2021-04-14 20:30:00',false),
	 (3,NULL,2,'2021-04-14 21:00:00',false),
	 (9,NULL,5,'2021-04-14 22:00:00',false);
INSERT INTO public.reservation (reference,date_retrait,client_reference,date_reservation,en_preparation) VALUES
	 (10,NULL,1,'2021-04-14 09:00:00',false),
	 (6,NULL,5,'2021-04-14 10:00:00',false),
	 (12,'2021-04-14',1,'2021-04-14 07:00:00',true);

INSERT INTO public.reservation_livres (reservation_reference,livres_reference) VALUES
	 (1,1),
	 (1,2),
	 (2,1),
	 (2,4),
	 (3,2),
	 (4,1),
	 (6,1),
	 (2,3),
	 (4,2),
	 (13,1);
INSERT INTO public.reservation_livres (reservation_reference,livres_reference) VALUES
	 (12,1),
	 (11,1);
