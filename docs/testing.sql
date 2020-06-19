-- dados de teste
use jlanches;

INSERT INTO estado(id, sigla, nome) VALUES (DEFAULT, "RS", "Rio Grande do Sul");
INSERT INTO cidade (id, nome, estado_id) values (DEFAULT, 'Lajeado', 1);
INSERT INTO cidade (id, nome, estado_id) values (DEFAULT, 'Teutônia', 1);
INSERT INTO cidade (id, nome, estado_id) values (DEFAULT, 'Estrela', 1);
INSERT INTO contato(fone, email) VALUES (99999999999, 'teste@teste');
INSERT INTO franquia(endereco, ativo, cidade_id) 
	VALUES ('teste', DEFAULT, 1);
INSERT INTO funcionario(nome, senha, ativo, cidade_id, franquia_id, contato_id, cpf, administrador) 
	VALUES ('teste', MD5('qwe123'), DEFAULT, 1, 1, 1, '99999999999', TRUE);
INSERT INTO categoria(id, nome)
	VALUES (
		DEFAULT, 
        'doces'
	);

INSERT INTO lanche(id, nome, ingredientes, valor, disponivel, categoria_id)
	VALUES (
		DEFAULT, 
        'bolinho', 
        'farinha, açúcar, fermento, óleo e canela', 
        '15.00', 
        DEFAULT, 
        1
	);

INSERT INTO lanche(id, nome, ingredientes, valor, disponivel, categoria_id)
	VALUES (
		DEFAULT, 
        'porção de calça virada', 
        'água, farinha, fermento, sal, açúcar, canela',
        '22',
        DEFAULT,
        1
	);

INSERT INTO lanche(id, nome, ingredientes, valor, disponivel, categoria_id)
	VALUES (
		DEFAULT, 
        'trufa caseira', 
        'chocolate, frutas, leite condensado',
        '.75',
        DEFAULT,
        1
	);
    
SELECT * FROM lanche;

INSERT INTO estado(id, sigla, nome) VALUES (DEFAULT, "SP", "São Paulo");
INSERT INTO cidade(id, nome, estado_id) VALUES (DEFAULT, "São Paulo", 2);
INSERT INTO cidade(id, nome, estado_id) VALUES (DEFAULT, "Guarulhos", 2);
INSERT INTO cidade(id, nome, estado_id) VALUES (DEFAULT, "Gramado", 1);

