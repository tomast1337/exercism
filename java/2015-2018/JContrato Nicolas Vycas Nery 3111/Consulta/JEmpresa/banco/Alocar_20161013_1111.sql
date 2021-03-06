-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.47-0+deb8u1


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema BdAlocar
--

CREATE DATABASE IF NOT EXISTS BdAlocar;
USE BdAlocar;
CREATE TABLE  `BdAlocar`.`Aloca` (
  `Matricula` int(11) unsigned NOT NULL,
  `Codigo` int(11) unsigned NOT NULL,
  `Descricao` varchar(40) NOT NULL,
  `Duracao` int(11) NOT NULL,
  `Financiado` tinyint(1) NOT NULL,
  PRIMARY KEY (`Matricula`,`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE  `BdAlocar`.`Funcionario` (
  `Matricula` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cargo` varchar(20) NOT NULL,
  `Salario` float NOT NULL,
  `Ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`Matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE  `BdAlocar`.`Projeto` (
  `Codigo` int(11) NOT NULL,
  `Descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
