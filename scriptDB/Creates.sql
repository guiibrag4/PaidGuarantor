CREATE SCHEMA fiado_pago;

SET search_path to fiado_pago;

CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    email VARCHAR (150) NOT NULL,
    senha VARCHAR (25) NOT NULL,
    nome VARCHAR (60) NOT NULL,
    telefone VARCHAR (25) NOT NULL
);

CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nome VARCHAR (60) NOT NULL,
    cpf VARCHAR (12) NOT NULL,
    telefone VARCHAR (25) NOT NULL,
    endereco_cobranca VARCHAR (100) NOT NULL
);

CREATE TABLE pedidos (
    pedido_id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,    
    data_pedido VARCHAR (50),
    valor_total DECIMAL (10,2) 
);

CREATE TABLE pedidos_produtos (
    pedido_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    CONSTRAINT pk_pedidos_produtos PRIMARY KEY (pedido_id, produto_id)
);

CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR (50) NOT NULL,
    preco DECIMAL (10,2)
);

--Inserção das foreign keys

ALTER TABLE pedidos
    add constraint fk_pedido_cliente
        FOREIGN KEY (cliente_id) REFERENCES clientes (cliente_id);

ALTER TABLE pedidos_produtos
    add constraint fk_pedidoproduto_pedido
        FOREIGN KEY (pedido_id) REFERENCES pedidos (pedido_id);

ALTER TABLE pedidos_produtos
    add constraint fk_pedidoproduto_produto
        FOREIGN KEY (produto_id) REFERENCES produtos (produto_id);


/* Perguntar ao professor se ao invés de no java adicionar um método "AtualizarQuantidade
Produto eu poderia apagar esse método e criar no banco de dados um Trigger que toda vez que
o produto for atualizado " */