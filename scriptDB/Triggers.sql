--Trigger para atualizar o valor total na tabela pedidos, calculando o valor
--do produto com a quantidade que foi comprada

CREATE OR REPLACE FUNCTION atualizar_valor_total()
RETURNS TRIGGER AS $$
DECLARE
    total_pedido DECIMAL;
BEGIN
    -- Calcula o novo valor total para o pedido
    SELECT SUM(p.preco * pp.quantidade) INTO total_pedido
    FROM Produtos p
    INNER JOIN Pedidos_produtos pp ON p.produto_id = pp.produto_id
    WHERE pp.pedido_id = NEW.pedido_id;

    -- Atualiza o valor_total na tabela Pedidos
    UPDATE Pedidos SET valor_total = total_pedido WHERE pedido_id = NEW.pedido_id;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER atualizar_valor_total_trigger
AFTER INSERT ON Pedidos_produtos
FOR EACH ROW
EXECUTE FUNCTION atualizar_valor_total();