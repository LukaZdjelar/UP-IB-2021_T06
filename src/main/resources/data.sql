insert into role (name) values ("ADMIN");
insert into role (name) values ("PATIENT");
insert into role (name) values ("DOCTOR");
insert into role (name) values ("NURSE");
insert into role (name) values ("STAFF");

insert into adresa (`broj`, `drzava`, `grad`, `ulica`) values (4, 'blabla', 'blabla', 'blabla');

insert into korisnik (brojtelefona, email, ime, lozinka, prezime, adresa_id) values ('123456', 'gsfahf@bjkg.com', 'admin', 'admin','admin', 1 );

insert into korisnik_roles (korisnik_korisnik_id, roles_id) values (1, 1)