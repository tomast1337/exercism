DROP SCHEMA IF EXISTS dblojaroupa;
CREATE SCHEMA IF NOT EXISTS dblojaroupa DEFAULT CHARACTER SET latin1 ;
USE dblojaroupa ;

CREATE TABLE IF NOT EXISTS cliente (
  idCliente INT NOT NULL,
  endereco VARCHAR(100),
  nome VARCHAR(45),
  PRIMARY KEY (idCliente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS venda (
  idVenda INT NOT NULL,
  dataVenda VARCHAR(10),
  Pago TINYINT(1),
  cliente_idCliente INT NOT NULL,
  PRIMARY KEY (idVenda, cliente_idCliente),
  INDEX fk_venda_cliente1_idx (cliente_idCliente ASC) ,
  CONSTRAINT fk_venda_cliente1
    FOREIGN KEY (cliente_idCliente)
    REFERENCES cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS fornecedor (
  idFornecedor INT NOT NULL,
  nome VARCHAR(45),
  telefone VARCHAR(20),
  PRIMARY KEY (idFornecedor))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS compra (
  idCompra INT NOT NULL,
  Data VARCHAR(10),
  Pago TINYINT(4),
  fornecedor_idFornecedor INT,
  PRIMARY KEY (idCompra, fornecedor_idFornecedor),
  INDEX fk_compra_fornecedor1_idx (fornecedor_idFornecedor ASC) ,
  CONSTRAINT fk_compra_fornecedor1
    FOREIGN KEY (fornecedor_idFornecedor)
    REFERENCES fornecedor (idFornecedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS caixa (
  idCaixa INT NOT NULL,
  Tipo VARCHAR(7),
  venda_idVenda INT,
  compra_idCompra INT,
  PRIMARY KEY (idCaixa, venda_idVenda, compra_idCompra),
  INDEX fk_caixa_venda1_idx (venda_idVenda ASC) ,
  INDEX fk_caixa_compra1_idx (compra_idCompra ASC) ,
  CONSTRAINT fk_caixa_venda1
    FOREIGN KEY (venda_idVenda)
    REFERENCES venda (idVenda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_caixa_compra1
    FOREIGN KEY (compra_idCompra)
    REFERENCES compra (idCompra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS produto (
  idProduto INT NOT NULL,
  nome VARCHAR(45),
  tipo VARCHAR(10),
  descricao VARCHAR(50),
  preco FLOAT,
  PRIMARY KEY (idProduto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS estoque (
  idEstoque INT NOT NULL,
  quantidadeMaxima INT,
  quantidadeMinima INT,
  quantidade INT,
  produto_idProduto INT,
  PRIMARY KEY (idEstoque, produto_idProduto),
  INDEX fk_estoque_produto1_idx (produto_idProduto ASC) ,
  CONSTRAINT fk_estoque_produto1
    FOREIGN KEY (produto_idProduto)
    REFERENCES produto (idProduto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS itenscompra (
  idItenscompra INT NOT NULL,
  quantidade INT,
  compra_idCompra INT,
  produto_idProduto INT NOT NULL,
  PRIMARY KEY (idItenscompra, compra_idCompra, produto_idProduto),
  INDEX fk_itenscompra_compra1_idx (compra_idCompra ASC) ,
  INDEX fk_itenscompra_produto1_idx (produto_idProduto ASC) ,
  CONSTRAINT fk_itenscompra_compra1
    FOREIGN KEY (compra_idCompra)
    REFERENCES compra (idCompra)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_itenscompra_produto1
    FOREIGN KEY (produto_idProduto)
    REFERENCES produto (idProduto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS itensvenda (
  idItensvenda INT NOT NULL,
  quantidade INT,
  venda_idVenda INT NOT NULL,
  produto_idProduto INT NOT NULL,
  PRIMARY KEY (idItensvenda, venda_idVenda, produto_idProduto),
  INDEX fk_itensvenda_venda1_idx (venda_idVenda ASC) ,
  INDEX fk_itensvenda_produto1_idx (produto_idProduto ASC) ,
  CONSTRAINT fk_itensvenda_venda1
    FOREIGN KEY (venda_idVenda)
    REFERENCES venda (idVenda)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_itensvenda_produto1
    FOREIGN KEY (produto_idProduto)
    REFERENCES produto (idProduto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;