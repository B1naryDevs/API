CREATE USER 'binary'@'localhost' IDENTIFIED BY 'binary123';
GRANT ALL PRIVILEGES ON * . * TO 'binary'@'localhost';

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

CREATE TABLE rh (
    nome_rh VARCHAR(40) NOT NULL, #NOME_RH - EMPRESA
    local_rh VARCHAR(40) NOT NULL,
    telefone bigint (11) NOT NULL,
    PRIMARY KEY (nome_rh)
); 

CREATE TABLE funcionario (
empresa VARCHAR(40),
nome_func VARCHAR(60) not null,
email VARCHAR(40) NOT NULL UNIQUE,
senha VARCHAR(40) NOT NULL,
cpf BIGINT(11) NULL,
telefone BIGINT NOT NULL,
funcao ENUM ('Administrador', 'Publicador') not null,
nivel_acesso ENUM('1', '2') NOT NULL,
primary key (cpf)
);

CREATE TABLE setor (
    nome_setor VARCHAR(40) NOT NULL,
    PRIMARY KEY (nome_setor)
);

CREATE TABLE vaga (
    cargo_vaga VARCHAR(32) NOT NULL,
    empresa_vaga VARCHAR(40) NOT NULL,
    setor_vaga VARCHAR(30) NOT NULL,
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
	empresa_candidatura VARCHAR(40) NOT NULL,
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

# CHAVE ESTRANGEIRA FK - EMPRESA PARA RH
ALTER TABLE funcionario ADD FOREIGN KEY (empresa) REFERENCES rh (nome_rh);

# CHAVE ESTRANGEIRA FK - EMAIL DE USUARIO
ALTER TABLE usuario ADD FOREIGN KEY (cpf_candidato_usu) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - EMPRESA´PARA VAGA
ALTER TABLE vaga ADD FOREIGN KEY (empresa_vaga) REFERENCES rh (nome_rh);

# CHAVE ESTRANGEIRA FK - CARGO PARA VAGA 
ALTER TABLE vaga ADD FOREIGN KEY (cargo_vaga) REFERENCES cargo (nome_cargo);

# CHAVE ESTRANGEIRA FK - CPF DO CANDIDATO PARA CANDIDATURA
ALTER TABLE candidatura ADD FOREIGN KEY (cpf_candidatura) REFERENCES candidato (cpf);

# CHAVE ESTRANGEIRA FK - CODIGO DA VAGA PARA CANDIDATURA
ALTER TABLE candidatura ADD FOREIGN KEY (cod_vaga) REFERENCES vaga (id_vaga);

# CHAVE ESTRANGEIRA FK - CARGO DA CANDIDATURA PARA CARGO 
ALTER TABLE candidatura ADD FOREIGN KEY (cargo_candidatura) REFERENCES cargo(nome_cargo);

# CHAVE ESTRANGEIRA FK - CANDIDATURA PARA EMPRESA
ALTER TABLE candidatura ADD FOREIGN KEY (empresa_candidatura) REFERENCES rh(nome_rh);

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

# ADICIONAR SETORES
insert into setor(nome_setor) values 
('Transporte'),
('Tecnologia e Informação'),
('Jurídico'),
('Atendimento'),
('Publicidade'),
('Financeiro');

# ADICIONAR CARGOS
insert into cargo (nome_cargo, setor_cargo) values 
('DESENVOLVEDOR BACK-END', 'Tecnologia e Informação'),
('DESENVOLVEDOR FRONT-END', 'Tecnologia e Informação'),
('Analista de Sistemas Junior', 'Tecnologia e Informação'),
('Suporte Técnico', 'Tecnologia e Informação'),
('Gerente Financeiro', 'Financeiro'),
('Recepcionista', 'Atendimento'),
('Desenvolvedor', 'Tecnologia e Informação'),
('Analista de Sistemas Pleno', 'Tecnologia e Informação'),
('Motorista', 'Transporte'),
('Advogado', 'Jurídico');

#ADICIONAR RH
insert into rh (nome_rh, local_rh, telefone) values
('Atlanta Construções', 'Porto Alegre', '15999999999'),
('Irmãos Ademar', 'Fortaleza', '15999999999'),
('CPX Outleet', 'Guarulhos', '15999999999'),
('Pro4TECH', 'São Paulo', '15999999999');

#ADICIONAR FUNCIONARIO
insert into funcionario(empresa, nome_func, email, senha, cpf, telefone, funcao, nivel_acesso) values
("Pro4TECH", "Carlos Aparecido", "carlos@gmail.com", "Troca@123", 12147865201, 12996141485, "Administrador", 1),
("Pro4TECH", "Soares Silva", "Soares@gmail.com", "Troca@123", 12147865204, 1239132458, "Administrador", 1),
("Pro4TECH", "Bruno Souza", "Bruno@gmail.com", "Troca@123", 12147865202, 12997841475, "Administrador", 1);

# ADICIONAR VAGAS DE EMPREGO
insert into vaga (cargo_vaga, empresa_vaga, setor_vaga, id_vaga, periodo, experiencia, salario, descricao_vaga,endereco_vaga, cidade_vaga, remoto, status_vaga) values 
('Recepcionista', 'Irmãos Ademar', 'Atendimento', default, 'Manhã', 'Não', 1250.22, 'Corta o zap', 'Rua AIDE Josefa Andrade Diacov 23 Bosque dos Ipês', 'São José dos Campos', 'Não', 'Encerrada'),
('Desenvolvedor', 'Pro4TECH', 'Tecnologia e Informação', default, 'Manhã', 'Sim', 3500.00, 'Desenvolver sites e aplicativos.', 'Rua Celso Júnior 45 - Jardim das Estrelas', 'São José dos Campos', 'Sim', 'Aberta'),
('Motorista', 'Atlanta Construções', 'Transporte', default, 'Integral', 'Sim', 2000.00, 'Transporte de cargas alimenticias.', 'Rua Maria Silva Medeiros 45 - Paraiso da Lua', 'São José dos Campos', 'Não', 'Encerrada'),
('Suporte Técnico', 'CPX Outleet', 'Tecnologia e Informação', default, 'Tarde', 'Não', 900.00, 'Prestar serviços de suporte ao usuário.', 'Rua Galo Preto 421 Velho Horizonte', 'São José dos Campos', 'Sim', 'Aberta');

#ADICIONAR VAGA DE CANDIDATOS
insert into candidato (nome_candidato, cpf, data_nasc, telefone, pret_salarial) values 
('Gabriel', 69696969669, '2003-12-17', 12992545421, 200.50),
('Carlos', 55555555555, '1950-08-16', 12991475203, 20000.50),
('Wallace', 01010101011, '2002-04-05', 12998521461, 1800.70),
('Guilherme', 46336936899, '1997-11-18', 12996782154, 1500.80),
('Larissa', 48615448696, '2000-05-19', 12997252541, 1500.80);

# ADICIONAR EXPERIENCIA
insert into experiencia_profissional(id_cargo, cpf_candidato_exp, cargo_exercido, inicio_exp, termino_exp, cargo_atual, desc_atividades) values
(default, 69696969669, 'Desenvolvedor', '2022-08-01', '2022-09-28', 'Não', 'Desenvolver Programas'),
(default, 55555555555, 'Master', '2000-08-01', '2022-09-28', 'Sim', 'Comandar o time de desenvolvimento'),
(default,01010101011 , 'Desenvolvedor Senior', '2022-08-01', '2022-09-28', 'Sim', 'Desenvolver Programas'),
(default, 48615448696, 'PO', '2022-08-01', '2022-09-28', 'Sim', 'Passar a Visão do Cliente para a Equipe');

# ADICIONAR FORMACAO ACADEMICA
insert into formacao (id_formacao, cpf_candidato_form, instituicao, curso, inicio_curso, termino_curso, incompleto) values
(default, 69696969669, 'Fatec', 'BD', '2022-02-22', '2024-12-12', 'Não'),
(default, 69696969669, 'Fatec', 'BD', '2022-02-22', '2024-12-12', 'Não'),
(default, 55555555555, 'Fatec', 'BD', '2022-02-22', '2025-12-22', 'Sim'),
(default, 55555555555, 'Fatec', 'BD', '2022-02-12', '2025-12-22', 'Sim'),
(default, 55555555555, 'Fatec', 'BD', '2020-02-22', '2025-12-22', 'Sim');

# ADICIONAR COMPETENCIA
insert into competencia (id_comp, cpf_candidato_comp, nome_comp, area_comp, nivel) values
(default, 69696969669, 'MySQL', 'Tecnologia e Informação', 'Básico'),
(default, 69696969669, 'Java', 'Tecnologia e Informação', 'Intermediário'),
(default, 55555555555, 'Python', 'Tecnologia e Informação', 'Avançado'),
(default, 46336936899, 'Excel', 'Tecnologia e Informação', 'Básico'),
(default, 48615448696, 'Word', 'Tecnologia e Informação', 'Intermediário');

#ADICIONAR CANDIDATURA
insert into candidatura(empresa_candidatura, cargo_candidatura, id_candidatura, cpf_candidatura, cod_vaga, data_cand, status_cand) values
('CPX Outleet', 'Suporte Técnico', default, '01010101011',4, '2022-09-30', 'Contratado' ),
('Pro4TECH', 'Desenvolvedor', default, '48615448696', 2, '2022-09-30', 'Em andamento' ),
('Atlanta Construções', 'Motorista', default, '69696969669', 3, '2022-09-30', 'Entrevista Presencial' ),
('Atlanta Construções', 'Motorista', default, '01010101011', 3, '2022-09-30', 'Desclassificado' ),
('Pro4TECH', 'Desenvolvedor', default, '01010101011', 2, '2022-09-30', 'Entrevista Online' );

insert into usuario (email, senha, cpf_candidato_usu) values 
('Adm@123', '123', 48615448696 );
