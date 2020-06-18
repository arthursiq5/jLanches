CREATE DATABASE jlanches
	DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_general_ci;

USE jlanches;

CREATE TABLE categoria(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_categoria PRIMARY KEY(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE contato(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    fone CHAR(11),
    email VARCHAR(255),
    ativo BOOLEAN DEFAULT TRUE,
    CONSTRAINT pk_contato PRIMARY KEY(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE estado(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    sigla CHAR(2) UNIQUE not null,
    nome varchar(255) not null,
    CONSTRAINT pk_estado PRIMARY KEY(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE cidade(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    estado_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT pk_cidade PRIMARY KEY(id),
    CONSTRAINT fk_cidade_estado FOREIGN KEY (estado_id)
		REFERENCES estado(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE cliente(
	cpf CHAR(11) NOT NULL,
    nome VARCHAR(45) NOT NULL,
    endereco VARCHAR(255),
    ativo BOOLEAN  DEFAULT TRUE,
    cidade_id BIGINT UNSIGNED NOT NULL,
    contato_id BIGINT UNSIGNED,
    CONSTRAINT pk_cliente PRIMARY KEY (cpf),
    CONSTRAINT fk_cliente_cidade FOREIGN KEY(cidade_id)
		REFERENCES cidade(id),
	CONSTRAINT fk_cliente_contato FOREIGN KEY(contato_id)
		REFERENCES contato(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE lanche(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    ingredientes TEXT,
    valor DECIMAL(7, 2) NOT NULL DEFAULT '0.0',
    disponivel BOOLEAN DEFAULT true,
    categoria_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT pk_lanche PRIMARY KEY(id),
    CONSTRAINT fk_lanche_categoria FOREIGN KEY(categoria_id)
		REFERENCES categoria(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE franquia(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    endereco VARCHAR(255) NOT NULL,
    cnpj CHAR(14),
    ativo BOOLEAN DEFAULT TRUE,
    cidade_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT pk_franquia PRIMARY KEY(id),
    CONSTRAINT fk_franquia_cidade FOREIGN KEY(cidade_id)
		REFERENCES cidade(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE funcionario(
	cpf CHAR(11) NOT NULL,
	nome VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    administrador BOOLEAN DEFAULT FALSE,
    ativo BOOLEAN DEFAULT true,
    endereco VARCHAR(255),
    cidade_id BIGINT UNSIGNED,
    franquia_id BIGINT UNSIGNED NOT NULL,
    contato_id BIGINT UNSIGNED,
    CONSTRAINT pk_funcionario PRIMARY KEY(cpf),
    CONSTRAINT fk_funcionario_cidade FOREIGN KEY(cidade_id)
		REFERENCES cidade(id),
	CONSTRAINT fk_funcionario_franquia FOREIGN KEY(franquia_id)
		REFERENCES franquia(id),
	CONSTRAINT fk_funcionario_contato FOREIGN KEY(contato_id)
		REFERENCES contato(id)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE pedido(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    ativo BOOLEAN DEFAULT TRUE,
    data DATETIME,
    pago BOOLEAN DEFAULT false,
    forma_de_pagamento VARCHAR(255) NOT NULL,
    comentarios TEXT,
    cliente_cpf CHAR(11) NOT NULL,
    franquia_id BIGINT UNSIGNED NOT NULL,
    funcionario_cpf CHAR(11) NOT NULL,
    CONSTRAINT pk_pedido PRIMARY KEY(id),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY(cliente_cpf)
		REFERENCES cliente(cpf),
	CONSTRAINT fk_pedido_franquia FOREIGN KEY(franquia_id)
		REFERENCES franquia(id),
	CONSTRAINT fk_pedido_funcionario FOREIGN KEY(funcionario_cpf)
		REFERENCES funcionario(cpf)
) DEFAULT CHARSET = utf8mb4;

CREATE TABLE lanche_pedido(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    lanche_id BIGINT UNSIGNED NOT NULL,
    pedido_id BIGINT UNSIGNED NOT NULL,
    quantidade BIGINT UNSIGNED NOT NULL,
    valor DECIMAL(10, 2) DEFAULT '0',
    desconto DECIMAL(7, 2) DEFAULT '0',
    acrescimo DECIMAL(7, 2) DEFAULT '0',
    modificacoes VARCHAR(255),
    CONSTRAINT pk_lanchepedido PRIMARY KEY (id),
    CONSTRAINT fk_lanchepedido_lanche FOREIGN KEY(lanche_id)
		REFERENCES lanche(id),
	CONSTRAINT fk_lanchepedido_pedido FOREIGN KEY(pedido_id)
		REFERENCES pedido(id)
) DEFAULT CHARSET = utf8mb4;

drop database jlanches;
