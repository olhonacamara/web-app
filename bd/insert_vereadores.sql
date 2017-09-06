SELECT * FROM vereadores;
DELETE FROM vereadores where id = 3;
ALTER TABLE vereadores AUTO_INCREMENT = 1;


INSERT INTO vereadores (nome, apelido, data_nascimento, sexo, grau_instrucao, cor_raca, foto, telefone, email, site, partido, total_votos, inicio_mandato, fim_mandato)
values 
('AFRÂNIO TADEU BOPPRÉ', '', '1960-10-30 08:00:00', 'M', 'Superior Completo', 'Branca', 
null, '(48) 3027-5791', 'afranio@cmf.sc.gov.br', null, 'PSOL', 5432, '2017-01-01 08:00:00', '2020-12-31 23:59:59');

