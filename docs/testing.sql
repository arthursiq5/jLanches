-- dados de teste
use jlanches;

insert into estado(id, sigla, nome) values (DEFAULT, "RS", "Rio Grande do Sul");
insert into cidade (id, nome, estado_id) values (DEFAULT, 'Lajeado', 1);
insert into contato(fone, email) values (99999999999, 'teste@teste');
insert into franquia(endereco, ativo, cidade_id) values ('teste', DEFAULT, 1);
insert into funcionario(nome, senha, ativo, cidade_id, franquia_id, contato_id, cpf, administrador) values ('teste', MD5('qwe123'), DEFAULT, 1, 1, 1, '99999999999', TRUE);
