drop database api;

create database api
default character set utf8
default collate utf8_general_ci;

use api;

CREATE TABLE candidatos(
nome_candidato varchar(30) not null,
cpf bigint (11) not null,
data_nasc datetime not null,
pret_salarial decimal(7,2) not null,
primary key (cpf)) default charset = utf8;

CREATE TABLE usuario(
email varchar(40) not null,
senha varchar(40) not null,
primary key (email)
);

CREATE TABLE rh(
nome_rh varchar(40) not null,
funcao varchar (30) not null,
nivel_acesso enum('1', '2') not null,
primary key (nome_rh)
); 

CREATE TABLE vaga(
id_vaga int(5) not null auto_increment,
nome_vaga varchar(40) not null,
periodo varchar (20) not null,
experiencia enum('Sim', 'Não') not null,
salario decimal(7,2) not null,

);