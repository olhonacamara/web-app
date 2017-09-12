SELECT * FROM vereadores;
DELETE FROM vereadores where id = 3;
ALTER TABLE vereadores AUTO_INCREMENT = 1;
UPDATE vereadores SET telefone = '(48) 3027-5776' WHERE id = 5;
SELECT * from vereadores WHERE nome_completo = 'AFRÂNIO TADEU BOPPRÉ';
UPDATE vereadores set partido = 'PSD' WHERE id = 5;

-- Insert vereadores
INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('AFRÂNIO TADEU BOPPRÉ', '', '1960-10-30 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5791', 'afranio@cmf.sc.gov.br', null, 'PSOL', 5432, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('BRUNO ANDRE DE SOUZA', 'BRUNO SOUZA', '1984-08-20 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5727', 'gabinetebrunosouza@gmail.com', null, 'PSB', 3326, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('CELSO FRANCISCO SANDRINI', 'CELSO SANDRINI', '1960-10-10 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5727', 'gabinetebrunosouza@gmail.com', null, 'PMDB', 2017, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('CLAUDINEI MARQUES', '', '1976-02-19 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5896', 'gabineteclaudineimarques@gmail.com', null, 'PRB', 3346, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('DALMO DEUSDEDIT MENESES', 'DALMO MENESES', '1951-07-19 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5776', 'dalmo@cmf.sc.gov.br', null, 'PRB', 2670, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('EDINON MANOEL DA ROSA', 'DINHO', '1962-11-13 08:00:00', 'M', 'Ensino Médio Completo', 'Branca',
null, '(48) 3027-5764', 'dinho.pmdb@gmail.com', null, 'PMDB', 2400, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

-- 12/09 18/05/1952

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('EDSON LEMOS', 'EDINHO LEMOS', '1964-04-05 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5740', 'edinholemos@cmf.sc.gov.br', null, 'PSDB', 2766, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('ERÁDIO MANOEL GONÇALVES', 'ERÁDIO GONÇALVES', '1952-05-18 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5873', 'assessoria.vereadoreradio@gmail.com', null, 'PSD', 2708, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('FÁBIO GOMES BRAGA', 'FÁBIO BRAGA', '1981-10-06 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5880', 'assessoriafabiobraga@gmail.com', null, 'PTB', 1747, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('GUILHERME PEREIRA DE PAULO', 'GUI PEREIRA', '1976-07-19 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5850', 'guipereira@cmf.sc.gov.br', null, 'PR', 4349, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('JEFERSON RICHTER BACKER', 'JEFERSON BACKER', '1981-05-14 08:00:00', 'M', 'Superior Completo', 'Branca',
null, null, null, null, 'PSDB', 1773, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('JOÃO LUIZ DA SILVEIRA', 'JOÃO LUIZ DA BEGA', '1967-07-20 08:00:00', 'M', 'Superior Completo', 'Branca',
null, '(48) 3027-5858', 'joaoluiz@cmf.sc.gov.br', null, 'PSC', 2079, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('LINO FERNANDO BRAGANÇA PERESA', 'LINO PERES', '1951-12-27 08:00:00', 'M', 'Superior Completo', 'Preta',
null, '(48) 3027-5721', 'linoperes13@gmail.com', null, 'PT', 2777, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('MAIKON DA COSTA', 'MAIKON COSTA', '1983-12-27 08:00:00', 'M', 'Superior Incompleto', 'Branca',
null, '(48) 3027-5805', 'contato@maikoncostavereador.com.br', null, 'PSDB', 2566, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('MARCELO FERNANDO DE OLIVEIRA', 'MARCELO DA INTENDÊNCIA', '1967-09-21 08:00:00', 'M', 'Superior Incompleto', 'Branca',
null, '(48) 3027-5852', 'marcelointendencia@cmf.sc.gov.br', null, 'PP', 3162, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao,
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES
('MARIA DA GRAÇA OLIVEIRA DUTRA', 'MARIA DA GRAÇA', '1949-07-12 08:00:00', 'F', 'Superior Completo', 'Branca',
null, '(48) 3027-5746', 'gabinetemariadagraca@gmail.com', null, 'PMDB', 2116, '2017-01-01 08:00:00', '2020-12-31 23:59:59');
