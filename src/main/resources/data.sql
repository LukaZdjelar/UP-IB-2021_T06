/*insert into role (name) values ("ADMIN");
insert into role (name) values ("PATIENT");
insert into role (name) values ("DOCTOR");
insert into role (name) values ("NURSE");
insert into role (name) values ("STAFF");

insert into adresa (`broj`, `drzava`, `grad`, `ulica`) values (4, 'blabla', 'blabla', 'blabla');

insert into korisnik (brojtelefona, email, ime, lozinka, prezime, adresa_id,approved) values ('123456', 'admin@gmail.com', 'Jovan', '123','Prpa', 1,1 );

insert into korisnik (brojtelefona, email, ime, lozinka, prezime, adresa_id,approved) values ('123457', 'pacijent@gmail.com', 'Milan', '456','Prpa', 1,1 );

insert into korisnik_roles (korisnik_korisnik_id, roles_id) values (1, 3)

insert into korisnik_roles (korisnik_korisnik_id, roles_id) values (2, 2)

insert into klinika (naziv,adresa_id,opis,ocena) values ("Klinika 1" ,1,"Dobra",4)

insert into termin (lekar,klinika_id,datumIVreme,cena,trajanje) values (1,1,"2022-02-14",1400,14)
