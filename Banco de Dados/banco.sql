drop database api; 

create database api
default character set utf8
default collate utf8_general_ci;

use api;

# TABELAS SÓLIDAS ---------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------

CREATE TABLE candidato(
nome_candidato varchar(30) not null,
cpf bigint (11) not null,
data_nasc date not null,
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
id_cargo int(5) auto_increment unique,
setor_cargo varchar(40) not null,
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

CREATE TABLE setor(
nome_setor varchar (40) not null,
primary key (nome_setor)
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

# CHAVE ESTRANGEIRA FK - NOME SETOR PARA SETOR DO CARGO
ALTER TABLE cargo ADD FOREIGN KEY (setor_cargo) REFERENCES setor (nome_setor);


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

UPDATE cargo SET nome_cargo = 'Recepcionista' where id_cargo = 4;

select * from cargo;

insert into vaga (cargo_vaga, setor_vaga, id_vaga, periodo, experiencia, salario, descricao_vaga,endereco_vaga, cidade_vaga, remoto, status_vaga) values 
('Recepcionista', 'Atendimento', default, 'Manhã', 'Não', 1250.22, 'Corta o zap', 'Rua AIDE Josefa Andrade Diacov 23 Bosque dos Ipês', 'São José dos Campos', 'Sim', 'Encerrada');

UPDATE vaga SET remoto = 'Não' where cargo_vaga = 'Recepcionista';

select * from vaga;

insert into candidato (nome_candidato, cpf, data_nasc, pret_salarial) values
('Gabriel', 69696969669, '2003-12-17', 200.50),
('Carlos', 55555555555, '1950-08-16', 20000.50),
('Wallace', 01010101011, '2002-04-05', 1800.70),
('Guilherme', 46336936899, '1997-11-18', 1500.80),
('Larissa', 48615448696, '2000-05-19', 1500.80);

select * from candidato;

update candidato set nome_candidato = 'Gabriel Vieira' where cpf = 69696969669;

insert into experiencia_profissional(id_cargo, cpf_candidato_exp, cargo_exercido, inicio_exp, termino_exp, cargo_atual, desc_atividades) values
(default, 69696969669, 'Desenvolvedor', '2022-08-01', '2022-09-28', 'Não', 'Desenvolver Programas'),
(default, 55555555555, 'Master', '2000-08-01', '2022-09-28', 'Sim', 'Comandar o time de desenvolvimento'),
(default,01010101011 , 'Desenvolvedor Senior', '2022-08-01', '2022-09-28', 'Sim', 'Desenvolver Programas'),
(default, 48615448696, 'PO', '2022-08-01', '2022-09-28', 'Sim', 'Passar a Visão do Cliente para a Equipe');


select * from experiencia_profissional;

delete from experiencia_profissional where id_cargo = 2;

insert into formacao (id_formacao, cpf_candidato_form, instituicao, curso, inicio_curso, termino_curso, incompleto) values
(default, 69696969669, 'Fatec', 'BD', '2022-02-22', '2024-12-12', 'Não'),
(default, 69696969669, 'Fatec', 'BD', '2022-02-22', '2024-12-12', 'Não'),
(default, 55555555555, 'Fatec', 'BD', '2022-02-22', '2025-12-22', 'Sim'),
(default, 55555555555, 'Fatec', 'BD', '2022-02-12', '2025-12-22', 'Sim'),
(default, 55555555555, 'Fatec', 'BD', '2020-02-22', '2025-12-22', 'Sim');

select * from formacao;

update formacao set curso = 'Logistica' where id_formacao = 2;
delete from formacao where cpf_candidato_form = 55555555555;

insert into competencia (id_comp, cpf_candidato_comp, nome_comp, area_comp, nivel) values
(default, 69696969669, 'MySQL', 'Tecnologia e Informação', 'Básico'),
(default, 69696969669, 'Java', 'Tecnologia e Informação', 'Intermediário'),
(default, 55555555555, 'Python', 'Tecnologia e Informação', 'Avançado'),
(default, 46336936899, 'Excel', 'Tecnologia e Informação', 'Básico'),
(default, 48615448696, 'Word', 'Tecnologia e Informação', 'Intermediário');

insert into cargo (nome_cargo, id_cargo, descricao_cargo) values
('Desenvolvedor Full-Stack', default, 'Tecnologia e Informação'),
('Motorista', default, 'Transporte'),
('Recepcionista', default, 'Atendimento'),
('Vigilante', default, 'Segurança');

select * from cargo;

describe cargo;
insert into vaga (cargo_vaga, setor_vaga, id_vaga, periodo, experiencia, salario, descricao_vaga, endereco_vaga, cidade_vaga, remoto, status_vaga) value
('Telefonista', 'Atendimento', default, 'Integral', 'Sim', 1300.00, 'teste', 'rua 1' , 'cidade 1', 'Sim', 'Aberta'),
('Contador', 'Financeiro', default, 'Integral', 'Sim', 2800.00, 'teste', 'rua 1' , 'cidade 1', 'Sim', 'Aberta'),
('Tecnico em Marketing', 'publicidade', default, 'Integral', 'Sim', 3500.00, 'teste', 'rua 1' , 'cidade 1', 'Sim', 'Aberta');

select * from candidatura;

insert into setor(nome_setor) values
('Transporte'),
('Tecnologia e Informação'),
('Jurídico'),
('Atendimento'),
('Publicidade'),
('Financeiro');

select * from setor;
insert into candidatura(id_candidatura, cpf_candidatura, cod_vaga, data_cand, status_cand) values
(default, '48615448696', 5, '2022-09-30', 'Em andamento' ),
(default, '01010101011', 6, '2022-09-30', 'Em andamento' ),
(default, '48615448696', 7, '2022-09-30', 'Em andamento' ),
(default, '69696969669', 5, '2022-09-30', 'Em andamento' );


describe vaga;

select * from vaga;

# TESTE DE SELECTS PARA RETORNO DE DADOS ----------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------

select * from cargo order by nome_cargo; # ordem alfabética ou crescente (desc - descrescente)
select nome_candidato, pret_salarial from candidato order by pret_salarial; # restrição de campos
select * from competencia where cpf_candidato_comp = 55555555555; # valores especificos
select nome_candidato, pret_salarial from candidato where pret_salarial > 1200.00 order by pret_salarial; #condição lógica
select gafanhotos.nome, gafanhotos.cursopreferido, cursos.nome_curso, cursos_ano from gafanhotos join cursos;
select candidato.nome_candidato, candidatura.cpf_candidatura, candidatura.cargo_cand from candidato join candidatura;







