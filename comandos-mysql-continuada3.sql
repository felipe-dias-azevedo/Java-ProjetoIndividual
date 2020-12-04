create database continuada3;
use continuada3;

create table produto (
	id int primary key auto_increment,
	nome varchar(200),
	preco decimal(10,2),
	categoria int
);

create table usuario (
	idUser int primary key auto_increment,
	nomeUser varchar(200),
	senhaUser varchar(200)
);

insert into usuario (nomeUser, senhaUser) values
('felipe', '123fe'),
('celia', 'celia'),
('yoshi', '123yo'),
('diego', 'diego'),
('mari', '123mari');

insert into produto (nome, preco, categoria) values
('SSD 240GB', 200.00, 0),
('Harry Potter', 56.50, 1),
('Ryzen 5600X', 2000.00, 0),
('Senhor dos Aneis', 76.30, 1),
('Big Mac', 6.99, 2);
