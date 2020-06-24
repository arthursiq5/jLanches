-- consults
USE jlanches;

SELECT * FROM cidade;

SELECT * FROM estado;

SELECT c.nome AS nome_cidade, e.sigla AS estado_sigla
	FROM cidade AS c INNER JOIN estado AS e
    ON
		c.estado_id = e.id
	ORDER BY e.id ASC;

SELECT estado.sigla AS sigla_do_estado, (
		SELECT COUNT(*)
			FROM cidade
            where cidade.estado_id = estado.id
	) AS cidades_por_estado
	FROM estado;
    
SELECT * FROM funcionario;
SELECT * FROM franquia;
SELECT * FROM contato;

SELECT 
	f.cpf, 
    f.nome, 
    IF(administrador = TRUE, 'administrador', 'comum') AS eh_administrador,
    endereco,
    (SELECT c.nome FROM cidade AS c WHERE f.cidade_id = c.id) AS cidade,
    (SELECT CONCAT('Franquia ', fr.id, ' de ', (
		SELECT cidade.nome FROM cidade WHERE fr.cidade_id = cidade.id
    )) as franquia FROM franquia AS fr WHERE f.cidade_id = fr.id ) AS franquia,
    (SELECT fone FROM contato where contato.id = f.contato_id) AS fone,
    (SELECT email FROM contato where contato.id = f.contato_id) AS email
FROM funcionario AS f
WHERE f.ativo = TRUE;