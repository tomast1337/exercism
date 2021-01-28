DROP SCHEMA IF EXISTS dblojaroupa;
CREATE SCHEMA IF NOT EXISTS dblojaroupa DEFAULT CHARACTER SET latin1 ;
USE dblojaroupa ;

CREATE TABLE IF NOT EXISTS caixa (
  idCaixa INT(11) NOT NULL,
  Tipo VARCHAR(7),
  PRIMARY KEY (idCaixa))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS cliente (
  endereco VARCHAR(100) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  idCliente INT NOT NULL,
  PRIMARY KEY (idCliente))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS fornecedor (
  idFornecedor INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  PRIMARY KEY (idFornecedor))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS compra (
  idCompra INT NOT NULL,
  Data VARCHAR(10) NULL DEFAULT NULL,
  Pago TINYINT(4) NULL DEFAULT NULL,
  fornecedor_idFornecedor INT NOT NULL,
  caixa_idCaixa INT(11) NOT NULL,
  PRIMARY KEY (idCompra, fornecedor_idFornecedor, caixa_idCaixa),
  INDEX fk_compra_fornecedor1_idx (fornecedor_idFornecedor ASC),
  INDEX fk_compra_caixa1_idx (caixa_idCaixa ASC),
  CONSTRAINT fk_compra_fornecedor1
    FOREIGN KEY (fornecedor_idFornecedor)
    REFERENCES fornecedor (idFornecedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_compra_caixa1
    FOREIGN KEY (caixa_idCaixa)
    REFERENCES caixa (idCaixa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS produto (
  idProduto INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  tipo VARCHAR(10) NOT NULL,
  descricao VARCHAR(50) NOT NULL,
  preco FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (idProduto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS estoque (
  idEstoque INT(11) NOT NULL,
  quantidadeMaxima INT(11) NOT NULL,
  quantidadeMinima INT(11) NOT NULL,
  quantidade INT(11) NOT NULL,
  produto_idProduto INT NOT NULL,
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
  idItenscompra INT(11) NOT NULL,
  quantidade INT(11) NOT NULL,
  compra_idCompra INT NOT NULL,
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

CREATE TABLE IF NOT EXISTS venda (
  idVenda INT(11) NOT NULL,
  dataVenda VARCHAR(10) NULL,
  Pago TINYINT(4) NULL DEFAULT NULL,
  cliente_idCliente INT NOT NULL,
  caixa_idCaixa INT(11) NOT NULL,
  PRIMARY KEY (idVenda, cliente_idCliente, caixa_idCaixa),
  INDEX fk_venda_cliente1_idx (cliente_idCliente ASC),
  INDEX fk_venda_caixa1_idx (caixa_idCaixa ASC),
  CONSTRAINT fk_venda_cliente1
    FOREIGN KEY (cliente_idCliente)
    REFERENCES cliente (idCliente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_venda_caixa1
    FOREIGN KEY (caixa_idCaixa)
    REFERENCES caixa (idCaixa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS itensvenda (
  idItensvenda INT(11) NOT NULL,
  quantidade INT(11) NOT NULL,
  venda_idVenda INT(11) NOT NULL,
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