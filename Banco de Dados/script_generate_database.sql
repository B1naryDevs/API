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
pret_salarial decimal(7,2) not null,
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

CREATE TABLE setor (
    nome_setor VARCHAR(40) NOT NULL,
    PRIMARY KEY (nome_setor)
);

CREATE TABLE vaga (
    cargo_vaga VARCHAR(32) NOT NULL,
    funcionario_cpf BIGINT(11) NULL,
    setor_vaga VARCHAR(30) NULL,
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
    setor_cargo VARCHAR(40) NOT NULL,
    PRIMARY KEY (nome_cargo)
);

CREATE TABLE formacao (
    id_formacao INT(5) AUTO_INCREMENT NOT NULL,
    cpf_candidato_form BIGINT(11) NOT NULL,
    instituicao VARCHAR(50) NOT NULL,
    curso VARCHAR(30) NOT NULL,
    inicio_curso varchar(10) not null,
    termino_curso varchar(10) not null,
    incompleto ENUM('Sim', 'Não') NOT NULL,
    PRIMARY KEY (id_formacao)
);

CREATE TABLE experiencia_profissional (
    id_cargo INT(5) AUTO_INCREMENT NOT NULL,
    cpf_candidato_exp BIGINT(11) NOT NULL,
    cargo_exercido VARCHAR(40) NOT NULL,
    inicio_exp varchar(10) not null,
    termino_exp varchar(10) not null,
    cargo_atual ENUM('Sim', 'Não') NOT NULL,
    desc_atividades VARCHAR(80) NOT NULL,
    PRIMARY KEY (id_cargo)
);

CREATE TABLE competencia (
    id_comp INT(5) NOT NULL AUTO_INCREMENT,
    cpf_candidato_comp BIGINT(11) NOT NULL,
    nome_comp VARCHAR(35) NOT NULL,
    area_comp VARCHAR(35) NOT NULL,
    nivel ENUM('Básico', 'Intermediário', 'Avançado'),
    PRIMARY KEY (id_comp)
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
    status_cand ENUM('Em andamento', 'Desclassificado', 'Entrevista Online', 'Entrevista Presencial', 
    'Entrevista com Diretoria', 'Em Contratação' , 'Contratado'),
    PRIMARY KEY (id_candidatura)
);

CREATE TABLE pretensao_cargo (
    id_pret INT(5) AUTO_INCREMENT NOT NULL,
    cpf_candidato_pret BIGINT(11) NOT NULL,
    nome_cargo_pret VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_pret)
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

# CHAVE ESTRANGEIRA FK - CPF CANDIDATO PARA FORMAÇÃO 
ALTER TABLE formacao ADD FOREIGN KEY (cpf_candidato_form) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - CPF CANDIDATO PARA PRETENÇÃO DE CARGO 
ALTER TABLE pretensao_cargo ADD FOREIGN KEY (cpf_candidato_pret) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - NOME DO CARGO PARA PRETENÇÃO DE CARGO PRETENDIDO DO CANDIDATO
ALTER TABLE pretensao_cargo ADD FOREIGN KEY (nome_cargo_pret) REFERENCES cargo(nome_cargo);

# CHAVE ESTRANGEIRA FK - CPF CANDIDATO PARA COMPETÊNCIA
ALTER TABLE competencia ADD FOREIGN KEY (cpf_candidato_comp) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - CPF CANDIDATO PARA EXPERIÊNCIA PROFISSIONAL
ALTER TABLE experiencia_profissional ADD FOREIGN KEY (cpf_candidato_exp) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - NOME SETOR PARA SETOR DO CARGO
ALTER TABLE cargo ADD FOREIGN KEY (setor_cargo) REFERENCES setor (nome_setor);


# ACRESCENTAMENTO DE INFORMAÇÕES TESTES ---------------------------------------
------------------------------------------------------------------------------

#ADICIONAR FUNCIONARIO
insert into funcionario(nome_func, email, senha, cpf, telefone) values
("Carlos Aparecido", "Adm@gmail.com", "202cb962ac59075b964b07152d234b70", 12147865201, 12996141485);

#ADICIONAR VAGA DE CANDIDATOS
insert into candidato (nome_candidato, cpf, data_nasc, telefone, pret_salarial) values 
('Gabriel', 48615448696, '2003-12-17', 12992545421, 200.50);

insert into usuario (email, senha, cpf_candidato_usu) values 
('Gabriel@gmail.com', '202cb962ac59075b964b07152d234b70', 48615448696);

select f.nome_func as nome, c.funcionario_cpf as cpf, count(c.status_cand) as N°_Aprovados from funcionario as f inner join candidatura as c
on f.cpf = c.funcionario_cpf where c.status_cand = 'Contratado' group by funcionario_cpf order by count(c.status_cand) desc;

select f.nome_func as nome, c.funcionario_cpf as cpf, count(c.status_cand) as N°_Desclassificados from funcionario as f inner join candidatura as c
on f.cpf = c.funcionario_cpf where c.status_cand = 'Desclassificado' group by funcionario_cpf order by count(c.status_cand) desc;
