create database patrimonio;
use patrimonio;
create table usuarios(
	id int not null primary key auto_increment,
    nome varchar(90) not null,
    email varchar(90) not null,
    senha varchar(100) not null
);
create table item(
	id_patrimonio int not null primary key auto_increment,
    nome varchar(90) not null,
    fabricante varchar(90) not null,
    quantidade int not null,
    fornecedor varchar(50) not null,
    armazem varchar(90) not null
);
insert into usuarios(nome, email,  senha) values ('Higor','higor.rabelo@gmail.com',md5('Higor20')); 
insert into item (nome,fabricante,quantidade,fornecedor,armazem) values ('Teclado Mecânico','Multilaser',20,'Magazan','Unidade Doca');
select * from usuarios;
select * from item;