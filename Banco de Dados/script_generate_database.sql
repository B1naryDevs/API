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
funcao ENUM ('Administrador', 'Publicador'),
nivel_acesso ENUM('1', '2'),
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
('Pro4TECH', 'São Paulo', '15999999999');

#ADICIONAR FUNCIONARIO
insert into funcionario(empresa, nome_func, email, senha, cpf, telefone, funcao, nivel_acesso) values
("Pro4TECH", "Administrador", "Adm@123", "202cb962ac59075b964b07152d234b70", 12147865201, 12996141485, "Administrador", 1);

# ADICIONAR VAGAS DE EMPREGO
insert into vaga (cargo_vaga, empresa_vaga, setor_vaga, id_vaga, periodo, experiencia, salario, descricao_vaga,endereco_vaga, cidade_vaga, remoto, status_vaga) values 
('Recepcionista', 'Pro4Tech', 'Atendimento', default, 'Manhã', 'Não', 1250.22, 'Corta o zap', 'Rua AIDE Josefa Andrade Diacov 23 Bosque dos Ipês', 'São José dos Campos', 'Não', 'Encerrada'),
('Desenvolvedor', 'Pro4TECH', 'Tecnologia e Informação', default, 'Manhã', 'Sim', 3500.00, 'Desenvolver sites e aplicativos.', 'Rua Celso Júnior 45 - Jardim das Estrelas', 'São José dos Campos', 'Sim', 'Aberta'),
('Motorista', 'Pro4Tech', 'Transporte', default, 'Integral', 'Sim', 2000.00, 'Transporte de cargas alimenticias.', 'Rua Maria Silva Medeiros 45 - Paraiso da Lua', 'São José dos Campos', 'Não', 'Encerrada'),
('Suporte Técnico', 'Pro4Tech', 'Tecnologia e Informação', default, 'Tarde', 'Não', 900.00, 'Prestar serviços de suporte ao usuário.', 'Rua Galo Preto 421 Velho Horizonte', 'São José dos Campos', 'Sim', 'Aberta');
