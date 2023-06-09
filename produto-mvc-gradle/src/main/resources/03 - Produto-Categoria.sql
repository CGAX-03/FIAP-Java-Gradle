-- APAGA VERSOES ANTERIORES SE EXISTIR
DROP TABLE tb_produto

CREATE TABLE tb_produto (
    id               NUMBER(10) GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    nome             VARCHAR2(256),
    sku              VARCHAR2(256),
    descricao        VARCHAR2(256),
    caracteristicas  VARCHAR2(256),
    preco            NUMBER(10, 2),
    id_categoria     NUMBER(10) NOT NULL,
    CONSTRAINT FK_ID_CATEGORIA FOREIGN KEY (id_categoria) REFERENCES tb_categoria(id_categoria)
)

-- INSERE VALORES DE TESTE
INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, ID_CATEGORIA) VALUES ('Nome do produto 1', 'sku-0001', 'Descrição do Produto 1', 'Características do produto 1', 1.99, 1);
INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, ID_CATEGORIA) VALUES ('Nome do produto 2', 'sku-0002', 'Descrição do Produto 2', 'Características do produto 2', 2.99, 2);
INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, ID_CATEGORIA) VALUES ('Nome do produto 3', 'sku-0003', 'Descrição do Produto 3', 'Características do produto 3', 3.99, 3);
INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, CARACTERISTICAS, PRECO, ID_CATEGORIA) VALUES ('Nome do produto 4', 'sku-0004', 'Descrição do Produto 4', 'Características do produto 4', 4.99, 4);

--SELECT COM PRODUTO E CATEGORIA
SELECT P.ID, P.NOME, P.SKU, P.DESCRICAO, P.CARACTERISTICAS, P.PRECO, P.ID_CATEGORIA, C.NOME_CATEGORIA 
FROM TB_PRODUTO P 
INNER JOIN TB_CATEGORIA C
ON P.ID_CATEGORIA = C.ID_CATEGORIA;