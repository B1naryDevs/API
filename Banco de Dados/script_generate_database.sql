#CREATE USER 'binary'@'localhost' IDENTIFIED BY 'binary123';
#GRANT ALL PRIVILEGES ON * . * TO 'binary'@'localhost';

create database api
default character set utf8
default collate utf8_general_ci; 

use api;

# TABELAS SÓLIDAS ---------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

CREATE TABLE candidato(
nome_candidato varchar(30) not null,
cpf bigint (11) not null,
data_nasc varchar(10) not null,
telefone bigint (11) not null,
pret_salarial decimal(7,2) null,
pret_cargo varchar(30) null,
nome_comp VARCHAR(35) NULL,
instituicao VARCHAR(50) NULL,
inicio_curso varchar(10) null,
termino_curso varchar(10) null,
nivel ENUM('Básico', 'Intermediário', 'Avançado') null,
curso VARCHAR(30) NULL,
primary key (cpf)) default charset = utf8;

CREATE TABLE usuario (
    email VARCHAR(40) NOT NULL,
    senha VARCHAR(40) NOT NULL,
    cpf_candidato_usu BIGINT(11) NULL,
    PRIMARY KEY (email)
); 

CREATE TABLE funcionario (
nome_func VARCHAR(60) not null,
email VARCHAR(40) NOT NULL UNIQUE,
senha VARCHAR(40) NOT NULL,
cpf BIGINT(11) NOT NULL,
telefone BIGINT NOT NULL,
primary key (cpf)
);

CREATE TABLE vaga (
    cargo_vaga VARCHAR(32) NOT NULL,
    funcionario_cpf BIGINT(11) NULL,
    id_vaga INT(5) NOT NULL AUTO_INCREMENT,
    periodo VARCHAR(20) NOT NULL,
    experiencia ENUM('Sim', 'Não') NOT NULL,
    salario DECIMAL(7 , 2 ) NOT NULL,
    descricao_vaga VARCHAR(200) NOT NULL,
    endereco_vaga VARCHAR(60) NULL,
    cidade_vaga VARCHAR(40) NULL,
    remoto ENUM('Sim', 'Não') NOT NULL,
    status_vaga ENUM('Aberta', 'Encerrada', 'Em Andamento') NOT NULL,
    PRIMARY KEY (id_vaga)
);

CREATE TABLE cargo (
    nome_cargo VARCHAR(32) NOT NULL,
    id_cargo INT(5) AUTO_INCREMENT UNIQUE,
    PRIMARY KEY (nome_cargo)
);

CREATE TABLE experiencia_profissional (
    id_exp INT(5) AUTO_INCREMENT NOT NULL,
    cpf_candidato_exp BIGINT(11) NOT NULL,
    cargo_exercido VARCHAR(40) NOT NULL,
    inicio_exp varchar(10) not null,
    termino_exp varchar(10) null,
    cargo_atual ENUM('Sim', 'Não') NOT NULL,
    desc_atividades VARCHAR(80) NOT NULL,
    PRIMARY KEY (id_exp)
);


# TABELAS RELACIONAMENTOS ---------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

CREATE TABLE candidatura (
	funcionario_cpf BIGINT(11) NULL,
    cargo_candidatura VARCHAR(30) NOT NULL,
    id_candidatura INT(5) AUTO_INCREMENT,
    cpf_candidatura BIGINT(11) NOT NULL,
    cod_vaga INT(5) NOT NULL,
    data_cand varchar(10) not null,
    status_cand ENUM('Em andamento', 'Aprovado', 'Reprovado'),
    PRIMARY KEY (id_candidatura)
);

# CRIAÇÃO DE CHAVES ESTRANGEIRAS (FK) ----------------------------------------------------
------------------------------------------------------------------------------------------
# CHAVE ESTRANGEIRA FK - EMAIL DE USUARIO
ALTER TABLE usuario ADD FOREIGN KEY (cpf_candidato_usu) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - CARGO PARA VAGA 
ALTER TABLE vaga ADD FOREIGN KEY (cargo_vaga) REFERENCES cargo (nome_cargo);

# CHAVE ESTRANGEIRA FK - CPF DO CANDIDATO PARA CANDIDATURA
ALTER TABLE candidatura ADD FOREIGN KEY (cpf_candidatura) REFERENCES candidato (cpf);

ALTER TABLE candidatura ADD FOREIGN KEY (funcionario_cpf) REFERENCES funcionario(cpf);

# CHAVE ESTRANGEIRA FK - CODIGO DA VAGA PARA CANDIDATURA
ALTER TABLE candidatura ADD FOREIGN KEY (cod_vaga) REFERENCES vaga (id_vaga);

# CHAVE ESTRANGEIRA FK - CARGO DA CANDIDATURA PARA CARGO 
ALTER TABLE candidatura ADD FOREIGN KEY (cargo_candidatura) REFERENCES cargo(nome_cargo);

# CHAVE ESTRANGEIRA FK - NOME DO CARGO PARA PRETENÇÃO DE CARGO PRETENDIDO DO CANDIDATO
ALTER TABLE candidato ADD FOREIGN KEY (pret_cargo) REFERENCES cargo(nome_cargo);

# CHAVE ESTRANGEIRA FK - CPF CANDIDATO PARA EXPERIÊNCIA PROFISSIONAL
ALTER TABLE experiencia_profissional ADD FOREIGN KEY (cpf_candidato_exp) REFERENCES candidato (cpf);

# ACRESCENTAMENTO DE INFORMAÇÕES TESTES ---------------------------------------
------------------------------------------------------------------------------

#ADICIONAR FUNCIONARIO
insert into funcionario(nome_func, email, senha, cpf, telefone) values
("Carlos Aparecido", "Adm@gmail.com", "652f1ba612e65639e279dd156d93b401", 12147865201, 12996141485);

#ADICIONAR CARGOS
insert into cargo(nome_cargo) values
("Desenvolvedor Back-end"),
("Desenvolvedor Front-end"),
("Admnistrador de Banco de dados"),
("Analista de Sistemas");


