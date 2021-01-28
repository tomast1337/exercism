CREATE SCHEMA IF NOT EXISTS BdLojaRoupa DEFAULT CHARACTER SET latin1 ;
USE BdLojaRoupa ;

-- -----------------------------------------------------
-- Table Cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Cliente (
  codigo INT NOT NULL,
  endereco VARCHAR(100) NULL,
  nome VARCHAR(45) NULL,
  historico VARCHAR(100) NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Venda
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Venda (
  numero INT NOT NULL,
  codProduto INT NOT NULL,
  Data VARCHAR(10) NULL,
  Pago TINYINT NULL,
  Cliente_codigo INT NOT NULL,
  PRIMARY KEY (numero, codProduto, Cliente_codigo),
  INDEX fk_Venda_Cliente1_idx (Cliente_codigo ASC) ,
  CONSTRAINT fk_Venda_Cliente1
    FOREIGN KEY (Cliente_codigo)
    REFERENCES Cliente (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Caixa
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Caixa (
  idCaixa INT NOT NULL,
  PRIMARY KEY (idCaixa))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Estoque
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Estoque (
  codigo INT NOT NULL,
  quantidadeMaxima INT NULL,
  quantidadeMinima INT NULL,
  quantidade INT NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Produto (
  codigo INT NOT NULL,
  nome VARCHAR(45) NULL,
  tipo VARCHAR(10) NULL,
  descricao VARCHAR(50) NULL,
  preco FLOAT NULL,
  Estoque_codigo INT NOT NULL,
  PRIMARY KEY (codigo, Estoque_codigo),
  INDEX fk_Produto_Estoque1_idx (Estoque_codigo ASC) ,
  CONSTRAINT fk_Produto_Estoque1
    FOREIGN KEY (Estoque_codigo)
    REFERENCES Estoque (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ItensVenda
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ItensVenda (
  numero INT NOT NULL,
  quantidade INT NULL,
  codigoProduto INT NOT NULL,
  Venda_Numero INT NOT NULL,
  Venda_CodProduto INT NOT NULL,
  Produto_codigo INT NOT NULL,
  Produto_Estoque_codigo INT NOT NULL,
  PRIMARY KEY (numero, codigoProduto, Venda_Numero, Venda_CodProduto, Produto_codigo, Produto_Estoque_codigo),
  INDEX fk_ItensVenda_Venda1_idx (Venda_Numero ASC, Venda_CodProduto ASC) ,
  INDEX fk_ItensVenda_Produto1_idx (Produto_codigo ASC, Produto_Estoque_codigo ASC) ,
  CONSTRAINT fk_ItensVenda_Venda1
    FOREIGN KEY (Venda_Numero , Venda_CodProduto)
    REFERENCES Venda (numero , codProduto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ItensVenda_Produto1
    FOREIGN KEY (Produto_codigo , Produto_Estoque_codigo)
    REFERENCES Produto (codigo , Estoque_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Fornecedor (
  codigo INT NOT NULL,
  nome VARCHAR(45) NULL,
  telefone VARCHAR(20) NULL,
  quantidadeFornecida INT NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Compra
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Compra (
  numero INT NOT NULL,
  codigoFornecedor INT NOT NULL,
  Data VARCHAR(10) NULL,
  Pago TINYINT NULL,
  Fornecedor_codigo INT NOT NULL,
  PRIMARY KEY (numero, codigoFornecedor, Fornecedor_codigo),
  INDEX fk_Compra_Fornecedor1_idx (Fornecedor_codigo ASC) ,
  CONSTRAINT fk_Compra_Fornecedor1
    FOREIGN KEY (Fornecedor_codigo)
    REFERENCES Fornecedor (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ItensCompra
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ItensCompra (
  numero INT NOT NULL,
  quantidade INT NULL,
  Compra_Numero INT NOT NULL,
  Compra_CodigoFornecedor INT NOT NULL,
  Produto_codigo INT NOT NULL,
  Produto_Estoque_codigo INT NOT NULL,
  PRIMARY KEY (numero, Compra_Numero, Compra_CodigoFornecedor, Produto_codigo, Produto_Estoque_codigo),
  INDEX fk_ItensCompra_Compra1_idx (Compra_Numero ASC, Compra_CodigoFornecedor ASC) ,
  INDEX fk_ItensCompra_Produto1_idx (Produto_codigo ASC, Produto_Estoque_codigo ASC) ,
  CONSTRAINT fk_ItensCompra_Compra1
    FOREIGN KEY (Compra_Numero , Compra_CodigoFornecedor)
    REFERENCES Compra (numero , codigoFornecedor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_ItensCompra_Produto1
    FOREIGN KEY (Produto_codigo , Produto_Estoque_codigo)
    REFERENCES Produto (codigo , Estoque_codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
