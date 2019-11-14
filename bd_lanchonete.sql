Create DATABASE bd_lanchonete
Default character set utf8
Default collate utf8_general_ci;

Use bd_lanchonete;

create table cliente (
	idCliente int auto_increment primary key,
	nome varchar(50) not null,
	telefone varchar(11),
	email varchar(40)
);

create table comanda (
	idComanda int auto_increment primary key
);

create table produto (
	idProduto int auto_increment primary key,
	nomeProduto varchar(50) not null,
	precoUnitario DECIMAL(5.2) not null
);

create table estoque (
	idItem int auto_increment primary key,
	nomeItem varchar(50) not null,
	precoUnitariotItem DECIMAL(5.2) not null,
	quantidadeItem int not null 
);

create table funcionario (
	idFuncionario int auto_increment primary key,
	rg varchar(12) not null,
	login varchar(11) not null,
	senha int not null,
	nome varchar(50) not null,
	funcao varchar(20) not null,
	telefone varchar(11) not null,
	email varchar(40) not null,
	sexo varchar(10) not null,
	cpf varchar(14) not null
);

create table gerencia (
	idFuncionario int primary key,
	gerencia_fun int not null,
	foreign key (idFuncionario) references funcionario(idFuncionario),
	foreign key (gerencia_fun) references funcionario(idFuncionario)
);

create table venda (
	idComanda int primary key,
	idCliente int not null,
	idProduto int not null,
	foreign key (idComanda) references comanda(idComanda),
	foreign key (idCliente) references cliente(idCliente),
	foreign key (idProduto) references produto(idProduto)
);

create table temEstoque (
	idProduto int primary key,
	idItem int not null,
	foreign key (idProduto) references produto(idProduto),
	foreign key (idItem) references estoque(idItem)
);
