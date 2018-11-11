CREATE SCHEMA `practicados`;
USE `practicados`;
CREATE TABLE `equipment`(
  `idequipment` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `dateBuy` date NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`idequipment`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `products` (
  `idproducts` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `dateBuy` date NOT NULL,
  `cost` double NOT NULL,
  `price` double NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `uso` tinyint(4) NOT NULL,
  PRIMARY KEY (`idproducts`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `idrol` int(11) NOT NULL,
  PRIMARY KEY (`idusers`),
  KEY `idx_rol_idx` (`idrol`),
  CONSTRAINT `idx_rol` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
