# Sistema-de-Gestao-de-Videoaulas
Sistema em Java de comércio eletrônico para vendas de cursos em videoaulas

Projeto compactado no arquivo Sistema de Gestão de Videoaulas (sem Jar)

Arquivo especificacaoProjetoSGV contém os protótipos de tela e funcionalidades.

Banco de Dados MySQL

SCRIPT 




create database inter;
use inter;



CREATE TABLE endereco (

  idEndereco int(11) NOT NULL PRIMARY KEY auto_increment,

  logradouro varchar(45) NOT NULL,

  numero int(11) NOT NULL,

  complemento varchar(45) DEFAULT NULL,

  cidade varchar(45) NOT NULL,

  uf char(2) DEFAULT NULL,

  cep varchar(30) DEFAULT NULL
  );

CREATE TABLE cliente (

  idCliente int(11) NOT NULL PRIMARY KEY,

  nome varchar(45) NOT NULL,

  email varchar(45) DEFAULT NULL,

  idEndereco int(11) DEFAULT NULL,

  FOREIGN KEY (idEndereco) REFERENCES endereco(idEndereco) ON DELETE CASCADE ON UPDATE CASCADE

);





CREATE TABLE categoria (

  idCategoria int PRIMARY KEY auto_increment,

  descricao varchar(500) DEFAULT NULL  

);




CREATE TABLE curso (

  idCurso int(11) PRIMARY KEY auto_increment,

  nome varchar(500) DEFAULT NULL,

  descricao varchar(45) DEFAULT NULL,

  preco double DEFAULT NULL,
  
  duracao int DEFAULT NULL,

  idCategoria int,

  imgUrl varchar(50) DEFAULT NULL,

  foreign key(idCategoria) references categoria(idCategoria)
 
 );
 

insert into categoria (descricao) value ('Curso de C#');
 

create table aula(
idAula varchar(20) primary key,
descricao varchar(60),
idCurso int,

foreign key(idCurso) references curso(idCurso)


);

CREATE TABLE pedido (

  idPedido int(11) PRIMARY KEY,

  dataPedido date DEFAULT NULL,

  dataPagamento date DEFAULT NULL,

  idCliente int(11) DEFAULT NULL,

  FOREIGN KEY (idCliente) REFERENCES cliente(idCliente) ON DELETE CASCADE ON UPDATE CASCADE
 
);

CREATE TABLE itempedido (

  idItemPedido int(11) NOT NULL PRIMARY KEY,

  preco double NOT NULL,

  quantidade int(11) NOT NULL,

  idCurso int(11) NOT NULL,

  idPedido int(11) NOT NULL,

  FOREIGN KEY (idCurso) REFERENCES curso(idCurso) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (idPedido) REFERENCES pedido(idPedido) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE usuario (
cod_usuario INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(80) NOT NULL,
email VARCHAR(255) NOT NULL,
senha VARCHAR(30) NOT NULL,
ativo TINYINT(1) NOT NULL,
PRIMARY KEY (cod_usuario),
UNIQUE KEY (email)
);
CREATE TABLE usuario_permissao (
usuario INT NOT NULL,
permissao VARCHAR(20) NOT NULL,
FOREIGN KEY (usuario)
REFERENCES usuario (cod_usuario)
ON DELETE CASCADE
ON UPDATE CASCADE
);
LOCK TABLES usuario WRITE;
ALTER TABLE usuario DISABLE KEYS;
INSERT INTO usuario(cod_usuario, nome, email, senha, ativo) VALUES
(1,'Joao Silva', 'joao@gmail.com', '123', 1);
ALTER TABLE usuario ENABLE KEYS;
UNLOCK TABLES;
INSERT INTO usuario_permissao(usuario, permissao) VALUES
(1,'ROLE_OPERADOR');


insert into categoria (descricao) value ('Curso de C#');


insert into curso (nome, descricao, preco, duracao, idCategoria, imgUrl) value ('Curso Avançado de C#', 'Este é um curso avançado', 40, 200, 1, 'csharp.jpg');





