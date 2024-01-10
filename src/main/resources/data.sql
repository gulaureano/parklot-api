insert into TOTAL_VAGAS (TOTAL_VAGAS) values (200);

insert into PESSOA (CPF, DATA_NASCIMENTO, IS_CLIENTE, IS_LOCADOR, NOME) values ('4876', '1999-10-07', 0, 1, 'Gustavo Laureano');
insert into PESSOA (CPF, DATA_NASCIMENTO, IS_CLIENTE, IS_LOCADOR, NOME) values ('4290', '2001-06-05', 1, 0, 'Bruna Jesus');

insert into CLIENTE (ID_PESSOA) values (2);
insert into LOCADOR (ID_PESSOA) values (1);