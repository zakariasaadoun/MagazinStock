/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ziko
 * Created: 6 déc. 2023
 */

set serveroutput on;


create table administrateur(
idAd number(10) primary key,
NutilAd varchar2(30) unique,
MpAd varchar2(30)
);

create table employe(
idEmp number(10) primary key,
nomEmp varchar2(30),
prenomEmp varchar2(30),
cinEmp varchar2(20) unique,
telEmp varchar2(20) unique,
adresseEmp varchar2(100),
emailEmp varchar2(50),
sexeEmp varchar2(10),
NutilEmp varchar2(30) unique,
MpEmp varchar2(30),
idAd number(10) references administrateur(idAd)
);


create table client(
idCl number(10) primary key,
nomCl varchar2(30),
prenomCl varchar2(30),
cinCl varchar2(20) unique,
telCl varchar2(20) unique,
adresseCl varchar2(100),
emailCl varchar2(50),
sexeCl varchar2(10),
idEmp number(10) references employe(idEmp)
); 

create table produit(
idPd number(10) primary key,
refPd varchar2(100),
nomPd varchar2(200),
quantite number(10),
prixU number(10),
categorie varchar2(50),
description varchar2(300)
);

create table vente(
idv number(10) primary key,
datev date ,
qantitev number(10),
prixT number(10),
idCl number(10) references client(idCl) on delete cascade,
idPd number(10) references produit(idPd)on delete cascade
);








--PL/SQL

create  sequence seq1 start with 1 increment by 1;


create or replace trigger trg_T1_Auto_Inc
 before insert on client
 for each row
 begin
if :new.idCl is null then
select seq1.nextval into :new.idCl from dual;
end if;
end;


create  sequence seq2 start with 1 increment by 1;


create or replace trigger trg_T2_Auto_Inc
 before insert on employe
 for each row
 begin
if :new.idCl is null then
select seq1.nextval into :new.idCl from dual;
end if;
end;


create  sequence seq3 start with 1 increment by 1;


create or replace trigger trg_T3_Auto_Inc
 before insert on produit
 for each row
 begin
if :new.idPd is null then
select seq1.nextval into :new.idPd from dual;
end if;
end;


create  sequence seq3 start with 1 increment by 1;


create or replace trigger trg_T4_Auto_Inc
 before insert on avertissement
 for each row
 begin
if :new.idCl is null then
select seq1.nextval into :new.idCl from dual;
end if;
end;


create  sequence seq4 start with 1 increment by 1;

create or replace trigger trg_T4_Auto_Inc
 before insert on vente
 for each row
 begin
if :new.idv is null then
select seq4.nextval into :new.idv from dual;
end if;
end;




create or replace trigger TrigStock
after insert on vente
for each row

DECLARE
    stock number(10);
    q number(10);
BEGIN
    
    select quantite into stock from produit where idpd = :new.idpd;
    
    q := :new.qantitev;
   
    update produit set quantite = stock - q where idpd = :new.idpd;

end;
/











