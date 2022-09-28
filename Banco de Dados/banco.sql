create database api
default character set utf8
default collate utf8_general_ci;

use api;

# TABELAS SÓLIDAS ---------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

CREATE TABLE candidato(
nome_candidato varchar(30) not null,
cpf bigint (11) not null,
data_nasc datetime not null,
pret_salarial decimal(7,2) not null,
primary key (cpf)) default charset = utf8;

CREATE TABLE usuario(
email varchar(40) not null,
senha varchar(40) not null,
cpf_candidato_usu bigint (11) null,
nome_usu_rh varchar(40) null,
primary key (email)
);

CREATE TABLE rh(
nome_rh varchar(40) not null,
funcao varchar (30) not null,
nivel_acesso enum('1', '2') not null,
primary key (nome_rh)
); 

CREATE TABLE vaga(
cargo_vaga varchar(30) not null,
setor_vaga varchar(30) not null,
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

CREATE TABLE formacao(
id_formacao int(5) auto_increment not null,
cpf_candidato_form bigint (11) not null,
instituicao varchar(50) not null,
curso varchar(30) not null,
inicio_curso date not null,
termino_curso date not null,
incompleto enum('Sim', 'Não') not null,
primary key (id_formacao)
);

CREATE TABLE experiencia_profissional(
id_cargo int(5) auto_increment not null,
cpf_candidato_exp bigint (11) not null,
cargo_exercido varchar(40) not null,
inicio_exp date not null,
termino_exp date not null,
cargo_atual enum('Sim', 'Não') not null,
desc_atividades varchar(80) not null, 
primary key (id_cargo)
);

CREATE TABLE competencia(
id_comp int(5) not null auto_increment,
cpf_candidato_comp bigint (11) not null,
nome_comp varchar(35) not null,
area_comp varchar(35) not null,
nivel enum('Básico', 'Intermediário', 'Avançado'),
primary key (id_comp)
);

# TABELAS RELACIONAMENTOS ---------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

CREATE TABLE candidatura(
id_candidatura int(5) auto_increment,
cpf_candidatura bigint (11) not null,
cod_vaga int(5) not null,
data_cand datetime not null,
status_cand enum('Em andamento', 'Desclassificado'),
primary key (id_candidatura)
);

CREATE TABLE pretensao_cargo(
id_pret int(5) auto_increment not null,
cpf_candidato_pret bigint (11) not null,
nome_cargo_pret varchar(30) not null,
primary key (id_pret)
);

# CRIAÇÃO DE CHAVES ESTRANGEIRAS (FK) ----------------------------------------------------
------------------------------------------------------------------------------------------

# CHAVE ESTRANGEIRA FK - CARGO PARA VAGA 
ALTER TABLE vaga ADD FOREIGN KEY (cargo_vaga) REFERENCES cargo (nome_cargo);

# CHAVE ESTRANGEIRA FK - CPF DO CANDIDATO PARA CANDIDATURA
ALTER TABLE candidatura ADD FOREIGN KEY (cpf_candidatura) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - CODIGO DA VAGA PARA CANDIDATURA
ALTER TABLE candidatura ADD FOREIGN KEY (cod_vaga) REFERENCES vaga (id_vaga);

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


# ACRESCENTAMENTO DE INFORMAÇÕES TESTES ---------------------------------------
------------------------------------------------------------------------------

insert into cargo (nome_cargo, descricao_cargo) values
('Analista de Sistemas Junior', 'Desenvolver atividade 1'),
('Suporte Técnco', 'Desenvolver atividade 2'),
('Gerente Financeiro', 'Desenvolver atividade 3'),
('Recpcionista', 'Desenvolver atividade 4'),
('Desenvolvedor', 'Desenvolver atividade 5'),
('Analista de Sistemas Pleno', 'Desenvolver atividade 6'),
('Motorista', 'Desenvolver atividade 7'),
('Advogado', 'Desenvolver atividade 8');

select * from cargo;

insert into vaga (cargo_vaga, setor_vaga, id_vaga, periodo, experiencia, salario, descricao_vaga,endereco_vaga, cidade_vaga, remoto, status_vaga) values 
('Analista de Sistemas Junior', 'Tecnologia e Informação', default, 'Integral', 'Sim', 1450.22, 'Fatec-Testes', 'Rua Ribeirão do Vidoca 238 - Altos da Vila Paiva', 'São José dos Campos', 'Sim', 'Aberta'),
('Advogado', default, 'Integral', 'Jurídico', 'Sim', 8250.50, 'Fatec-Testes', 'Rua Ribeirão do Vidoca 238 - Altos da Vila Paiva', 'São José dos Campos', 'Não', 'Aberta'),
('Motorista', default, 'Noturno', 'Transporte', 'Sim', 1200.00, 'Fatec-Testes', 'Rua Ribeirão do Vidoca 231 - Altossss da Vila Paiva', 'São José dos Campos', 'Sim', 'Aberta'),
('Recpcionista', default, 'Manhã', 'Atendimento', 'Sim', 1100.22, 'Fatec-Testes', 'Rua Ribeirão do Vidoca 270 - Altosxxx da Vila Paiva', 'São José dos Campos', 'Não', 'Encerrada');

select * from vaga;
 







