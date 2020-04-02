-- dados de teste
insert into cidade (nome, estado_id) values ('Lajeado', 1);
insert into contato(fone, email) values (99999999999, 'teste@teste');
insert into franquia(endereco, ativo, cidade_id) values ('teste', DEFAULT, 1);
insert into funcionario(nome, nome_usuario, senha, ativo, cidade_id, franquia_id, contato_id, cpf) values ('teste', 'teste', MD5('qwe123'), DEFAULT, 1, 1, 1, 99999999999);
