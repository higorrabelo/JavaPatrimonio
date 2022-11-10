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
insert into item (nome,fabricante,quantidade,fornecedor,armazem) values ('Monitor','LG',10,'Amazon','Unidade Duque');
select * from usuarios;
select * from item;
update item set nome = "Teclado Mecânico", fabricante = "EPSON", quantidade = 18, fornecedor = "Magazine Luiza" , armazem = "Duque" where id_patrimonio = 1;
delete from item where id_patrimonio = 2;