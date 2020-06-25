use jlanches;
describe funcionario;
SELECT MD5('teste') as s1, MD5('teste') as s2;
SELECT SHA2('TESTE', 256);
SELECT SHA2('TESTE', 512), LENGTH(SHA2('TESTE', 512));
SELECT SHA2('TESTE', 1000);

INSERT INTO funcionario(cpf, nome, senha, cidade_id, contato_id, franquia_id)
	VALUES (
		'25625625625',
		'Fulano',
        SHA2('TESTE', 256),
        1,
        1,
        1
    );

    
select cpf, nome, senha from funcionario;

select SHA2(SHA2(MD5('senha_do_usuario'), 256), 512);