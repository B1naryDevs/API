drop database api;

create database api
default character set utf8
default collate utf8_general_ci;

use api;

# TABELAS SÓLIDAS ---------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

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
periodo varchar (20) not null,
experiencia enum('Sim', 'Não') not null,
salario decimal(7,2) null,
descricao_vaga varchar(200) not null,
endereco_vaga varchar(60) not null,
cidade_vaga varchar(40) not null,
remoto enum('Sim', 'Não') not null,
status_vaga enum('Aberta', 'Encerrada') not null,
primary key (id_vaga)
);

CREATE TABLE cargo(
nome_cargo varchar(30) not null,
descricao_cargo varchar(100),
primary key (nome_cargo)
);

drop table cargo;

CREATE TABLE formacao(
id_formacao int(5) auto_increment not null,
instituicao varchar(50) not null,
curso varchar(30) not null,
inicio_curso date not null,
termino_curso date not null,
incompleto enum('Sim', 'Não') not null,
primary key (id_formacao)
);

CREATE TABLE experiencia_profissional(
id_cargo int(5) auto_increment not null,
cargo_exercido varchar(40) not null,
inicio_exp date not null,
termino_exp date not null,
cargo_atual enum('Sim', 'Não') not null,
desc_atividades varchar(80) not null, 
primary key (id_cargo)
);

CREATE TABLE competencias(
id_comp int(5) not null auto_increment,
nome_comp varchar(35) not null,
area_comp varchar(35) not null,
nivel enum('Básico', 'Intermediário', 'Avançado'),
primary key (id_comp)
);

# TABELAS RELACIONAMENTOS ---------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

CREATE TABLE candidatura(
id_candidatura int(5) auto_increment,
data_cand datetime not null,
status_cand enum('Em andamento', 'Desclassificado'),
primary key (id_candidatura)
);

# CRIAÇÃO DE CHAVES ESTRANGEIRAS (FK) ----------------------------------------------------
------------------------------------------------------------------------------------------

# CHAVE ESTRANGEIRA FK - CARGO || PARA VAGA 
ALTER TABLE vaga
ADD FOREIGN KEY (cargo_vaga)
REFERENCES cargo(nome_cargo);
 







