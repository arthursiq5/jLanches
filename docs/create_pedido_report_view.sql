CREATE VIEW pedido_report_view AS
	SELECT
		pedido.id,
		pedido.ativo,
		pedido.data,
		pedido.pago,
		pedido.forma_de_pagamento,
		pedido.comentarios, 
		(
			SELECT cliente.nome
			FROM cliente
			WHERE cliente.cpf = pedido.cliente_cpf
		) AS cliente_nome,
        (
			SELECT cliente.cpf
			FROM cliente
			WHERE cliente.cpf = pedido.cliente_cpf
		) AS cliente_cpf,
		(
			SELECT CONCAT(
				'Franquia ', 
				f.id, 
				' de ',
				(
					SELECT CONCAT(
						nome,
						'/',
						(
							SELECT sigla
							FROM estado
							WHERE estado.id = cidade.estado_id
						)
					)
					FROM cidade
					WHERE f.cidade_id = cidade.id
				)
			)
			FROM franquia AS f
			WHERE pedido.franquia_id = f.id
		) AS franquia,
		(
			SELECT funcionario.nome
			FROM funcionario
			WHERE 
				funcionario.cpf = pedido.funcionario_cpf
		) AS funcionario_nome,
        (
			SELECT funcionario.cpf
			FROM funcionario
			WHERE 
				funcionario.cpf = pedido.funcionario_cpf
		) AS funcionario_cpf,
		(
			SELECT
			(
				SUM(valor) 
				+ SUM(acrescimo) 
				- SUM(desconto)
			)
			FROM lanche_pedido 
			WHERE lanche_pedido.pedido_id = pedido.id
		) AS valor
	FROM pedido;