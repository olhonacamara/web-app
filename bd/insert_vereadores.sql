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
null, '(48) 3027-5896', 'gabineteclaudineimarques@gmail.com', null, 'PRB', 2017, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

INSERT INTO vereadores (nome_completo, nome_publico, data_nascimento, sexo, grau_instrucao, 
cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
VALUES 
('DALMO DEUSDEDIT MENESES', 'DALMO MENESES', '1951-07-19 08:00:00', 'M', 'Superior Completo', 'Branca', 
null, '(048) 3027-5776', 'dalmo@cmf.sc.gov.br', null, 'PRB', 2017, '2017-01-01 08:00:00', '2020-12-31 23:59:59');
