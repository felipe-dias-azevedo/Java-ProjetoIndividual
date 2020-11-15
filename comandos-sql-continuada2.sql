create table usuario (
    id int primary key auto_increment,
    nome varchar(50),
    email varchar(50),
    senha varchar(50),
    telefone varchar(15)
);

select * from usuario;

insert into usuario (nome, email, senha, telefone) values 
('Felipe Azevedo', 'felipe@gmail.com', 'felipe', '950277693'),
('Mariana Dias', 'mari@gmail.com', '123', '921345010'),
('Mario Alves', 'mario@gmail.com', 'mario', '997363635'),
('José Yoshiriro', 'yoshi@gmail.com', 'yoshi', '987654321'),
('Diego Brito', 'diego@gmail.com', 'diego', '912345678');
