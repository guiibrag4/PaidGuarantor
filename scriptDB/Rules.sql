--Rule para renomear a coluna nome do cliente, adicionando deleted ao lado de seu nome
--caso o usuário exclua algum cliente do banco de dados. Isso garante a integridade dos
--dados

CREATE OR REPLACE RULE rl_clientes_delete AS ON
    DELETE TO clientes DO INSTEAD 
        UPDATE clientes c SET nome = CONCAT (c.nome, ' ', 'Deleted')
            WHERE OLD.cliente_id = c.cliente_id;